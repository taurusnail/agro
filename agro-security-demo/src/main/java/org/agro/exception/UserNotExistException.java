/**
 * 
 */
package org.agro.exception;

/**
 * @author gaoxiang
 *
 */
public class UserNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -743068964304561157L;
	
	private String id;
	
	public UserNotExistException(String id) {
		super("user not exist");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
