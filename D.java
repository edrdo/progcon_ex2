//
// Utility class for debug printouts.
//
// Programação Concorrente (CC3037), DCC/FCUP
// Eduardo R. B. Marques
//
public class D {
  
  public static void print(String message, Object... args) {
    if (DEBUG) {
      synchronized (LOCK) {
        System.out.print( Thread.currentThread().getName() + " | ");
        System.out.printf(message, args);
        System.out.println();
      }
    }
  }

  public static void enable() {
    DEBUG = true;
  }
  public static void disable() {
    DEBUG = true;
  }
  private static boolean DEBUG = System.getProperty("debug") != null;
  private static final Object LOCK = new Object();
  private D() { }
}
