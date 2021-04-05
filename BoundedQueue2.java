import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue2<E> implements IBoundedQueue<E> {
  private final E[] elems;
  private int size;
  private int head;
  private final ReentrantLock qlock = new ReentrantLock();
  private final Condition notEmpty = qlock.newCondition();
  private final Condition notFull = qlock.newCondition();
  
  @SuppressWarnings("unchecked")
  public BoundedQueue2(int capacity) {
    if (capacity <= 0) 
      throw new IllegalArgumentException("Invalid capacity: " + capacity);
    elems = (E[]) new Object[capacity];
    size = 0;
    head = 0;
  }
  
  public void add(E elem) throws InterruptedException {
    qlock.lock();
    try {
      while (size == elems.length) notFull.await();
      elems[(head + size) % elems.length] = elem;
      size++;
      if (size == 1) notEmpty.signal();
    }
    finally {
      qlock.unlock();
    }
  }

  public E remove() throws InterruptedException {
    qlock.lock();
    try {
      while (size == 0) notEmpty.await(); 
      E elem = elems[head];
      head = (head + 1) % elems.length;
      size--;
      notFull.signal();
      return elem;
    }
    finally {
      qlock.unlock();
    }
  }

  public int size() {
    qlock.lock();
    try {
      return size;
    }
    finally {
      qlock.unlock();
    }
  }
  
  public int capacity() {
    return elems.length; // no lock required
  }
}
