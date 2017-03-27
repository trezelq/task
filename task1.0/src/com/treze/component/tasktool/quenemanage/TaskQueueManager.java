package com.treze.component.tasktool.quenemanage;

import com.treze.component.tasktool.taskmanage.BaseTask;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class TaskQueueManager {

    private static TaskQueueManager oTaskQueueManager = null;
    
    private static Map queueMap = null;
    
    private TaskQueueManager() {
    	queueMap = new Hashtable();
    }
    
    public synchronized static TaskQueueManager getInstance() {
        if (null == oTaskQueueManager) {
            oTaskQueueManager = new TaskQueueManager();
        }
        return oTaskQueueManager;
    }
    
    public void addQueue(String key){
    	Queue queue = new Queue();
    	queueMap.put(key, queue);
    }
    
    // 向队列尾部插入元素
    public synchronized void putTask(BaseTask task, String key) {
    	Queue queue = getQueue(key);
    	if(queue == null){
    		return ;
    	}
    	queue.put(task);
        this.notifyAll();
    }

    // 得到队首元素，且删除
    public synchronized BaseTask getTask(String key) {
    	Queue queue = getQueue(key);
    	if(queue == null){
    		return null;
    	}
        /* 队列若为空，引发EmptyQueueException异常 */
        try {
            while (queue.empty()) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (BaseTask) queue.get();
    }

    // 从队列首读一个元素，但队列保持不变；
    public synchronized BaseTask getFirstTask(String key) {
    	Queue queue = getQueue(key);
    	if(queue == null){
    		return null;
    	}
        try {
            while (queue.empty()) {
                this.wait();
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        return (BaseTask) queue.get();
    }

    // 从队列中读一个元素，但队列保持不变；
    public synchronized BaseTask getLastTask(String key) {
    	Queue queue = getQueue(key);
    	if(queue == null){
    		return null;
    	}
        try {
            while (queue.empty()) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (BaseTask) queue.getLast();
    }

    // 从队列中移除第一个元素；
    public synchronized BaseTask removeFirstTask(String key) {
    	Queue queue = getQueue(key);
    	if(queue == null){
    		return null;
    	}
        while (queue.empty()) {
            return null;
        }
        return (BaseTask) queue.remove(0);
    }
    
    private Queue getQueue(String key){
    	return (Queue)queueMap.get(key);
    }
    
    public void clear(){
    	Set set = queueMap.keySet();
    	Iterator it = set.iterator();
    	Queue queue = null;
    	while( it.hasNext() ){
    		queue = (Queue)queueMap.get(it.next());
    		queue.clear();
    	}
    	queueMap.clear();
    }
}
