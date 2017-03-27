package com.treze.component.tasktool.config;

public class TaskConfig {
	
	private String key = null;
	
	private int poolSize = 0;
	
	public TaskConfig(){}
	
	public TaskConfig(String key, int size){
	    this.key = key;
	    this.poolSize  = size;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

}
