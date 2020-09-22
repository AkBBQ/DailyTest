package com.example.mytestdemo.Utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2020/9/22.
 */
public class TreeUtils {
    public static List<Map<String, Object>> getTree(String fieldName, String parentFieldName, String childListName, List srcList) {

        LinkedList<Map<String, Object>> list = new LinkedList();
        for (int i = 0; i < srcList.size(); i++) {
            list.add(object2Map(srcList.get(i)));
        }

        LinkedList<Map<String, Object>> tree = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> row = list.get(i);
            if (!exists(list, fieldName, row.get(parentFieldName))) {//判断row是否为一级节点
                tree.add(row);
            }
        }

        LinkedList<Map<String, Object>> toDo = new LinkedList<>();
        for (int i = 0; i < tree.size(); i++) {
            toDo.add(tree.get(i));
        }
        while (toDo.size() > 0) {
            Map<String, Object> node = toDo.removeFirst(); //获取node节点并将其从获取子节点的行列移除
            // 获取子节点
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> row = list.get(i);
                //判断当前row是否为当前node节点的子节点
                if (String.valueOf(row.get(parentFieldName)).equals(String.valueOf(node.get(fieldName)))) {
                    if (node.get(childListName) != null) {
                        LinkedList<Map<String, Object>> childList = (LinkedList) node.get(childListName);
                        childList.add(row);
                    } else {
                        LinkedList<Map<String, Object>> childList = new LinkedList<>();
                        childList.add(row);
                        node.put(childListName, childList);
                    }
                    toDo.add(row); //将确认为某个node节点的子节点的row加入到获取子节点的行列
                }
            }
        }
        return tree;
    }

    public static boolean exists(List<Map<String, Object>> existList, String fieldName, Object parentId) {
        for (int i = 0; i < existList.size(); i++) {
            if (String.valueOf(existList.get(i).get(fieldName)).equals(String.valueOf(parentId == null ? "" : parentId)))
                return true;
        }
        return false;
    }

    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj instanceof Map) {
            return (Map) obj;
        }
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
