package org.example.service;

import org.example.annotation.MyComponent;

@MyComponent(clazz = Service2.class)
public class Service2 {
  public void start(){
    System.out.println("This is service 2");
  }
}
