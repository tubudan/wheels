package pers.hx.proxy;

/**
 * @author:hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-12-07 09:51
 */
public interface ISmsService {
    String send(String message);

    String get(String message);
}
