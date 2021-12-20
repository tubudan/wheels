package pers.hx.wheels.sorts;

import java.util.*;

/**
 * @program: wheels
 * @description:
 * @create: 2019-11-22 13:17
 */
public class HashMapSort {
    public static void main(String[] args) {
        Map<String, List<Object>> map = new HashMap();
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        ArrayList<Object> list3 = new ArrayList<>();
        list1.add(Arrays.asList(1, 20, 123, "null"));
        list2.add(Arrays.asList(12, 123, 43, null, null));
        list3.add(Arrays.asList(null, null));


        map.put("张三", list1);
        map.put("李四", list2);
        map.put("王五", list3);
        List<Map.Entry<String, List<Object>>> listSort = new ArrayList<Map.Entry<String, List<Object>>>(map.entrySet());
        Collections.sort(listSort, new Comparator<Map.Entry<String, List<Object>>>() {
            @Override
            public int compare(Map.Entry<String, List<Object>> o1, Map.Entry<String, List<Object>> o2) {
                //o1 o2比较逻辑
                int sum1 = 0;
                int sum2 = 0;
                int size = o1.getValue().size();
                int size1 = 0;
                int size2 = 0;
                for (int m = 0; m < size; m++) {
                    if (o1.getValue().get(m) != "null" && (o1.getValue().get(m) instanceof Integer)) {
                        size1++;
                        sum1 += (Integer) o1.getValue().get(m);
                    }
                    if (o2.getValue().get(m) != "null" && (o2.getValue().get(m) instanceof Integer)) {
                        size2++;
                        sum2 += (Integer) o2.getValue().get(m);
                    }
                }

                Integer ave1 = size1 == 0 ? -1 : sum1/size1;
                Integer ave2 = size2 == 0 ? -1 : sum2/size2;

                if (null != ave1 || null != ave2) {
                    return ave2.compareTo(ave1);
                }
                return 0;
            }
        });

        for (Map.Entry<String, List<Object>> mapping : listSort) {
            System.out.println(mapping.getKey());
        }
    }
}



