package org.example.schedule;

import org.springframework.scheduling.annotation.Scheduled;

public class TestSchedule {

  @Scheduled(cron = "0 * * ? * *") // per minute
  @Scheduled(cron = "0 0 * ? * *") // per hour
  public void doSomeThing(){
    // do something
  }
}
