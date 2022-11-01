package Implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import Connection.CreateConnection;
import Exception.ShoolException;
import obj.ClassRoomObj;

public class ClassRoomImpl {
	
	public void create(ClassRoomObj classRoom) throws SQLException {
		// Valida os dados obrigatórios.
		this.validade(classRoom);
		// Cria a conexão com o banco.
		Connection connection = CreateConnection.getConection();
		// Inicializa a string que contem sql.
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO class_rooms (class_room_name, course_id, class_room_dt_begin, class_room_dt_update, class_room_dt_end)");
		sb.append(" VALUES(?,?,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,?)");
		try {
			// Recupera a hora atual.
			Calendar c = Calendar.getInstance();
			// Define o ano de fim do registro.
			c.set(2200, 0, 0);
			// Inicializa a preparação de execução.
			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			// Define o primeiro pâmetro com nome da classe de aula.
			stmt.setString(1, classRoom.getName());
			// Define o segundo pâmetro com identificador do curso.
			stmt.setLong(2, classRoom.getCourse().getId());
			// Define o terceiro pâmetro com a data de fim do registro.
			stmt.setDate(3, new Date(c.getTimeInMillis()));
			// Executa a query.
			stmt.execute();
			// em caso de erro.
		} catch (SQLException e) {
			// lança a exceção.
			e.printStackTrace();
		} finally {
			// fecha a conexão com o banco.
			connection.close();
		}
	}

	public void update(ClassRoomObj classRoom) throws SQLException {
		// Valida os campos obrigatório.
		this.validade(classRoom);
		// Inicializa a string que contem sql.
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE class_rooms");
		sb.append("SET class_room_name = ? ");
		sb.append("course_id = ? ");
		sb.append("class_room_dt_update = CURRENT_TIMESTAMP ");
		sb.append("WHERE class_room_id = ?");
		Connection connection = CreateConnection.getConection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			// Define o nome da classe de aula.
			stmt.setString(1, classRoom.getName());
			// Define o identificador do curso.
			stmt.setLong(2, classRoom.getCourse().getId());
			// Define o identificador da classe de aula.
			stmt.setLong(3, classRoom.getId());
			// Executa a atualização.
			stmt.executeUpdate();
			// Em caso de erro.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// Fecha a conexão com o banco.
			connection.close(); 
		}
	}
	
	public void delete(ClassRoomObj classRoom) throws SQLException {
		// Cria sting que contem sql.
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE class_rooms ");
		sb.append("SET class_room_dt_update = CURRENT_TIMESTAMP ");
		sb.append("class_room_dt_end = CURRENT_TIMESTAMP ");
		sb.append("WHERE class_room_id = ?");
		// Recupera a conexão com o banco.
		Connection connection = CreateConnection.getConection();
		try {
			// Inicializa a preparação para execução.
			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			// Define o identificador da classe de aula.
			stmt.setLong(1, classRoom.getId());
			// Executa a exclusão logica do dado.
			stmt.executeUpdate();
			// Em caso de erro.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// Fecha a conexão com o banco de dados.
			connection.close();
		}
	}
	
	/**
	 * Valida os campos obrigatório da sala de aula.
	 * @param classRoom objeto da sala de aula.
	 */
	private void validade(ClassRoomObj classRoom) {
		// Se classe for nula ou nome da sala for nula ou nome da sala por vazia
		if(classRoom == null || classRoom.getName() == null || classRoom.getName().isEmpty()) {
			// Lança aviso.
			throw new ShoolException("Necessário preencher o nome da Sala corretamente");
		}
		// Se o curso for nulo
		if(classRoom.getCourse() == null) {
			// Lança o aviso.
			throw new ShoolException("Necessário definir um curso para a Sala.");
		}
	}
}
