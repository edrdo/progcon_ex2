
public class BoundedQueue1<E> implements IBoundedQueue<E>{
  private final E[] elems;
  private int size;
  private int head;
  
  @SuppressWarnings("unchecked")
  public BoundedQueue1(int capacity) {
    if (capacity <= 0) 
      throw new IllegalArgumentException("Invalid capacity: " + capacity);
    elems = (E[]) new Object[capacity];
    size = 0;
    head = 0;
  }
  
  public synchronized void add(E elem) 
  throws InterruptedException {
    while (size == elems.length) { 
      wait(); // queue is full
    }
    elems[(head + size) % elems.length] = elem;
    size++;
    notify();
    
    D.print("add(%s) [size: %d]", elem, size);
  }

  public synchronized E remove() 
  throws InterruptedException {
    while (size == 0) { 
      wait();
    }
    E elem = elems[head];
    head = (head + 1) % elems.length;
    size--;
    notify();
    
    D.print("remove(%s) [size: %d]", elem, size);
    return elem;
  }

  public synchronized int size() {
    return size;
  }
  
  public int capacity() {
    return elems.length; // no lock required
  }
}
