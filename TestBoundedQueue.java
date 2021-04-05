import java.util.ArrayList;

public class TestBoundedQueue {
  public static void main(String[] args) throws InterruptedException {
    int capacity =  args.length >= 1 ? Integer.parseInt(args[0]) : 3;
    int n = args.length >= 2 ? Integer.parseInt(args[1]) : 3;
    D.enable();
    test(new BoundedQueue1<>(capacity), n);
    test(new BoundedQueue2<>(capacity), n);
  }

  static void test(IBoundedQueue<Integer> bq, int n) 
  throws InterruptedException {
    ArrayList<Thread> threads = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      threads.add( producer(bq, i) );
      threads.add( consumer(bq, i) );  
    }
    for (Thread t : threads) t.start();
    for (Thread t : threads) t.join();
    D.print("Size at the end: %d", bq.size());
  }
  
  static Thread producer(IBoundedQueue<Integer> bq, int i) {
    Thread t = new Thread(() -> {
      try {
        D.print("Producer adding item ...", i);
        bq.add(i);
        D.print("Producer added %d", i);
      }
      catch (InterruptedException e) {
        throw new RuntimeException("Unexpected interrupt");
      }
    });
    t.setName("P_" + i);
    return t;
  }

  static Thread consumer(IBoundedQueue<Integer> bq, int i) {
    Thread t = new Thread(() -> {
      try {
        D.print("Consumer removing item ...");
        int v = bq.remove();
        D.print("Consumer obtained %d", v);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    t.setName("C_" + i);
    return t;
  }
}
