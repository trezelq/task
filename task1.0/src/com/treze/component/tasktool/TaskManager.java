package com.treze.component.tasktool;

import com.treze.component.tasktool.config.TaskConfig;
import com.treze.component.tasktool.quenemanage.TaskQueueManager;
import com.treze.component.tasktool.taskmanage.BaseTask;
import com.treze.component.tasktool.taskthread.ThreadPoolManager;

import java.util.List;


/**
 * 任务管理器，提高任务池的初始化、销毁、任务添加
 * @author lq
 */
public class TaskManager {
	
    /**
     * 初始化一组任务池
     * @param list
     */
	public static void initTaskModule(List<TaskConfig> list){
		if( list != null){
			TaskConfig config = null;
			for(int i = 0; i < list.size(); i++){
				config = (TaskConfig) list.get(i);
				initTaskModule(config);
			}
		}
	}
	
	/**
	 * 初始化一个任务池
	 * @param config
	 */
	public static void initTaskModule(TaskConfig config){
		TaskQueueManager.getInstance().addQueue(config.getKey());
		ThreadPoolManager.getInstance().initPool(config.getPoolSize(), config.getKey());
		ThreadPoolManager.getInstance().startUp(config.getKey());
	}
	
	/**
	 * 清空任务池，并停止和销毁所有任务
	 */
	public static void destoryModule(){
		TaskQueueManager.getInstance().clear();
		ThreadPoolManager.getInstance().stopAll();
	}
	
	/**
	 * 向指定任务池添加一个任务。
	 * @param task
	 * @param config
	 */
	public static void putTask(BaseTask task, TaskConfig config) {
        TaskQueueManager.getInstance().putTask(task, config.getKey());
    }
}
