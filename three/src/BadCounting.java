//standard library imports
import java.util.Vector;

public class BadCounting extends Thread {
	public static void main( String[] args){
		new BadCounting().start();}

	//private fields
	private Counter counter;
	private int thread_count;
	private Vector<Thread> threads;

	public BadCounting(){
		//vars
		this.counter = new Counter();
		this.thread_count = 3;
		this.threads = new Vector<Thread>();

		//make threads
		for( int i = 0; i < thread_count; i ++)
			threads.add( new CountingThread( counter));}

	public void run(){
		//start threads
		for( Thread thread : threads)
			thread.start();
		//join threads
		for( Thread thread : threads)
			try{ thread.join();}
			catch( InterruptedException exception){}
		//print result
		System.out.printf(
			"counter final value: %d\n",
			counter.getCount());}

	private class Counter {
		private int data;
		public Counter(){
			this.data = 0;}
		public void increaseCount(){
			int temp = data;
			try{ Thread.sleep( 1);}
			catch( InterruptedException exception){}
			this.data = temp + 1;}
		public int getCount(){
			return this.data;}
	}

	private class CountingThread extends Thread {
		private Counter counter;
		public CountingThread( Counter counter){
			this.counter = counter;}
		public void run(){
			for( int i = 0; i < 10; i++)
				counter.increaseCount();}
	}
}