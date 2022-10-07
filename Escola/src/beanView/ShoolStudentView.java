package beanView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.ShoolException;
import Implementation.StudentImpl;
import obj.StudentObj;

/** Classe do estudante. */
public class ShoolStudentView extends AbstractBeanView {

	// Cria um instancia da classe de implementa��o.
	private StudentImpl studentImpl = new StudentImpl();
	// Lista de estudantes cadastrados.
	private List<StudentObj> studentList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Construtor padr�o.
	 */
	public ShoolStudentView() {
		this.loadClass();
		this.init();
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

	public void init() {
		this.printStudentList();
		this.selectOption();
	}

	/**
	 * Seleciona a op��o de entrada a ser executada.
	 */
	public void selectOption() {
		// Recupera a op��o do usu�rio.
		int option = this.optionSelected();
		// Seleciona a op��o.
		this.optionCrud(option);
	}

	/**
	 * Retorna a op��o selecionada pelo usu�rio.
	 * 
	 * @return a op��o selecionada pelo usu�rio.
	 */
	private int optionSelected() {
		System.out.println("O que deseja fazer? ");
		// Percorre a lista de op��es do que se pode fazer.
		for (int i = 0; i < this.options().size(); i++) {
			// Imprime a op��o.
			System.out.println(i + 1 + " - " + this.options().get(i));
		}
		System.out.print("Digite a op��o: ");
		// Recupera a op��o selecionada.
		int result = sc.nextInt();
		System.out.println();
		return result;
	}

	/**
	 * Imprime a lista de usu�rio.
	 */
	public void printStudentList() {
		if (!this.getStudentList().isEmpty()) {
			for (StudentObj student : this.getStudentList()) {
				System.out.println(student.getId() + " - " + student.getFirstName() + " " + student.getLastName());
			}
		}
	}

	/**
	 * Cria a primeira inst�ncia de um estudante.
	 * 
	 * @return Retorna o objeto do estudante.
	 * @throws ShoolException em caso de erro ao criar um estudante.
	 */
	private StudentObj createStudent() throws ShoolException {
		// Cria um objeto de estudante.
		StudentObj student = new StudentObj();
		// Informa ao usu�rio para digitar o primeiro nome.
		System.out.print("Informe o primeiro nome do estudante: ");
		// Recupera o nome digitado e valida.
		String firstName = this.validateName(sc.next());
		// Informa ao usu�rio para digitar o �ltimo nome.
		System.out.print("\nInforme o sobrenome do estudante: ");
		// Recupera o nome digitado e valida.
		String LastName = this.validateName(sc.next());
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
		// Retorna o objeto.
		return student;
	}
	
	/**
	 * Realiza o processo de atualiza��o do estudante.
	 * @param student estudante para atualiza��o.
	 */
	private void updateStudent(StudentObj student) {
		// Imprime o estudante selecionado.
		System.out.println(student.toString());
		// Pede para informar o primeiro nome.
		System.out.print("Digite o primeiro nome: ");
		// Recupera o primeiro nome.
		String firstName = sc.next();
		// Pede para informar o sobrenome.
		System.out.print("\nDigite o sobrenome: ");
		// Recupera o sobrenome.
		String lastName = sc.next();
		// Define o primeiro nome do estudante.
		student.setFirstName(firstName);
		// Define o sobrenome do estudante.
		student.setLastName(lastName);
		// Imprime o usu�rio atualizado.
		System.out.println("\n" + student.toString());
		// Pede confirma��o de atualiza��o.
		boolean isConfirm = this.confirmUpdate();
		// Caso tenha confirmado a atualiza��o.
		if (isConfirm) {
			try {
				// Realiza a atualiza��o.
				this.studentImpl.update(student);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Informa ao usu�rio.
			System.out.println("Atualiza��o realizada!");
		}
	}

	/**
	 * Retorna um estudante pelo id.
	 * 
	 * @return um estudante pelo id.
	 */
	private StudentObj getStudent() {
		// Inicializa o objeto de retorno.
		StudentObj student = new StudentObj();
		// Imprime mensagem.
		System.out.print("Selecione um aluno pelo id: ");
		// Recupera o valor informado.
		Long id = sc.nextLong();
		// Itera pela lista de estudantes cadastrada.
		for (StudentObj studentObj : this.getStudentList()) {
			// Verifica se o id de entrada � igual ao do objeto atual.
			if (studentObj.getId().equals(id)) {
				// estudante de retorno recebe o objeto atual.
				student = studentObj;
			}
		}
		return student;
	}

	/**
	 * Retorna a lista de estudantes.
	 * 
	 * @return a lista de estudantes.
	 */
	public List<StudentObj> getStudentList() {
		return studentList;
	}

	/**
	 * Define a lista de estudantes.
	 * 
	 * @param studentList lista de estudante.
	 */
	public void setStudentList(List<StudentObj> studentList) {
		this.studentList = studentList;
	}

	@Override
	public void create() {
		this.createStudent();
	}

	@Override
	public void read() {
		this.getStudent();
	}

	@Override
	public void update() {
		StudentObj student = this.getStudent();
		this.updateStudent(student);
	}

	@Override
	public void delete() {
		
	}

}
