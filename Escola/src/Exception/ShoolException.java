package Exception;

@SuppressWarnings("serial")
public class ShoolException extends RuntimeException{
	/** Mensagem que ser? exibida ao usu?rio. */
	private String mensage = "";
	
	/**
	 * Lan?a uma exce??o ao ser chamada.
	 * @param value mensagem da exce??o.
	 */
	public ShoolException(String value) {
		this.mensage = value;
	}
	
	/**
	 * Retorna a mensagem que gerou a exce??o.
	 * @return a mensagem que gerou a exce??o.
	 */
	public String getMenssage() {
		return this.mensage;
	}
}
