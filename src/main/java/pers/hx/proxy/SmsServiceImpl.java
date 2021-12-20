package pers.hx.proxy;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-12-07 09:52
 */

public class SmsServiceImpl implements ISmsService {
    public String send(String message) {
        System.out.println("Send Message :" + message);
        return message;
    }

    public String get(String message) {
        System.out.println("Get Message :" + message);
        return message;
    }
}
