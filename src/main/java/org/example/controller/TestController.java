package org.example.controller;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Positive;
import org.example.service.Service1;
import org.example.service.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.GenericWebApplicationContext;

@RestController
@Component
public class TestController {
  @Autowired
  private GenericWebApplicationContext applicationContext;

  private Service1 service1;
  private Service2 service2;

  @PostConstruct
  void setup(){
    service1 = applicationContext.getBean(Service1.class);
    service2 = applicationContext.getBean(Service2.class);
  }

  @GetMapping("service1")
  public void callService1(){
     service1.start();
  }

  @GetMapping("service2")
  public void callService2(){
    service2.start();
  }
}
