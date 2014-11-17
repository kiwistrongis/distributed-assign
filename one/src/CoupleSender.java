//standard library imports
import java.io.*;
import java.net.*;

public class CoupleSender extends Thread {
	//main entry point
	public static void main( String[] args){
		if( args.length < 1 )
			throw new RuntimeException( "no hostname given");
		new CoupleSender( args[0]).start();}

	//constants
	private static final int port = 8192;

	//private fields
	private InetAddress host_addr = null;

	//constructor
	public CoupleSender( String hostname){
		try{
			host_addr = InetAddress.getByName( hostname);}
		catch( UnknownHostException exception){
			throw new RuntimeException(
				"failed to resolve hostname: %s", exception);}}

	//thread functions
	@Override
	public void run(){
		try{
			//open connection
			System.out.println("connecting...");
			Socket socket = new Socket( host_addr, port);

			//create couple
			Couple couple = new Couple(
				new Person( "Sally"), null);
			System.out.printf( "presend: %s\n", couple);

			//send couple
			System.out.println("sending couple");
			ObjectOutputStream out =
				new ObjectOutputStream(
					socket.getOutputStream());
			out.writeObject( couple);

			//receive couple
			System.out.println("receiving couple");
			ObjectInputStream in =
				new ObjectInputStream(
					socket.getInputStream());
			couple = (Couple) in.readObject();
			System.out.printf( "postreceive: %s\n", couple);

			//clean up
			System.out.println("closing connection");
			socket.close();}
		//fucking java and its exception bullshit
		catch( Exception exception){
			exception.printStackTrace();}}
}