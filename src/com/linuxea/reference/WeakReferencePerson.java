package com.linuxea.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferencePerson extends WeakReference<Person> {

  public WeakReferencePerson(Person referent) {
    super(referent);
  }

  public static void main(String[] args){
    WeakReferencePerson softReferencePerson = new WeakReferencePerson(new Person(0, "linuxea", 18));
    System.out.println(softReferencePerson.get());
    System.gc();
    Person person = softReferencePerson.get();
    System.out.println(person);
  }
}
