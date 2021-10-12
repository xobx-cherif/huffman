package com.xobx;
import java.io.IOException;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int [] charFreq = new int [27];
        int n=26;
        char [] charArray = new char [27];
        //init charFreq, charArray and n

        System.out.println("Huffman code by bilel!");
        Scanner s = new Scanner(System.in);
        String fileName;
        //System.out.println("Enter the file name :");
        fileName = args[0];

        Huffman hf = new Huffman(fileName);
        try{
            charFreq = hf.countLetters();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0 ; i<n ; i++) {
            if (charFreq[i] != 0) {
                int z = i + 65;
                charArray[i] = (char) (z);

            }
        }
        charArray[26] = ' ';

        // Should delete null elements from array


        // creating a priority queue q.
        // makes a min-priority queue(min-heap).
        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<HuffmanNode>(n, new HuffmanComparator());

        for (int i = 0; i <= n; i++) {

            // creating a huffman node object
            // and adding it to the priority-queue.
            if(charFreq[i] != 0) {
                HuffmanNode hfn = new HuffmanNode(charFreq[i], charArray[i]);

                // add functions adds
                // the huffman node to the queue.
                q.add(hfn);
            }
        }

        // create a root node
        HuffmanNode root = null;

        // Extract the two minimum value
        // from the heap each time until
        // its size reduces to 1

        while (q.size() > 1) {

            // first min extract.
            HuffmanNode x = q.peek();
            q.poll();

            // second min extarct.

            HuffmanNode y = q.peek();
            q.poll();

            // new node f which is equal
            // to the sum of the frequency of the two nodes
            HuffmanNode f = new HuffmanNode(x.data + y.data, '-');


            // first extracted node as left child.
            f.left = x;

            // second extracted node as the right child.
            f.right = y;

            // marking the f node as the root node.
            root = f;

            // add this node to the priority-queue.
            q.add(f);
        }

        Huffman.printCode(root, "");
        Hashtable<String, String> h =Huffman.getHashtable();



    }
}
