package main;

import java.sql.Connection;
import java.sql.SQLException;

import Connection.CreateConnection;
import Implementation.StudentImpl;
import beanView.ShoolStudentView;

public class TesteMain {
	public static void main(String[] args) throws SQLException {
		ShoolStudentView create = new ShoolStudentView();
		create.createStudent();
	}
}
