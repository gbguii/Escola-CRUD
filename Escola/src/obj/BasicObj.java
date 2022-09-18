package obj;

import java.util.Date;

public class BasicObj {
	/** Data de in�cio do registro. */
	private Date DtBegin;
	/** Data de atualiza��o do registro. */
	private Date DtUpdate;
	/** Data de fim do registro. */
	private Date DtEnd;
	
	/**
	 * Construor padr�o.
	 */
	public BasicObj() {

	}
	
	/**
	 * Retorna a data de in�cio do registro.
	 * @return a data de in�cio do registro.
	 */
	public Date getDtBegin() {
		return DtBegin;
	}
	
	/**
	 * Define a data de in�cio do registro.
	 * @param dtBegin a data de in�cio do registro.
	 */
	public void setDtBegin(Date dtBegin) {
		DtBegin = dtBegin;
	}
	
	/**
	 * Retorna a data de atualiza��o do registro.
	 * @return a data de atualiza��o do registro.
	 */
	public Date getDtUpdate() {
		return DtUpdate;
	}
	
	/**
	 * Define a data de atualiza��o do registro.
	 * @param dtUpdate a data de atualiza��o do registro.
	 */
	public void setDtUpdate(Date dtUpdate) {
		DtUpdate = dtUpdate;
	}
	
	/**
	 * Retorna a data de fim do registro.
	 * @return a data de fim do registro.
	 */
	public Date getDtEnd() {
		return DtEnd;
	}
	
	/**
	 * Define a data de fim do registro.
	 * @param dtEnd a data de fim do registro.
	 */
	public void setDtEnd(Date dtEnd) {
		DtEnd = dtEnd;
	}
	
	
}
