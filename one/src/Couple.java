//standard library imports
import java.io.Serializable;

public class Couple implements Serializable {
	//private fields
	public Person one;
	public Person other;

	//constructor
	public Couple( Person one, Person other){
		this.one = one;
		this.other = other;}

	//string cast
	@Override
	public String toString(){
		return String.format(
			"one: %s, other: %s",
			one != null ? one.toString() : "null",
			other != null ? other.toString() : "null");}
}