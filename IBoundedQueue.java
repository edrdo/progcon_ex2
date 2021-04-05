public interface IBoundedQueue<E> {
  int capacity();
  int size();
  void add(E elem) throws InterruptedException;
  E remove() throws InterruptedException;
}
