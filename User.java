import java.lang.*;

public class User 
{
	String name;
	String id;
	String password;


	public void setName(String name){
		this.name=name;
	}

	public void setId(String id){
		this.id=id;
	}

	public void setPassword(String password)
	{
		this.password=password;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getPassord(){
		return password;
	}

}