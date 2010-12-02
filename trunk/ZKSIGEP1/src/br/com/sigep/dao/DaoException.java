package br.com.sigep.dao;

public class DaoException extends Exception{
	public String className;
	public DaoException(String msg, String className) {
		super(msg);
		this.className = className;
	}
}
