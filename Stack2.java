import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Stack2<E> implements IStack<E> {
  private final LinkedList<E> elems;
  private final ReentrantLock lock;
  private final Condition notEmpty;

  public Stack2() {
    elems = new LinkedList<>();
    lock = new ReentrantLock();
    notEmpty = lock.newCondition();
  }

  public int size() {
    return elems.size();
  }

  public void push(E elem) {
    // TODO
  }

  public E pop() throws InterruptedException {
    // TODO
    return null;
  }
}
