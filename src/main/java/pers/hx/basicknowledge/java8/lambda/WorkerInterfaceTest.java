package pers.hx.basicknowledge.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: wheels
 * @description: (parameters)->expression  ||  (parameters)-{statements;}
 * @create: 2021-12-09 14:33
 */

public class WorkerInterfaceTest {
    public static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }

    public static void main(String[] args) {
        //lambda表达式
        execute(() -> System.out.println("lambda expression!"));

        //匿名类方式
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("anonymous class");
            }
        });

        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("zxc");
        System.out.println("lambda1");
        list.forEach((s -> System.out.println(s)));
        System.out.println("lambda2");
        list.forEach(System.out::println);
    }
}
