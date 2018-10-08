package com.tusiji.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * jdk1.8 stream
 * 参考
 * https://blog.csdn.net/chenhao_c_h/article/details/80691284
 * https://www.jianshu.com/p/e6e023aa1e05
 */
public class StreamStudy {
    public static void main(String[] args) {

        Random r = new Random();
        List<User> list = new ArrayList<>();
        for (int i=0;i<10;i++) {
            User u = new User(i*100,r.nextInt(100));
            list.add(u);
        }
        System.out.println("list "+list);
        System.out.println();

        // 排序
        Collections.sort(list,(User u1,User u2) -> {
            return u1.getAge()-u2.getAge();
        });
        System.out.println("list "+list);
        System.out.println();

        // 排序  如果->后是一行代码 可以不用{}
        Collections.sort(list,(User u1,User u2) -> u1.getAge()-u2.getAge());
        System.out.println("list "+list);
        System.out.println();

        //stream不会改变原来的list 只是原来的视图 最后用collect生成新的list
        List<Integer> list1 = list.stream().filter(user -> user.getAge()>10)
                     .sorted((User u1,User u2) -> u1.getAge()-u2.getAge())
                     .map(user -> user.getAge()+1).collect(Collectors.toList());
        System.out.println("fiter sort map "+list1);
        System.out.println("list "+list);
        System.out.println();

        // 统计功能
        IntSummaryStatistics statistics = list.stream().mapToInt(user -> user.getAge()).summaryStatistics();
        System.out.println("average "+statistics.getAverage());
        System.out.println("max "+statistics.getMax());
        System.out.println("sum "+statistics.getSum());
        System.out.println();

        list.forEach(u -> System.out.print(u.getAge()+" "));

        // 双冒号 string -> string.toUpperCase() 等价于 String::toUpperCase
    }

    static class User {

        private long id;

        private int age;

        public User(long id, int age) {
            this.id = id;
            this.age = age;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "User{" + "id=" + id + ", age=" + age + '}';
        }
    }
}
