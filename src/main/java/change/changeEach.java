package change;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package change
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/29 5:08 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class changeEach {

    public int[] change(int a,int b){

        int c = 0;
        c = a;
        a = b;
        b = c;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
        
        int[] result = new int[]{a, b};
        return result;
    }
}