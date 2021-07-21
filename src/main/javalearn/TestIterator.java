import java.util.ArrayList;
import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");

        // 获取迭代器
        Iterator<String> it = sites.iterator();
        // 输出集合中的第一个元素
        System.out.println(it.next());
        System.out.println();
        // 输出集合中的所有元素
        Iterator<String> it1 = sites.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        // 删除元素 要删除集合中的元素可以使用remove()方法
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> it2 = numbers.iterator();
        while (it2.hasNext()) {
            Integer i = it2.next();
            if (i < 10) {
                it2.remove();  // 删除小于 10 的元素
            }
        }
        System.out.println(numbers);
    }
}
