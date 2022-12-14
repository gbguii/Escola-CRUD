package obj;

import java.util.List;

public class StudentObj extends BasicObj{
	
	/** Identificador do aluno. */
	private Long id;
	/** Primeiro nome do aluno*/
	private String firstName;
	/** ?ltimo nome do aluno. */
	private String lastName;
	/** Classe de aula do aluno. */
	private ClassRoomObj classRoom;
	/** Lista de cursos do aluno. */
	private List<CourseObj> courses;
	
	/**
	 * Constutor padr?o
	 */
	public StudentObj() {
		
	}
	
	/**
	 * Construtor recebendo valores.
	 * @param firstName		Primeiro nome do aluno.
	 * @param lastName		?ltimo nome do aluno.
	 * @param classRoom		Classe de aula do aluno.
	 * @param courses		Lista de Cursos do aluno.
	 */
	public StudentObj(String firstName, String lastName, ClassRoomObj classRoom, List<CourseObj> courses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.classRoom = classRoom;
		this.courses = courses;
	}
	
	/**
	 * Retorna o identificador do estudante.
	 * @return o identificador do estudante.
	 */
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Retorna o primeiro nome do aluno.
	 * @return o primeiro nome do aluno.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Define o primeiro nome do aluno.
	 * @param firstName o primeiro nome do aluno.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Retorna o ?ltimo nome do aluno.
	 * @return o ?ltimo nome do aluno.
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Define o ?ltimo nome do aluno.
	 * @param lastName o ?ltimo nome do aluno.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retorna a classe de aula do aluno.
	 * @return a classe de aula do aluno.
	 */
	public ClassRoomObj getClassRoom() {
		return classRoom;
	}

	/**
	 * Define a classe de aula do aluno.
	 * @param classRoom a classe de aula do aluno. 
	 */
	public void setClassRoom(ClassRoomObj classRoom) {
		this.classRoom = classRoom;
	}
	
	/**
	 * Retorna a lista de cursos do aluno.
	 * @return a lista de cursos do aluno.
	 */
	public List<CourseObj> getCourses() {
		return courses;
	}
	
	/**
	 * Define a lista de cursos do aluno.
	 * @param courses a lista de cursos do aluno.
	 */
	public void setCourses(List<CourseObj> courses) {
		this.courses = courses;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getId() + " - ");
		sb.append(this.getFirstName() + " ");
		sb.append(this.getLastName() + " ");
		sb.append(this.getCourses() != null ? this.getCourses(): "");
		return sb.toString();
	}
}
