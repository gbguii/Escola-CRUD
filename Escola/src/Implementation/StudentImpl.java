package Implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Connection.CreateConnection;
import Exception.ShoolException;
import obj.StudentObj;

public class StudentImpl {

	/**
	 * Cria um novo usu?rio na base de dados.
	 * 
	 * @param student objeto de usu?rio para ser criado.
	 * @throws SQLException em caso de erro.
	 */
	public void create(StudentObj student) throws SQLException {
		// Valida os campos
		this.validate(student);
		// Cria string para conter query de cria??o.
		StringBuilder sb = new StringBuilder();
		// Adiciona o query.
		sb.append(
				"INSERT INTO students(student_first_name, student_last_name, student_dt_begin, student_dt_update, student_dt_end) VALUES(?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?)");
		// Cria um cone??o com o banco.
		Connection connection = CreateConnection.getConection();
		try {
			// Recupera a hora atual.
			Calendar c = Calendar.getInstance();
			// Define o ano de fim do registro.
			c.set(2200, 0, 0);
			// Inicializa a prepara??o de execu??o.
			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			// Define o primeiro p?metro com primeiro nome.
			stmt.setString(1, student.getFirstName());
			// Define o segundo p?metro com sobrenome.
			stmt.setString(2, student.getLastName());
			// Define o terceiro p?metro com a data de fim do registro.
			stmt.setDate(3, new Date(c.getTimeInMillis()));
			// Executa a query.
			stmt.execute();
			// em caso de erro.
		} catch (SQLException e) {
			// lan?a a exce??o.
			e.printStackTrace();
		} finally {
			// fecha a conex?o com o banco.
			connection.close();
		}
	}
	
	/**
	 * Realiza a atualiza??o dos dados de um estudante.
	 * @param student estudante para a atualiza??o.
	 * @throws SQLException Em caso de Erro.
	 */
	public void update(StudentObj student) throws SQLException {
		// Valida os campos.
		this.validate(student);
		// Recupera a conex?o com o banco.
		Connection connection = CreateConnection.getConection();
		// Inicia a string que contem a instru??o sql.
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE students ");
		sb.append("SET student_first_name = ?, ");
		sb.append("student_last_name = ?, ");
		sb.append("student_dt_update = CURRENT_TIMESTAMP ");
		sb.append("WHERE student_id = ?");
		// Inicializa a prepara??o de execu??o.
		PreparedStatement stmt = connection.prepareStatement(sb.toString());
		try {
			// Define o primeiro p?metro com primeiro nome.
			stmt.setString(1, student.getFirstName());
			// Define o segundo p?metro com sobrenome.
			stmt.setString(2, student.getLastName());
			// Define o quarto par?metro com o identificador do estudante.
			stmt.setLong(3, student.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// Em caso de erro.
			e.printStackTrace();
		} finally {
			// Fecha a conex?o como banco.
			connection.close();
			// Fecha a prepara??o.
			stmt.close();
		}

	}
	
	/**
	 * Realiza a exclus?o l?gica de um estudante.
	 * @param student estudante para exclus?o.
	 * @throws SQLException Em caso de Erro.
	 */
	public void delete(StudentObj student) throws SQLException {
		// Recupera a conex?o com o banco.
		Connection connection = CreateConnection.getConection();
		// Inicia a string que contem a instru??o sql.
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE students ");
		sb.append("SET student_dt_end = CURRENT_TIMESTAMP ");
		sb.append("WHERE student_id = ?");
		// Inicializa a prepara??o de execu??o.
		PreparedStatement stmt = connection.prepareStatement(sb.toString());
		try {
			// Define o id do estudante.
			stmt.setLong(1, student.getId());
			// Executa a exclus?o l?gica.
			stmt.executeUpdate();
		} catch (SQLException e) {
			// Em caso de erro.
			e.printStackTrace();
		} finally {
			// Fecha cone??o com o banco.
			connection.close();
			// Fecha a prepara??o.
			stmt.close();
		}
	}

	/**
	 * Retorna a lista de estudantes cadastrado.
	 * 
	 * @return a lista de estudantes cadastrado.
	 * @throws SQLException em caso de erro.
	 */
	public List<StudentObj> getStudentList() throws SQLException {
		// Inicializa a lista de retorno.
		List<StudentObj> studentList = new ArrayList<>();
		// Cria a conex?o com o banco.
		Connection connection = CreateConnection.getConection();
		// Cria string para query.
		StringBuilder sb = new StringBuilder();
		// Seleciona a tabela de consulta.
		sb.append("SELECT * FROM shool.students s ");
		// Filtra registro v?lidos.
		sb.append("WHERE s.student_dt_end > current_timestamp");
		try {
			// Prepara a consulta.
			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			// Executa e recupera o resultado da query.
			ResultSet result = stmt.executeQuery();
			// Mapeia e popula a lista de estudantes.
			this.mappingObjectToList(result, studentList);
			// Em caso de erro.
		} catch (SQLException e) {
			// Lan?a exce??o.
			e.printStackTrace();
		} finally {
			// Fecha a conex?o com o banco.
			connection.close();
		}
		return studentList;
	}

	/**
	 * Retorna um estudante cadastrado pelo id informado.
	 * 
	 * @param id identificador do estudante.
	 * @return um estudante cadastrado pelo id informado.
	 * @throws SQLException em caso de erro.
	 */
	public StudentObj getStudentById(Long id) throws SQLException {
		// Inicializa o objeto de retorno.
		StudentObj student = new StudentObj();
		// Cria a conex?o com o banco de dados.
		Connection connection = CreateConnection.getConection();
		// String para query de consulta.
		StringBuilder sb = new StringBuilder();
		// Seleciona a tabela de consulta.
		sb.append("SELECT * FROM shool.students s ");
		// Filtra pelo id.
		sb.append("WHERE s.student_id = ? ");
		// Filtra por registro v?lidos.
		sb.append("AND s.student_dt_end > current_timestamp");
		try {
			// Prepara a consulta.
			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			// Define o par?metro do id.
			stmt.setLong(1, id);
			// Executa a query.
			ResultSet result = stmt.executeQuery();
			// Mapeia a consulta para o objeto de estudante.
			student = mappingObject(result);
			// em caso de erro ao executar a query.
		} catch (SQLException e) {
			// Lan?a exece??o.
			e.printStackTrace();
		} finally {
			// Fecha a conex?o com o banco de dados.
			connection.close();
		}
		// Retorna o estudante.
		return student;
	}

	/**
	 * Retorna um objeto de estudante.
	 * 
	 * @param result resultado da consulta.
	 * @return um objeto de estudante.
	 * @throws SQLException em caso de erro.
	 */
	private StudentObj mappingObject(ResultSet result) throws SQLException {
		// Cria lista para receber o objeto de usu?rio.
		List<StudentObj> students = new ArrayList<>();
		// mapeia e popula a lista do tipo objeto de estudante.
		this.mappingObjectToList(result, students);
		// Retorna o primeiro objeto da lista.
		return students.get(0);
	}

	/**
	 * Mapeia e popula a lista de objeto de estudante.
	 * 
	 * @param result      resultado da consulta.
	 * @param studentList lista para ser populada.
	 * @throws SQLException em caso de erro.
	 */
	private void mappingObjectToList(ResultSet result, List<StudentObj> studentList) throws SQLException {
		if (result != null) {
			while (result.next()) {
				StudentObj student = new StudentObj();
				// Mapeia para o objeto o id do estudante.
				student.setId(result.getLong("student_id"));
				// Mapeia para o objeto o primeiro nome do estudante.
				student.setFirstName(result.getString("student_first_name"));
				// Mapeia para o objeto o sobrenome do estudante.
				student.setLastName(result.getString("student_last_name"));
				// Mapeia para o objeto a data de in?cio do registro do estudante.
				student.setDtBegin(result.getDate("student_dt_begin"));
				// Mapeia para o objeto a data de atualiza??o do registro do estudante.
				student.setDtUpdate(result.getDate("student_dt_update"));
				// Mapeia para o objeto a data de fim do registro do estudante.
				student.setDtEnd(result.getDate("student_dt_end"));
				studentList.add(student);
			}
		}
	}

	private void validate(StudentObj studant) {
		if (studant.getFirstName() == null || studant.getFirstName().isEmpty()) {
			throw new ShoolException("O primeiro nome est? vazio");
		}
		if (studant.getLastName() == null || studant.getLastName().isEmpty()) {
			throw new ShoolException("O ?ltimo nome est? vazio");
		}
	}
}
