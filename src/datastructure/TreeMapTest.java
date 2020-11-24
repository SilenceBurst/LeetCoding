package datastructure;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    /**
     * TreeMap implement SortedMap
     * 内部会对key排序 不需要复写hashcode() equals()
     * 传入的key必须实现Comparable接口，或者在TreeMap的构造方法中传入一个Comparator比较器
     * 用作key值的排序，返回为-1在前 返回为1在后
     * 注意！！！：compare或者compareTo 返回为0表示key相等 元素会被覆盖
     */
    public static void main(String[] args) {
        Map<Person, String> treeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.score, o2.score);
            }
        });
        treeMap.put(new Person("0", 0), "000");
        treeMap.put(new Person("1", 1), "111");
        treeMap.put(new Person("2", 2), "222");
        String test = treeMap.get(new Person("0", 0));
        System.out.println(test);
        // compare或者compareTo 返回为0表示key相等 会覆盖
        treeMap.put(new Person("0", 0), "new 000");
        String newTest = treeMap.get(new Person("0", 0));
        System.out.println(newTest);
    }

    static class Person {
        String name;
        int score;

        public Person(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    /*class Person implements Comparable {
        String name;
        int score;

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }*/
}
