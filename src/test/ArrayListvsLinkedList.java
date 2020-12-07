package test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListvsLinkedList {

    public static void main(String[] args) {
        // 头部区域添加元素
        //      LinkedList更快，只需要每次创建新头部节点对象，并更改头部节点的next和原头部节点的prev引用
        //      ArrayList需要可能的扩容及扩容时数据的拷贝+每次添加元素后原所有数据向后迁移
        addHead();
        //      在第二位添加元素
        //      LinkedList更快，相较于ArrayList可能的扩容及扩容时数据的拷贝+每次添加元素都需要index=1之后的数据向后迁移
        //      LinkedList只需要每次从首部向后遍历一次+创建节点对象
        addSecondHead();
        // 在中间添加元素
        //      ArrayList更快，查找元素的时间复杂度O(1)，耗时主要体现在可能的扩容及扩容时数据的拷贝+每次插入元素一半数据向后迁移
        //      LinkedList每次插入元素时查找元素的时间复杂度为O(n/2)，还有每次都需要创建节点的耗时
        addCenter();
        // 尾部区域添加元素
        //      LinkedList更慢，因为每次都要创建尾部节点对象
        //      ArrayList仅需要可能的扩容及扩容时数据的拷贝，不需要数据的迁移
        addLast();
        //      在倒数第二位添加元素
        //      LinkedList依然很慢，主要是每次添加元素都需要从尾部向前遍历一次+创建节点对象
        //      而ArrayList需要可能的扩容及扩容时数据的拷贝+每次添加元素时，只需要原末尾元素向后迁移一位
        addSecondLast();
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

    private static void addSecondHead() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long arrayListStartTime = System.currentTimeMillis();
        for (int i = 500000; i > 0; i--) {
            if (arrayList.size() > 0) {
                arrayList.add(1, i);
            } else {
                arrayList.add(0, i);
            }
        }
        System.out.println("arrayList add Second Head consume time: " + (System.currentTimeMillis() - arrayListStartTime));

        LinkedList<Integer> linkedList = new LinkedList<>();
        long linkedListStartTime = System.currentTimeMillis();
        for (int i = 500000; i > 0; i--) {
            if (linkedList.size() > 0) {
                linkedList.add(1, i);
            } else {
                linkedList.add(0, i);
            }
        }
        System.out.println("linkedList add Second Head consume time: " + (System.currentTimeMillis() - linkedListStartTime));
    }

    private static void addCenter() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long arrayListStartTime = System.currentTimeMillis();
        for (int i = 100000; i > 0; i--) {
            arrayList.add(arrayList.size() >> 1, i);
        }
        System.out.println("arrayList add Center consume time: " + (System.currentTimeMillis() - arrayListStartTime));

        LinkedList<Integer> linkedList = new LinkedList<>();
        long linkedListStartTime = System.currentTimeMillis();
        for (int i = 100000; i > 0; i--) {
            linkedList.add(linkedList.size() >> 1, i);
        }
        System.out.println("linkedList add Center consume time: " + (System.currentTimeMillis() - linkedListStartTime));
    }

    private static void addSecondLast() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long arrayListStartTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            if (arrayList.size() > 0) {
                arrayList.add(arrayList.size() - 1, i);
            } else {
                arrayList.add(i);
            }
        }
        System.out.println("arrayList add Second Last consume time: " + (System.currentTimeMillis() - arrayListStartTime));

        LinkedList<Integer> linkedList = new LinkedList<>();
        long linkedListStartTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            if (linkedList.size() > 0) {
                linkedList.add(linkedList.size() - 1, i);
            } else {
                linkedList.add(i);
            }
        }
        System.out.println("linkedList add Second Last consume time: " + (System.currentTimeMillis() - linkedListStartTime));
    }

    private static void addLast() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long arrayListStartTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            arrayList.add(i);
        }
        System.out.println("arrayList add Last consume time: " + (System.currentTimeMillis() - arrayListStartTime));

        LinkedList<Integer> linkedList = new LinkedList<>();
        long linkedListStartTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            linkedList.add(i);
        }
        System.out.println("linkedList add Last consume time: " + (System.currentTimeMillis() - linkedListStartTime));
    }
}
