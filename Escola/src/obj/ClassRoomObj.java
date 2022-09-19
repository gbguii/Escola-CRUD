package obj;

import java.util.List;

public class ClassRoomObj extends BasicObj{
	
	/** Identificador da sala de aula. */
	private Long id;
	/** Nome  da sala de aula. */
	private String name;
	/** Lista de Coursos da sala de aula. */
	private List<CourseObj> courses;
	/** Lista de Alunos da sala de aula. */
	private List<StudentObj> students;
	
	/**
	 * Construtor Padrão.
	 */
	public ClassRoomObj() {
		
	}
	
	/**
	 * Construtor recebendo valores;
	 * @param name		Nome da classe de aula.
	 * @param courses	Cursos da classe de aula.
	 * @param students	Estudantes da classe de aula.
	 */
	public ClassRoomObj(String name, List<CourseObj> courses, List<StudentObj> students) {
		this.name = name;
		this.courses = courses;
		this.students = students;
	}
	
	/**
	 * Retorna o identificador da classe de aula.
	 * @return o identificador da classe de aula.
	 */
	public Long getId() {
		return this.id;
	}
	
	/*
	 * Retorna o nome da classe de aula.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Define o nome da classe de aula.
	 * @param name nome da classe de aula.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Retorna o cursos da classe de aula.
	 * @return o cursos da classe de aula.
	 */
	public List<CourseObj> getCourses() {
		return courses;
	}
	
	/**
	 * Define a lista de cursos da sala de aula.
	 * @param courses lista de cursos da sala de aula.
	 */
	public void setCourses(List<CourseObj> courses) {
		this.courses = courses;
	}
	
	/**
	 * Retorna a lista de estudantes da classe de aula.
	 * @return a lista de estudantes da classe de aula.
	 */
	public List<StudentObj> getStudents() {
		return students;
	}
	
	/**
	 * Define a lista de estudantes da classe de aula.
	 * @param students lista de estudantes da classe de aula.
	 */
	public void setStudents(List<StudentObj> students) {
		this.students = students;
	}
	
	
}
