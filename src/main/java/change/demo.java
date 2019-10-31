package change;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package change
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/29 4:51 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {

    public static void main(String[] args) {
        int a = 1;
        int b =25;
       changeEach changeEach = new changeEach();
        int[] change = changeEach.change(a, b);
        a = change[0];
        b = change[1];
        System.out.println(a);
        System.out.println(b);


    }


    private static void change(Integer a,Integer b){
        Integer c = 0;
        c = a;
        a = b;
        b = c;



        System.out.println("第一步,a="+a);
        System.out.println("第二步,b="+b);
    }
}