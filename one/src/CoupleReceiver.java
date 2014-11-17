//standard library imports
import java.io.*;
import java.net.*;

public class CoupleReceiver extends Thread {
	//main entry point
	public static void main( String[] args){
		new CoupleReceiver().start();}

	//constants
	private static final int port = 8192;

	//private fields
	private ServerSocket server;

	//constructor
	public CoupleReceiver(){
		try{
			server = new ServerSocket( port);}
		catch( Exception exception){
			exception.printStackTrace();}}

	//thread functions
	@Override
	public void run(){
		while( true)
			try{
				//System.out.println("waiting for connection");
				Socket client = server.accept();
				System.out.println("client connected");
				new Connection( client).start();}
			catch( Exception exception){
				exception.printStackTrace();}}

	//utility classes
	private static class Connection extends Thread {
		//private fields
		private Socket client;

		//constructor
		public Connection( Socket client){
			this.client = client;}
		
		//thread functions
		@Override
		public void run(){
			try{
				//receive couple
				ObjectInputStream in =
					new ObjectInputStream(
						client.getInputStream());
				Couple couple = (Couple) in.readObject();

				//send back edited couple
				couple.other = new Person( "Joffrey");
				System.out.printf(
					"sending back edited couple: %s\n", couple);
				ObjectOutputStream out =
					new ObjectOutputStream(
						client.getOutputStream());
				out.writeObject( couple);

				//clean up
				System.out.println("closing connection to client");
				client.close();}
			catch( Exception exception){
				exception.printStackTrace();}}
	}
}