package com.treze.component.tasktool.transdata;

import java.io.Serializable;

/**
 *
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Result implements Serializable {

	private static final long serialVersionUID = -1922768228306735245L;
	
	private int iResult;
	
	private String message;
	
	public static final int SUCCEED = 1;
	
	public static final int FAILED = 0;

	public Result() {
		super();
	}

	public static Result getInstance() {
		return new Result();
	}

	public String getMessage() {
		return message;
	}

	public int getResult() {
		return iResult;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResult(int result) {
		this.iResult = result;
	}
}
