package parse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package parse
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/24 7:14 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {

        List<String> no = new ArrayList<>();
        no.add("360077885027053568#*#360060420196855808");

        List<String> yes = new ArrayList<>();
        no.add("359340047662772224#*#359340039907504128#*#359340043560742912#*#360018559520481280");

        List<Long> collect = no.stream().map(Long::parseLong).collect(Collectors.toList());
        System.out.println(collect.toString());


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for(int a : list){
            System.out.println(a);
        }

    }
}