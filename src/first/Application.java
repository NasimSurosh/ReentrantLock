package first;

public class Application {

  public static void main(String[] args) throws InterruptedException {
    
    ReentrantLockExample rle = new ReentrantLockExample();
    
    Thread thread1 = new Thread(new Runnable() {

      @Override
      public void run() {
        
        try {
          rle.thread1();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
      }     
    });
    Thread thread2 = new Thread(new Runnable() {

      @Override
      public void run() {
        

        try {
          rle.thread2();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
      }     
    });
    
    thread1.start();
    thread2.start();
    
    thread1.join();
    thread2.join();
    
    rle.finished();

  }

}
