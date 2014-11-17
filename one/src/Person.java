//standard library imports
import java.io.Serializable;

public class Person implements Serializable {
	//private fields
	private String name;

	//constructor
	public Person( String name){
		this.name = name;}

	//string cast
	@Override
	public String toString(){
		return name;}
}