package com.treze.component.tasktool;

import com.treze.component.tasktool.config.TaskConfig;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Socket socket = new Socket();
//		OutputStream oos = null;
//		InputStream ois = null;
//		try {
//			socket.connect(new InetSocketAddress("192.168.16.36", 6000));
//			ois = socket.getInputStream();
//			oos = socket.getOutputStream();
//			Base64 base = new Base64();
//			String cmd = base.encode("".getBytes());
//			oos.write(cmd.getBytes());
//			oos.flush();
//			byte[] b = new byte[1024];
//			ois.read(b);
//			System.out.println(new String(b));
//			oos.close();
//			ois.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		DecimalFormat a = new DecimalFormat(".####"); 
		Double value = ((double) 10)/3;
	     String s= a.format(value); 
	     System.out.println(s); 
	}
	
	private List<TaskConfig> initTaskConfig() {
        List<TaskConfig> taskConfig = new ArrayList<TaskConfig>();
        TaskConfig testTask = new TaskConfig();
		testTask.setKey("test");
		testTask.setPoolSize(10);
        
        taskConfig.add(testTask);
        return taskConfig;
    }
	private static String getText(String abc){
	    if(abc == null){
	    	return null;
	    }	
	    StringBuilder sb = new StringBuilder();
	    sb.append("bj");
		if(abc.length() < 8){
			for(int i =0;i<(8-abc.length());i++){
				sb.append("0");
			}
		}
		sb.append(abc);
		return sb.toString();
	}

}
