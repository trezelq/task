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
public class ObjectResponse implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 2699543015536135601L;
    private Result result = new Result();
    private int operationCode;

    public ObjectResponse() {
        super();
    }
    public static ObjectResponse getInstance(){
        return new ObjectResponse();
    }

    public int getOperationCode() {
        return operationCode;
    }

    public Result getResult() {
        return result;
    }
    
    public String getResultMes(){
    	return result.getMessage();
    }
    
    public void setResultMes(String mes){
    	result.setMessage(mes);
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
