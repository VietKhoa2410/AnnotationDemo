package org.example.service;

import lombok.extern.log4j.Log4j2;
import org.example.annotation.MyComponent;

@MyComponent(clazz = Service1.class)
@Log4j2
public class Service1 {
  public void start(){
    log.info("This is service 1");
  }
}
