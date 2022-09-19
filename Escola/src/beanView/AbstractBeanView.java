package beanView;

import Exception.ShoolException;

public class AbstractBeanView {
	
	/**
	 * Valida se uma string para atributo nome � valida.
	 * @param value String de nome.
	 * @return Retorna o nome v�ido.
	 * @throws ShoolException Em caso valor n�o ser v�lido.
	 */
	protected String validateName(String value) throws ShoolException {
		// Verifica se o valor n�o vazio ou nulo.
		if(value.isEmpty() || value == null || value.trim().isEmpty()) {
			throw new ShoolException("O nome est� vazio");
		}else {
			return value;
		}
	}
}
