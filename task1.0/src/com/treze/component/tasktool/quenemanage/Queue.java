package com.treze.component.tasktool.quenemanage;

import java.util.Vector;

public class Queue extends Vector {

    //向队列尾部插入元素
    public synchronized void put(Object task) {
        super.addElement(task);
    }

    //得到队首元素，且删除
    public synchronized Object get() {
        /* 队列若为空，引发EmptyQueueException异常 */
        if (this.empty()){
            return null;
        }
        return super.remove(0);
    }

    //从队列首读一个元素，但队列保持不变；
    public synchronized Object getFirst() {
        if (this.empty()){
            return null;
        }
        return super.elementAt(0);
    }

    //从队列中读一个元素，但队列保持不变；
    public synchronized Object getLast() {
        if (this.empty()){
          return null;
        }
        return super.lastElement();
    }

    //判断队列是否为空，空则返回真
    public boolean empty() {
        return isEmpty();
    }

    //清空队列
    public synchronized void clear() {
        removeAllElements();
    }

    //查找距队首最近的元素的位置，若不存在，返回-1
    public int search(Object task) {
        return indexOf(task);

    }

    //得到队列的大小
    public int getSize() {
        return super.size();

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
