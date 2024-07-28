package Model;

public class Student {

  private int id;
  private String name;
  private String gender;
  private int grade;

  // Contructor
  public Student(int id, String name, String gender, int grade) {
    super();
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.grade = grade;
  }
  
  public Student(String name, String gender, int grade) {
    this.name = name;
    this.gender = gender;
    this.grade = grade;
  }

  public Student() {

  }

  
  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", grade=" + grade + "]";
  }

  // getter
  public int getID(){
    return id;
  }
  public String getName(){
    return name;
  }
  public String getGender(){
    return gender;
  }
  public int getGrade(){
    return grade;
  }

  // setter
  public void setID(int id){
    this.id = id;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setGender(String gender){
    this.gender = gender;
  }
  public void setGrade(int grade){
    this.grade = grade;
  }

}
