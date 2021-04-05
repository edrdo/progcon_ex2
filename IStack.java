public interface IStack<E> {
  int size();
  void push(E elem);
  E pop() throws InterruptedException;
}
