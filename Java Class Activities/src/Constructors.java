
public class Constructors {
	int st_id;
	String st_name;
	String class_name;
	
	Constructors()
	{
		this(11,"MMM");
		class_name="LY Btech CSE";
	}
	
	Constructors(int st_id, String st_name)
	{
		this.st_id=st_id;
		this.st_name=st_name;
	}
	
	public void display() 
	{
		System.out.println("Student Id: "+st_id);
		System.out.println("Student Name: "+st_name);
		System.out.println("Student Class: "+class_name);
	}
	
	public static void main(String args[]) {
		Constructors c=new Constructors();
		c.display();
	}
}
