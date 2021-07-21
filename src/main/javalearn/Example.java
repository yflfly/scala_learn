package javalearn;

import java.util.HashMap;

class Example {
    public static void main(String[] args) {
        // 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<Integer, String>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);

        // 返回所有 key 组成的 set 集合视图
        System.out.println("Keys: " + sites.keySet());
        // keySet() 返回所有 key 组成的 set 视图
        // for-each loop 在该视图中访问每一个 key
        for(int key: sites.keySet()) {

            // 输出每个 key
            System.out.print(key + ", ");
        }

        System.out.println(sites.size());//

        sites.clear(); //删除所有键值对
        System.out.println(); // 可以实现换行符的功能
        System.out.println(sites);

    }
}