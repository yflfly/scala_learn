package compamyTestTag;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class example {
    public static void main(String[] args) {
        Map<Long, String> a = new HashMap<>();
        a.put(1L,"AA");
        a.put(1L,"BB");
        System.out.println(a);
        test();

    }

    public static void test() {
        String line = "{\"scene_info\":{\"100001\":{\"scenename\":\"主会场专题入口\",\"tabinfo\":{\"1001\":{\"tabname\":\"专题入口tab\",\"tabvalue\":[{\"style\":{\"title\":\"普工\",\"subtitle\":\"机会多多易上手\",\"picurl\":\"xxxxxxx\"},\"data\":{\"tabtrackid\":\"wkefhwkefhkwef\"},\"type\":1},{\"style\":{\"title\":\"附近\",\"subtitle\":\"周边好工作\",\"picurl\":\"xxxxxxx\"},\"data\":{\"tabtrackid\":\"emlbi5io35lmv\"},\"type\":1}]}},\"abtest\":\"smartbid_ocpc_zp_20200225_exp|1\"}},\"status\":200}";
        JSONObject jsonObject = JSON.parseObject(line);
        System.out.println(JSON.toJSONString(!jsonObject.getString("status").equals("200")));
        System.out.println(JSON.toJSONString(jsonObject.get("scene_info")));
        JSONObject jsonObject1 = JSON.parseObject(jsonObject.getString("scene_info"));
        System.out.println(JSON.toJSONString(jsonObject.getJSONObject("scene_info").getJSONObject("100001").getJSONObject("tabinfo").getJSONObject("1001").getJSONArray("tabvalue")));
    }
}
