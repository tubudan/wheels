package pers.hx.wheels.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ForwardAndBackwardNDays {
    public static void main(String[] args) {
        int days = 10;
        System.out.println("Hello World!");
        ForwardAndBackwardNDays fabnd = new ForwardAndBackwardNDays();
        fabnd.dayChange(-days);   //前第10天
        fabnd.dayChange(days);   //后第10天
    }

    public void backWard(int n) {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        calendar1.add(Calendar.DATE, -n);
        String three_days_ago = sdf1.format(calendar1.getTime());
        System.out.println(three_days_ago);
    }

    public void foreWard(int n) {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        calendar1.add(Calendar.DATE, n);
        String three_days_after = sdf1.format(calendar1.getTime());
        System.out.println(three_days_after);
    }

    public void dayChange(int n) {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        calendar1.add(Calendar.DATE, n);
        String three_days_after = sdf1.format(calendar1.getTime());
        System.out.println(three_days_after);
    }
}
