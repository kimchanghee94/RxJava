package com.example.rxjava.chapter11.web;

import com.example.rxjava.chapter11.domain.Weather;
import com.example.rxjava.chapter11.repository.WeatherRepository;
import com.example.rxjava.chapter11.sensor.HumiditySensor;
import com.example.rxjava.chapter11.sensor.TemperatureSensor;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    final long SSE_SESSION_TIMEOUT = 30*60*1000L;

    private final TemperatureSensor temperatureSensor;
    private final HumiditySensor humiditySensor;
    private final WeatherRepository weatherRepository;

    private SseEmitter emitter;
    private List<Disposable> disposables = new ArrayList<>();

    @CrossOrigin("*")
    @GetMapping("/stream/weather")
    public SseEmitter connectWeatherEvents(){
        emitter = new SseEmitter(SSE_SESSION_TIMEOUT);

        ConnectableObservable<Weather> observable =
                Observable.zip(
                        temperatureSensor.getTemperatureStream(),
                        humiditySensor.getHumidityStream(),
                        (temp, humi) -> new Weather(temp, humi)
                ).publish();

        Disposable disposableSend = sendWeatherData(observable);
        Disposable disposableSave = saveWeatherData(observable);

        disposables.addAll(Arrays.asList(disposableSend, disposableSave));

        observable.connect();

        this.dispose(emitter, () ->
                disposables.stream()
                .filter(disposable -> !disposable.isDisposed())
                .forEach(Disposable::dispose));

        return emitter;
    }

    private Disposable sendWeatherData(ConnectableObservable<Weather> observable){
        return observable.subscribe(
                weather -> {
                    emitter.send(weather);
                    Logger.log(LogType.ON_NEXT, weather.getTemperature() + ", " + weather.getHumidity());
                },
                error -> Logger.log(LogType.ON_ERROR, error.getMessage()));
    }

    private Disposable saveWeatherData(ConnectableObservable<Weather> observable){
        return observable.subscribe(
                weather -> weatherRepository.save(weather),
                error -> Logger.log(LogType.ON_ERROR, error.getMessage()));
    }

    private void dispose(SseEmitter emitter, Runnable runnable){
        emitter.onCompletion(runnable);
        emitter.onTimeout(runnable);
    }
}
