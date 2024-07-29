package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import Model.Student;
import serivice.StudentService;

public class JDBCDemo {
	private static StudentService studentservice;
	private static Connection connection;

	public JDBCDemo(){
		studentservice = new StudentService();
		connection = getConnection();
	}
 	public static void main(String[] args) throws SQLException {
		JDBCDemo demo = new JDBCDemo();
		// demo.save("lin","F",10);

		int idtoFInd = 16;
		Student student =  studentservice.finByID(idtoFInd, connection);
		System.out.println(student.toString());
		// update set name 
		student.setName("Koy");
		studentservice.updateStudent(student, connection);
	}

	private Connection getConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/school_management";
			String user = "Rotha";
			String password = "123";
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;

		} catch (Exception e) {
			System.out.println("connection is fails");
			e.printStackTrace();
		}
		return null;
	}
	private void save(String name, String gender, int grade){
		connection = getConnection();
		Student student = new Student(name,gender,grade);
		studentservice.saveStudent(student, connection);
	}

}
