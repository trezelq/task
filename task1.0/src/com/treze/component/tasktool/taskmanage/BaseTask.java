package com.treze.component.tasktool.taskmanage;

import com.nzjf.server.component.taskplantool.transdata.Result;



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
public abstract class BaseTask {

    //??????
    protected int operationCode;
    //???????????????????? ????????
    protected Result result;
    
    protected Object obj = null;

    public BaseTask(Object object) {
        super();
        obj = object;
    }
    
    public BaseTask(){
    	super();
    }

    public int getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }

    public abstract boolean execute() throws Exception;

    /**
     * @return the obj
     */
    protected Object getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    protected void setObj(Object obj) {
        this.obj = obj;
    }
}
