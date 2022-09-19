package beanView;

import Exception.ShoolException;

public class AbstractBeanView {
	
	/**
	 * Valida se uma string para atributo nome é valida.
	 * @param value String de nome.
	 * @return Retorna o nome váido.
	 * @throws ShoolException Em caso valor não ser válido.
	 */
	protected String validateName(String value) throws ShoolException {
		// Verifica se o valor não vazio ou nulo.
		if(value.isEmpty() || value == null || value.trim().isEmpty()) {
			throw new ShoolException("O nome está vazio");
		}else {
			return value;
		}
	}
}
