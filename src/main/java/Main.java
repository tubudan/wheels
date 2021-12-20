import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        int s = 11;
        assert s>=123;
        System.out.println("Hello World!");
        String a = "ABCD";
        String b = a.substring(2, 3);
        System.out.println(b);
        Class cls = a.getClass();
        System.out.println(cls);
        String c = (String) cls.newInstance();

    }

    //枚举类
    enum WeekDay{
        SUN, MON, TUE, WED, THU, FRI, SAT
    }
}
