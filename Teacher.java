import java.lang.*;

public class Teacher
{
	private String name;
	private String id;
	private String father;
	private String mother;
	private String education;
	private String department;
	private String course;
	private String salary;

	public void setName(String name){this.name=name;}
	public void setId(String id){this.id=id;}
	public void setFather(String father){this.father=father;}
	public void setMother(String mother){this.mother=mother;}
	public void setEducation(String education){this.education=education;}
	public void setDepartment(String department){this.department=department;}
	public void setCourse(String course){this.course=course;}
	public void setSalary(String salary){this.salary=salary;}

	public String getName(){return name;}
	public String getId(){return id;}
	public String getFather(){return father;}
	public String getMother(){return mother;}
	public String getEducation(){return education;}
	public String getDepartment(){return department;}
	public String getCourse(){return course;}
	public String getSalary(){return salary;}
}