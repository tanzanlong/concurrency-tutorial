package com.tan.concurrent.spinlock;

/**若有同一线程两次调用lock() ，会导致第二次调用lock位置进行自旋，产生了死锁 
 * 说明这个锁并不是可重入的。（在lock函数内，应验证线程是否为已经获得锁的线程）
 * @author LS-0323
 *
 */
public class SpinLockTest implements Runnable{
 private SpinLock lock = new SpinLock(); 
//private SpinLock2 lock = new SpinLock2(); 

  public void get() { 
      lock.lock(); 
      System.out.println(Thread.currentThread().getId()); 
      register(); 
      lock.unlock(); 
  } 

  public void register() { 
      lock.lock(); 
      System.out.println(Thread.currentThread().getId()); 
      lock.unlock(); 
  } 

  @Override 
  public void run() { 
      get(); 
  } 

  public static void main(String[] args) { 
      SpinLockTest spinLockTest = new SpinLockTest(); 
      new Thread(spinLockTest).start(); 
      new Thread(spinLockTest).start(); 
  } 
}
