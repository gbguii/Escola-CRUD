package obj;

import java.util.Date;

public class BasicObj {
	/** Data de início do registro. */
	private Date DtBegin;
	/** Data de atualização do registro. */
	private Date DtUpdate;
	/** Data de fim do registro. */
	private Date DtEnd;
	
	/**
	 * Construor padrão.
	 */
	public BasicObj() {

	}
	
	/**
	 * Retorna a data de início do registro.
	 * @return a data de início do registro.
	 */
	public Date getDtBegin() {
		return DtBegin;
	}
	
	/**
	 * Define a data de início do registro.
	 * @param dtBegin a data de início do registro.
	 */
	public void setDtBegin(Date dtBegin) {
		DtBegin = dtBegin;
	}
	
	/**
	 * Retorna a data de atualização do registro.
	 * @return a data de atualização do registro.
	 */
	public Date getDtUpdate() {
		return DtUpdate;
	}
	
	/**
	 * Define a data de atualização do registro.
	 * @param dtUpdate a data de atualização do registro.
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
