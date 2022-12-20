package com.linuxea.reference;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * 软引用
 */
public class SoftReferencePerson extends SoftReference<Person> {

  public SoftReferencePerson(Person referent) {
    super(referent);
  }

  public static void main(String[] args){
    SoftReferencePerson softReferencePerson = new SoftReferencePerson(new Person(0, "linuxea", 18));

    System.out.println(softReferencePerson.get());

    /* Force releasing SoftReferences */
    try {
      final List<long[]> list = new LinkedList<>();
      while(true) {
        list.add(new long[1024]);
      }
    }
    catch(final OutOfMemoryError e) {
      /* At this point all SoftReferences have been released - GUARANTEED. */
    }

    Person person = softReferencePerson.get();
    System.out.println(person);


  }



}
