package pers.hx.proxy;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-12-07 10:34
 */

public class AliSmsService {
    public String send(String message) {
        System.out.println("Send Message :" + message);
        return message;
    }
}
