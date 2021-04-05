import java.util.ArrayList;

public class TestStack {
  public static void main(String[] args) throws InterruptedException {
    int n = args.length >= 1 ? Integer.parseInt(args[0]) : 3;
    D.enable();
    // test(new Stack1<>(), n);
    // test(new Stack2<>(), n);
    // test(new Stack3<>(), n);
  }

  static void test(IStack<Integer> bq, int n) 
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
  
  static Thread producer(IStack<Integer> bq, int i) {
    Thread t = new Thread(() -> { bq.push(i); });
    t.setName("P_" + i);
    return t;
  }

  static Thread consumer(IStack<Integer> bq, int i) {
    Thread t = new Thread(() -> { 
      try { 
        bq.pop();
      }
      catch (InterruptedException e) {
        throw new RuntimeException("Unexpected interrupt");
      }
    });
    t.setName("C_" + i);
    return t;
  }
}
