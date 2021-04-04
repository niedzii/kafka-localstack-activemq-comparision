package pl.consumer.service;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class LocalTimeService {

  public LocalTime now() {
    return LocalTime.now();
  }
}
