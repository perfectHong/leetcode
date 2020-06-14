package concurrency.artofconcurrency.chapter_four;

public class Join_Bak {

	public static void main(String[] args) throws Exception {
		Thread previous = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Domian(previous), String.valueOf(i));
			thread.start();           
			previous = thread;
		}
		System.out.println(Thread.currentThread().getName() + " terminate.");  
	}

	static class Domian implements Runnable {
		
		private Thread thread;

		public Domian(Thread thread) {
			this.thread = thread;
		}

		public void run() {
			try {
				thread.join();  
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " terminate.");   
		}
	}
}