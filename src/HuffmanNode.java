package com.xobx;
public class HuffmanNode {

    int data;
    char c;

    HuffmanNode(int d, char c){

        this.data = d;
        this.c = c;
        this.left = null;
        this.right = null;
    }



    HuffmanNode left;
    HuffmanNode right;
}
