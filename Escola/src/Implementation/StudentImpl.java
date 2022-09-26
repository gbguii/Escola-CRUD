package Implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import Connection.CreateConnection;
import Exception.ShoolException;
import obj.StudentObj;

public class StudentImpl {
	
	
	
	public void create(StudentObj student) {
		this.validate(student);
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO students(student_first_name, student_last_name, student_dt_begin, student_dt_update, student_dt_end) VALUES(?,?,?,?,?)");
		Connection connection = CreateConnection.getConection();
		try {
			Calendar c = Calendar.getInstance();
			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setDate(3, new Date(c.getTimeInMillis()));
			stmt.setDate(4, new Date(c.getTimeInMillis()));
			c.set(2100, 0, 0);
			stmt.setDate(5, new Date(c.getTimeInMillis()));
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(StudentObj student) {
		this.validate(student);
	}
	
	public void delet(StudentObj student) {
		
	}
	
	public StudentObj getStudent(Long id) {
		StudentObj student = new StudentObj();
		return student;
	}
	
	public StudentObj getStudent(String name) {
		StudentObj student = new StudentObj();	
		return student;
	}
	
	private void validate(StudentObj studant) {
		if(studant.getFirstName() == null || studant.getFirstName().isEmpty()) {
			throw new ShoolException("O primeiro nome est� vazio");
		}
		if(studant.getLastName() == null || studant.getLastName().isEmpty()) {
			throw new ShoolException("O �ltimo nome est� vazio");
		}
	}
}
