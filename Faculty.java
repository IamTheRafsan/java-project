import java.lang.*;

public class Faculty
{
	private String name;
	private String id;
	private String education;
	private String department;
	private String course;
	private double salary;

	public void setName(String name){this.name=name;}
	public void setId(String id){this.id=id;}
	public void setEducation(String education){this.education=education;}
	public void setDepartment(String department){this.department=department;}
	public void setCourse(String course){this.course=course;}
	public void setSalary(double salary){this.salary=salary;}

	String getName(){return name;}
	String getId(){return id;}
	String getEducation(){return education;}
	String getDepartment(){return department;}
	String getCourse(){return course;}
	double getSalary(){return salary;}
}