package cn.xiaowenjie.common.exceptions;

public class PageException extends RuntimeException{
	
	private static final long serialVersionUID = -301930990922272792L;

	public PageException(String message) {
        super(message);
    }
}
