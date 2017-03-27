/**
 *
 */
package com.treze.component.tasktool;

import com.treze.component.tasktool.log.ITaskToolLog;
import com.treze.component.tasktool.log.TaskToolLog;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * @author lq
 *
 */
public class SyncFileServer extends Thread{
	
	private ITaskToolLog logger = null;
	
    private ServerSocket server = null;
    
    private boolean running = false;
    /**
     *
     */
    public SyncFileServer() {
        super();
        running = true;
        try {
            server = new ServerSocket (5040);
        } catch (IOException e) {
            server = null;
        }
    }
    
    public SyncFileServer(ITaskToolLog log){
    	logger = log;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    	Socket socket = new Socket();
    	try {
			socket.connect(new InetSocketAddress("10.253.1,71",2345), 500);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	socket.getInetAddress();
    }

    public void run() {
    	TaskToolLog.logInfo(logger, "SyncServer", "run()", "????????");
        if (server == null){
        	TaskToolLog.logInfo(logger, "SyncServer", "run()", "serversocket????");
            throw new NullPointerException("ServerSocket ????????????");
        }
        Socket clientSocket = null;

        while (isRunning()) {
            try {
                clientSocket = server.accept();
                TaskToolLog.logInfo(logger, "SyncServer", "run()", "????????????" + clientSocket.getInetAddress().getHostAddress());
//                BaseTask task = TaskFactory.createCaspServerTask(clientSocket);
//                TaskQueueManager.getInstance().putTask(task, TaskQueueManager.FILE_SYNC);
            } catch (IOException e) {
            	TaskToolLog.logInfo(logger, "SyncServer", "run()", "????" + e.getMessage());
            }
        }
    }

    /**
     * @return the running
     */
    public synchronized final boolean isRunning() {
        return running;
    }

    /**
     * @param running the running to set
     */
    public synchronized final void setRunning(boolean running) {
        this.running = running;
    }
    
    public synchronized void shutdown(){
    	setRunning(false);
    	try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	this.interrupt();
    }
}
