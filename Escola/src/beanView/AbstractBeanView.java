package beanView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.ShoolException;

public abstract class AbstractBeanView extends Crud {
	/** Entrada de dados. */
	protected static Scanner sc = new Scanner(System.in);
	
	/**
	 * Retona uma lista todas as op??es do sistema no crud.
	 * 
	 * @return uma lista todas as op??es do sistema no crud.
	 */
	protected List<String> options() {
		List<String> result = new ArrayList<>();
		result.add("Adicionar");
		result.add("Atualizar");
		result.add("Remover");
		result.add("Voltar");
		return result;
	}
	
	/**
	 * Seleciona a op??o de entrada a ser executada.
	 */
	public void selectOption() {
		// Recupera a op??o do usu?rio.
		int option = this.optionSelected();
		// Seleciona a op??o.
		this.optionCrud(option);
	}

	/**
	 * Retorna a op??o selecionada pelo usu?rio.
	 * @return a op??o selecionada pelo usu?rio.
	 */
	private int optionSelected() {
		System.out.println("O que deseja fazer? ");
		// Percorre a lista de op??es do que se pode fazer.
		for (int i = 0; i < this.options().size(); i++) {
			// Imprime a op??o.
			System.out.println(i + 1 + " - " + this.options().get(i));
		}
		System.out.print("Digite a op??o: ");
		// Recupera a op??o selecionada.
		int result = sc.nextInt();
		System.out.println();
		return result;
	}
	
	/**
	 * Executa a fun??o de crud conforme a op??o selecionada
	 * 
	 * @param option op??o selecionada.
	 */
	protected void optionCrud(int option) {
		switch (option) {
		// Se for para criar um item.
		case 1:
			this.create();
			break;
		// Se for para ler um item.
		case 2:
			this.update();
			break;
		// Se for para atualizar um item.
		case 3:
			this.delete();
			break;
		// Se for para voltar ao menu anterior.
		case 4:
			this.returnMenu();
			break;
		}
	}
	
	/**
	 * Retorna ao menu.
	 */
	protected void returnMenu() {

	}

	/**
	 * Valida se uma string para atributo nome ? valida.
	 * 
	 * @param value String de nome.
	 * @return Retorna o nome v?ido.
	 * @throws ShoolException Em caso valor n?o ser v?lido.
	 */
	protected String validateName(String value) throws ShoolException {
		// Verifica se o valor n?o vazio ou nulo.
		if (value.isEmpty() || value == null || value.trim().isEmpty()) {
			throw new ShoolException("O nome est? vazio");
		} else {
			return value;
		}
	}
	
	/**
	 * Retorna se deve realizar a atualiza??o do registro.
	 * @return se deve realizar a atualiza??o do registro.
	 */
	protected boolean confirmUpdate() {
		// Vari?vel de retorno.
		boolean result = false;
		// Imprime a mensagem de confirma??o.
		System.out.println("Deseja realizar a atualiza??o? S/N");
		// Recupera a entrada.
		String getIn = sc.next();
		// Verifica se a entrada ? v?lida.
		if(getIn.equalsIgnoreCase("s")) {
			// Atribui para verdadeiro o retorno.
			result = true;
		}
		return result;
	}
	/**
	 * Retorna se deve realizar a exclus?o do registro.
	 * @return se deve realizar a exclus?o do registro.
	 */
	protected boolean confirmDelete() {
		// Vari?vel de retorno.
		boolean result = false;
		// Imprime a mensagem de confirma??o.
		System.out.println("Deseja realizar a exclus?o? S/N");
		// Recupera a entrada.
		String getIn = sc.next();
		// Verifica se a entrada ? v?lida.
		if(getIn.equalsIgnoreCase("s")) {
			// Atribui para verdadeiro o retorno.
			result = true;
		}
		return result;
	}
}
