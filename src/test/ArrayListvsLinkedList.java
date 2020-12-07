package test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListvsLinkedList {

    public static void main(String[] args) {
        // 头部添加元素
        //      LinkedList更快，创建新头部节点对象，并更改头部节点的next和原头部节点的prev引用
        //      ArrayList需要扩容创建新数组并拷贝旧数组的数据+新数组指定区域数据迁移时的拷贝
        addHead();
        // 尾部添加元素
        //      LinkedList 更慢，因为每次都要创建尾部节点对象
        //      ArrayList需要扩容创建新数组并拷贝就数组的数据
        addLast();
    }

    private static void addLast() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long arrayListStartTime = System.currentTimeMillis();
        for (int i = 500000; i > 0; i--) {
            arrayList.add(i);
        }
        System.out.println("arrayList add Last consume time: " + (System.currentTimeMillis() - arrayListStartTime));

        LinkedList<Integer> linkedList = new LinkedList<>();
        long linkedListStartTime = System.currentTimeMillis();
        for (int i = 500000; i > 0; i--) {
            linkedList.add(i);
        }
        System.out.println("linkedList add Last consume time: " + (System.currentTimeMillis() - linkedListStartTime));
    }

    private static void addHead() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long arrayListStartTime = System.currentTimeMillis();
        for (int i = 500000; i > 0; i--) {
            arrayList.add(0, i);
        }
        System.out.println("arrayList add Head consume time: " + (System.currentTimeMillis() - arrayListStartTime));

        LinkedList<Integer> linkedList = new LinkedList<>();
        long linkedListStartTime = System.currentTimeMillis();
        for (int i = 500000; i > 0; i--) {
            linkedList.add(0, i);
        }
        System.out.println("linkedList add Head consume time: " + (System.currentTimeMillis() - linkedListStartTime));
    }

}
