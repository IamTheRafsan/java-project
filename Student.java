import java.lang.*;


public class Student{
	String name;
	String id;
	private String father;
	private String mother;
	private String course;
	private String session;
	private String cgpa;


	public void setName(String name){
		this.name=name;
	}

	public void setId(String id){
		this.id=id;
	}

	public void setFather(String father){
		this.father=father;
	}

	public void setMother(String mother){
		this.mother=mother;
	}

	public void setCourse(String course){
		this.course=course;
	}

	public void setSession(String session){
		this.session=session;
	}

	public void setCgpa(String cgpa){
		this.cgpa=cgpa;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getFather(){
		return father;
	}

	public String getMother(){
		return mother;
	}

	public String getCourse(){
		return course;
	}

	public String getSession(){
		return session;
	}

	public String getCgpa(){
		return cgpa;
	}
 

	

}