package com.example.rxjava.chapter11.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private long weatherId;
    private int temperature;
    private int humidity;

    public Weather(){}
    public Weather(int temperature, int humidity){
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
