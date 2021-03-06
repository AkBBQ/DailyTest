package com.example.mytestdemo.JavaDemo.List;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 手写 单链表
 *
 * @author angtai
 */

public class ListDemo {

    /**
     * 定义一个Node节点类
     */
    @Data
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 自定义一个链表
     */
    @Data
    public static class MyLinkedList {
        /**
         * 头节点
         */
        private Node head;
        /**
         * 尾节点
         */
        private Node tail;

        /**
         * 一共有多少个节点
         */
        private int size;


        /**
         * 头部插入一个节点
         *
         * @param num
         */
        private void addInHead(int num) {
            //头部插入一个点
            head = new Node(num, head);
            if (tail == null) {
                tail = head;
            }
        }

        /**
         * 尾部插入一个节点
         *
         * @param num
         */
        private void addTailHead(int num) {
            if (null == tail) {
                head = new Node(num);
                tail = head;
            } else {
                tail.next = new Node(num);
                tail = tail.next;
            }
        }

        /**
         * 从头部删除一个节点
         */
        private void delHeadOneNode() {
            if (head != null) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            }
        }

        /**
         * 从尾部删除一个节点
         */
        private void delTailOneNode() {
            if (null != tail) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    Node s = head;
                    while (s.next != tail) {
                        s = s.next;
                    }
                    tail = s;
                    tail.next = null;
                }
            }
        }
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addInHead(1);
        myLinkedList.addInHead(2);
        myLinkedList.addInHead(3);
        myLinkedList.addInHead(4);
        myLinkedList.addTailHead(88);
        myLinkedList.addTailHead(99);

        Node head = myLinkedList.getHead();
        while (null != head.next) {
            System.out.println(head.getData());
            head = head.next;
        }


    }
}