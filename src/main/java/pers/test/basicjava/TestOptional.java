package pers.test.basicjava;

import java.util.Optional;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-11-18 14:19
 */

public class TestOptional {
    public static void main(String[] args) {
        //参考 https://it.deepinmind.com/java/2014/09/29/null-pointer-saviours.html
        Optional<String> wrapped = Optional.of(null);
        if (wrapped.isPresent()) {
            System.out.println("Got string " + wrapped.get());
        } else {
            System.out.println("omg!");
        }
    }
}
