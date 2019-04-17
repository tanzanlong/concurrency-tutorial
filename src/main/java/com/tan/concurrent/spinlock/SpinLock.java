package com.tan.concurrent.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**自旋锁
 * @author LS-0323
 *
 */
public class SpinLock {
	
	private AtomicReference<Thread> owner = new AtomicReference<Thread>(); 
	 
    public void lock() { 
 
        Thread thread = Thread.currentThread(); 
        while (!owner.compareAndSet(null, thread)) { 
        } 
    } 
 
    public void unlock() { 
        Thread thread = Thread.currentThread(); 
        owner.compareAndSet(thread, null); 
    } 
}
