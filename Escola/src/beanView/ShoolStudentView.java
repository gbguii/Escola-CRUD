package beanView;

import java.util.Scanner;

import Exception.ShoolException;
import obj.StudentObj;

public class ShoolStudentView extends AbstractBeanView{
	
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
		// Fecha o scanner.
		sc.close();
		// Retorna o objeto.
		return student;
	}

}