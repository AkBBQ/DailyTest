package change;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package change
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/5/7 10:38 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class ss {

    public static void main(String[] args) {

        List<Map<String,String>> list = new ArrayList<>();

        Map<String,String> map1 = new HashMap<>();
        map1.put("name","sun");
        map1.put("age","2");

        Map<String,String> map2 = new HashMap<>();
        map2.put("name","sun2");
        map2.put("age","1");

        Map<String,String> map3 = new HashMap<>();
        map3.put("name","sun3");
        map3.put("age","3");


        list.add(map1);
        list.add(map2);
        list.add(map3);


        List<Map<String, String>> collect = list.stream()
                .filter(item -> !item.get("age").isEmpty())
                .sorted(Comparator.comparing(stringStringMap -> stringStringMap.get("age")))
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
    }
}