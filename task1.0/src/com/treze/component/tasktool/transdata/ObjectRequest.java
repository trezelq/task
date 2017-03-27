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
public class ObjectRequest implements Serializable{

    private static final long serialVersionUID = -7031324164055673599L;
    
    private int operationCode;
    
    public ObjectRequest() {
        super();
    }

    public int getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }

}
