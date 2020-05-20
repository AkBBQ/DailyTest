package Node;

/**
 * 单链表
 */

public class SingleNodeDemo {



    public class Node{
        private String data;

        private Node node;
    }


    public static void main(String[] args) {
        String name = "451755345909645312,451752215285334016,6363581702691831808,83567707403870208";
        Long capitalId = 451755345909645312L;

        if(name.contains(capitalId.toString())){
            System.out.println(1111111);
        }
    }
}