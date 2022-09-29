package beanView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.ShoolException;
import Implementation.StudentImpl;
import obj.StudentObj;

/** Classe do estudante.*/
public class ShoolStudentView extends AbstractBeanView{
	// Cria um instancia da classe de implementa��o.
	private StudentImpl studentImpl = new StudentImpl();
	// Lista de estudantes cadastrados.
	private List<StudentObj> studentList = new ArrayList<>();
	
	/**
	 * Construtor padr�o.
	 */
	public ShoolStudentView() {
		this.loadClass();
	}
	
	/**
	 * Carrega os dados da classe.
	 */
	private void loadClass() {
		try {
			// Recupera os estudantes cadastrados.
			studentList = studentImpl.getStudentList();
		// Em caso de erro.
		} catch (SQLException e) {
			// Lan�a exce��o.
			e.printStackTrace();
		}
	}
	
	/**
	 * Imprime a lista de usu�rio.
	 */
	public void printStudent() {
		if(!this.getStudentList().isEmpty()) {
			for(StudentObj student : this.getStudentList()) {
				System.out.println(student.getId() + " - " + student.getFirstName()  + " " + student.getLastName());
			}
		}
	}
	
	/**
	 * Cria a primeira inst�ncia de um estudante.
	 * @return Retorna o objeto do estudante.
	 * @throws ShoolException em caso de erro ao criar um estudante.
	 */
	public StudentObj createStudent() throws ShoolException {
		// Cria um objeto de estudante.
		StudentObj student = new StudentObj();
		// Inicializa um scanner.
		Scanner sc = new Scanner(System.in);
		// Informa ao usu�rio para digitar o primeiro nome.
		System.out.print("Informe o primeiro nome do estudante: ");
		// Recupera o nome digitado e valida.
		String firstName = this.validateName(sc.nextLine());
		// Informa ao usu�rio para digitar o �ltimo nome.
		System.out.print("\nInforme o sobrenome do estudante: ");
		// Recupera o nome digitado e valida.
		String LastName = this.validateName(sc.nextLine());
		// Define o primeiro nome no objeto.
		student.setFirstName(firstName);
		// Define o ultimo nome no objeto.
		student.setLastName(LastName);
		try {
			studentImpl.create(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Fecha o scanner.
		sc.close();
		// Retorna o objeto.
		return student;
	}
	
	/**
	 * Retorna um estudante pelo id.
	 * @return um estudante pelo id.
	 */
	public StudentObj getStudent() {
		// Inicializa o objeto de retorno.
		StudentObj student = new StudentObj();
		// Cria o scanner.
		Scanner sc = new Scanner(System.in);
		// Imprime mensagem.
		System.out.print("Digite o id do usu�rio: ");
		// Recupera o valor informado.
		Long id = sc.nextLong();
		try {
			// Consulta o estudante pelo id.
			student = this.studentImpl.getStudentById(id);
		// em caso de erro.
		} catch (SQLException e) {
			// Lan�a exce��o.
			e.printStackTrace();
		}
		// Fecha o scanner.
		sc.close();
		return student;
	}
	
	/**
	 * Retorna a lista de estudantes.
	 * @return a lista de estudantes.
	 */
	public List<StudentObj> getStudentList() {
		return studentList;
	}
	
	/**
	 * Define a lista de estudantes.
	 * @param studentList lista de estudante.
	 */
	public void setStudentList(List<StudentObj> studentList) {
		this.studentList = studentList;
	}
	
}
