package com.treze.component.tasktool.log;

public class TaskToolLog {
	
	public static void  logInfo(ITaskToolLog logger, String className, String methodName, String message){
		if( logger != null){
			logger.logInfo(className, methodName, message);
		}
	}
}
