package com.example.rxjava.chapter11.repository;

import com.example.rxjava.chapter11.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
