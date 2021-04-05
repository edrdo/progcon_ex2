import java.util.concurrent.LinkedBlockingDeque;
public class Stack3<E> implements IStack<E> {
  private final LinkedBlockingDeque<E> elems;

  public Stack3() {
    elems = new LinkedBlockingDeque<>();
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
