import java.util.LinkedList;
public class Stack1<E> implements IStack<E> {
  private final LinkedList<E> elems;

  public Stack1() {
    elems = new LinkedList<>();
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
