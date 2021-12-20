package pers.hx.basicknowledge.serialize;

import java.io.Serializable;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-11-16 14:20
 */

public class Person implements Serializable {
    private static final long serialVersionUID = 4359709211352400087L;

    private Long id;

    private String name;

    public final String userName;

    private int age;

    public Person(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        userName = null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
