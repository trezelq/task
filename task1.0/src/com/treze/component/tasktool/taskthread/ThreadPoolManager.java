package com.treze.component.tasktool.taskthread;

import com.treze.component.tasktool.log.ITaskToolLog;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


/**
 * @author lq
 *
 */
public class ThreadPoolManager {
	
	private ITaskToolLog logger = null;
	
	private static int maxThreadCount = 32767;
	
	private static final int DEFULT_COUNT = 10;
	
	private static Map<String, Vector<TaskThread>> poolMap = null;

	private static ThreadPoolManager manager = null;

	private ThreadPoolManager() {
		poolMap = new Hashtable();
	}

	public void initPool(int num, String key) {
		Vector vector = getPool(key);
		if (num <= 0) {
			num = DEFULT_COUNT;
		}

		TaskThread taskThread = null;
		for (int i = 0; i < num; i++) {
			taskThread = new TaskThread(key);
			vector.addElement(taskThread);
		}
		poolMap.put(key, vector);
	}

	private Vector getPool(String key) {
		Vector vector = poolMap.get(key);
		if (vector == null) {
		    vector = new Vector<TaskThread>(30);
			poolMap.put(key, vector);
		}
		return vector;
	}

	public static ThreadPoolManager getInstance() {
		if (manager == null) {
			manager = new ThreadPoolManager();
		}
		return manager;
	}

	public void stopAll() {
		Set set = poolMap.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			stop((String) it.next());
		}
		poolMap.clear();
	}

	public void startUpAll() {
		Set set = poolMap.keySet();
		Iterator it = set.iterator();
		Vector vector = null;
		while (it.hasNext()) {
			startUp((String) it.next());
		}
	}

	public void startUp(String key) {
		Vector vector = poolMap.get(key);
		if (vector == null) {
			return;
		}
		TaskThread taskThread = null;
		for (int i = 0; i < vector.size(); i++) {
			taskThread = (TaskThread) vector.elementAt(i);
			if (taskThread != null) {
				taskThread.start();
			}
		}
	}

	public void stop(String key) {
		Vector vector = poolMap.get(key);
		if (vector == null) {
			return;
		}
		TaskThread taskThread = null;
		for (int i = 0; i < vector.size(); i++) {
			taskThread = (TaskThread) vector.elementAt(i);
			if (taskThread != null) {
				taskThread.shutdown();
			}
		}
	}
}
