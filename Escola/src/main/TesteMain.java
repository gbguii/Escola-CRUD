package main;

import java.sql.Connection;
import java.sql.SQLException;

import Connection.CreateConnection;
import Implementation.StudentImpl;
import beanView.ShoolStudentView;
import obj.StudentObj;

public class TesteMain {
	public static void main(String[] args) throws SQLException {
		ShoolStudentView getStudent = new ShoolStudentView();
		getStudent.printStudent();
		getStudent.getStudent();
	}
}
