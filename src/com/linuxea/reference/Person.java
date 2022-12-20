package com.linuxea.reference;

public class Person {

  public Person(Integer id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  Integer id;

  String name;

  Integer age;


  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
