import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestJSON {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("err_no", 500);
        map.put("err_msg", "notsupport.");
        String result1 = (String) map.get("err_msg");
        System.out.println("map直接打印结果：" + map);
        System.out.println("maptoString打印：" + map.toString());
        System.out.println("map取值err_msg打印：" + result1);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("err_no", 500);
        jsonObject.put("err_msg", "notsupport.");
        jsonObject.put("idx", 1);



    }

}
