package com.linuxea.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * 虚引用
 */
public class PhantomReferencePerson extends PhantomReference<Person> implements Runnable {


  private final ReferenceQueue<Person> q;
  private final Integer personId;

  public PhantomReferencePerson(Person referent, ReferenceQueue<Person> q) {
    super(referent, q);
    this.q = q;
    this.personId = referent.id;
    new Thread(this).start(); //start a thread to listen queue
  }


  @Override
  public void run() {
    while(true) {
      try {
        // 当有虚引用关系对象时会有通知
        PhantomReferencePerson reference = (PhantomReferencePerson)this.q.remove();
        // 得到通知完成一些清洁后续工作
        reference.cleanUp();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void cleanUp() {
    System.out.println(this.personId + " is over");
    // do some clean up
  }



  public static void main(String[] args) throws InterruptedException {
    PhantomReferencePerson softReferencePerson = new PhantomReferencePerson(new Person(0, "linuxea", 18),
        new ReferenceQueue<>());
    // 虚引用关联对象永远不可达，因此 get 方法永远返回 null
    System.out.println(softReferencePerson.get());

    // never end
    TimeUnit.SECONDS.sleep(1000);
  }
}
