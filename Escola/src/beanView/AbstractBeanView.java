package beanView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.ShoolException;

public abstract class AbstractBeanView extends Crud {

	/**
	 * Retona uma lista todas as op��es do sistema no crud.
	 * 
	 * @return uma lista todas as op��es do sistema no crud.
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
	 * Executa a fun��o de crud conforme a op��o selecionada
	 * 
	 * @param option op��o selecionada.
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
			this.update();
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
	 * Valida se uma string para atributo nome � valida.
	 * 
	 * @param value String de nome.
	 * @return Retorna o nome v�ido.
	 * @throws ShoolException Em caso valor n�o ser v�lido.
	 */
	protected String validateName(String value) throws ShoolException {
		// Verifica se o valor n�o vazio ou nulo.
		if (value.isEmpty() || value == null || value.trim().isEmpty()) {
			throw new ShoolException("O nome est� vazio");
		} else {
			return value;
		}
	}
	
	protected boolean confirmUpdate() {
		boolean result = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja realizar a atualiza��o? S/N");
		String getIn = sc.next();
		if(getIn.equalsIgnoreCase("s")) {
			result = true;
		}
		sc.close();
		return result;
	}
	
}
