package obj;


public class CourseObj extends BasicObj{
	
	/** Identificador do curso. */
	private Long id;
	/** Nome do curso. */
	private String name;
	/** Professor do curso. */
	private ProfessorObj professor;
	
	/**
	 * Construtor padrão.
	 */
	public CourseObj() {

	}
	
	/**
	 * Construtor recebendo valores.
	 * @param name			Nome do curso.
	 * @param professor 	Professor do curso.
	 */
	public CourseObj(String name, ProfessorObj professor) {
		this.name = name;
		this.professor = professor;
	}
	
	/**
	 * Retorna o identificador do curso.
	 * @return o identificador do curso.
	 */
	public Long getId() {
		return this.id;
	}
	
	/**
	 * Retorna o nome do curso.
	 * @return o nome do curso.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Define o nome do curso.
	 * @param name o nome do curso.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Retorna o professor do curso.
	 * @return o professor do curso.
	 */
	public ProfessorObj getProfessor() {
		return professor;
	}
	
	/**
	 * Define o professor do curso.
	 * @param professor o professor do curso.
	 */
	public void setProfessor(ProfessorObj professor) {
		this.professor = professor;
	}
	
	
}
