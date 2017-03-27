/**
 *
 */
package com.treze.component.tasktool.taskthread;


import com.treze.component.tasktool.quenemanage.TaskQueueManager;
import com.treze.component.tasktool.taskmanage.BaseTask;

/**
 * @author lq
 *
 */
public class TaskThread extends Thread {

	protected boolean runFlag;
	
	private String key = null;
	
    public TaskThread(String queueKey) {
        runFlag = true;
        key = queueKey;
    }

    public synchronized void run() {

        while (isRunning()) {
            try {
                BaseTask baseTask = TaskQueueManager.getInstance()
                                    .getFirstTask(key);
                boolean isSucc = false;
                if (baseTask != null) {
                    isSucc = baseTask.execute();
                }

               // TaskQueueManager.getInstance().removeFirstTask(key);
            } catch (Exception e) {
                 //TaskQueueManager.getInstance().removeFirstTask(key);
                e.printStackTrace();
            }
        }
    }
    
	public  boolean isRunning() {
        return runFlag;
    }

	protected  void setRunning(boolean flag) {
        runFlag = flag;
        if (flag) {
            this.notify();
        }
    }
    
    public  void shutdown(){
    	setRunning(false);
    	this.interrupt();
    }
}
