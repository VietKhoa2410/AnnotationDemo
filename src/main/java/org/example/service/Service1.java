package org.example.service;

import org.example.annotation.MyComponent;

@MyComponent(clazz = Service1.class)
public class Service1 {
  public String start(){
    return "This is service 1";
  }
}
