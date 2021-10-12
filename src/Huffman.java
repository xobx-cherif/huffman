package com.xobx;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Huffman {


    static Hashtable<String, String> h =
            new Hashtable<String, String>();

    static String filename;

    Huffman(String s){
        filename = s;
    }

    // recursive function to print the
    // huffman-code through the tree traversal.
    // Here s is the generated huffman code .

    public static void printCode(HuffmanNode root, String s)
    {

        // base case; if the left and right are null
        // then its a leaf node
        if (root.left
                == null
                && root.right
                == null
                && (Character.isLetter(root.c) || root.c == ' ')) {

            // c is the character in the node
            System.out.println(root.c + ":" + s);
            h.put(Character.toString(root.c), s);

            return;
        }

        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.

        // recursive calls for left and
        // right sub-tree of the generated tree.
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static int[] countLetters() throws IOException{
        int[] freqs = new int[27];
        try(BufferedReader in = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = in.readLine()) != null){
                line = line.toUpperCase();
                for(char ch:line.toCharArray()){
                    if(Character.isLetter(ch)){
                        freqs[ch - 'A']++;
                    }
                    else if(ch == ' '){
                        freqs[26]++;
                    }
                }
            }
        }
        return freqs;
    }

    public static Hashtable<String, String> getHashtable(){

        return h;
    }
}
