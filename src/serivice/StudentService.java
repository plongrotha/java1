package serivice;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Student;

public class StudentService {

	public void save(Connection connection) {
		String sql = "INSERT INTO students(name,gender,grade) VALUES('KBen Ten','M',1)";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Insert Successfully");
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	//get one student by id
	public Student finByID(int stuID, Connection connection){
		String sql = "SELECT * FROM students WHERE id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stuID);
			ResultSet resultset = preparedStatement.executeQuery();
			resultset.next();
			int id = resultset.getInt(1);
			String name = resultset.getString(2);
			String gender = resultset.getString(3);
			int grade = resultset.getInt(4);
			return new Student(id,name,gender,grade);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public void saveStudent(Student student, Connection connection) {
		String sql = "INSERT INTO students(name,gender,grade) VALUES(?,?,?)";
		try {
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, student.getName());
			preparestatement.setString(2, student.getGender());
			preparestatement.setInt(3, student.getGrade());
			preparestatement.executeUpdate();
			System.out.println("Insert Successfully");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateStudent(Student student,Connection connection){
		int idToFind  = student.getID();
		Student stuFind = finByID(idToFind, connection);
		if(stuFind != null){
			String sql = "UPDATE students SET name=?, gender=?, grade=? WHERE id=?";
			PreparedStatement preparestatement;
			try {
				preparestatement = connection.prepareStatement(sql);
				preparestatement.setString(1, student.getName());
				preparestatement.setString(2, student.getGender());
				preparestatement.setInt(3, student.getGrade());
				preparestatement.setInt(4, idToFind);
				preparestatement.executeUpdate();
				System.out.println("Update Successfully");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Student is not found = " + idToFind);
		}
	}
}
