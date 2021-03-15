package com.example.mytestdemo.LeeCode.DiGui;

/**
 * 汉诺塔
 * 递归经典案例
 * https://blog.csdn.net/qq_45349785/article/details/101176461?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=1328627.9889.16153562440537807&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
 */

public class HannoTa {
    public static void main(String[] args) {
        hm(2, 'a', 'b', 'c');
    }

    private static void hm(int m, char a, char b, char c) {
        if (m == 1) {
            //当递归到最后一个盘子，直接把A盘的移动到C盘上；
            System.out.println(a + "-->" + c);
        } else {
            //把 m-1上面的盘子从A柱借助C柱放置B柱
            hm(m - 1, a, c, b);
            System.out.println(a + "-->" + c);    //把A柱上的盘子（最大那个）移动到C盘
            //把m-1个盘子从B柱借助A柱放置在C柱上
            hm(m - 1, b, a, c);
        }
    }

}