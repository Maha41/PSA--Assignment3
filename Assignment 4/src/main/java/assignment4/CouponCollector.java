package assignment4;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author aMaha
 */
public class CouponCollector<Key, Value> {
     
    private static int INIT_CAPACITY;
    public static boolean flag=true;
    public static int count=0;
    public int n;                                // number of key-value pairs
    public static int c=0;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables


    public CouponCollector() {
        this(INIT_CAPACITY);
    } 
    public CouponCollector(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys

//     hash value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 
//    private int hash(Key key) {
//        char[] k=String.valueOf(key).toCharArray();
//        int hash=0;
//           for (int i = 0; i < k.length; i++)
//            hash = ((hash * 31) + k[i])%m;
//
//        return hash;
//    } 

    public int size() {
        return n;
    } 

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    public void put(Key key, Value val,String initial){

        int i = hash(key);
        if (!st[i].getCollision(key)){ 
            c++;
            //System.out.println(c);
        }
        if(c==INIT_CAPACITY){
            count+=n;
            flag=false;
            // System.out.println("full: "+n);
        }

         put(key, val);
    }
    public void put(Key key, Value val) {
         if (key == null) throw new IllegalArgumentException("first argument to put() is null");
         int i = hash(key);
         n++;
         st[i].put(key, val);
    } 

    

       public static void main(String[] args) {
        for(int k=100;k<=10000;k+=100){  
            count=0;
           INIT_CAPACITY=k; 
        for(int j=0;j<=100;j++)
        {
        CouponCollector<String, Integer> st = new CouponCollector<String, Integer>(INIT_CAPACITY);
         c=0;
        int i=0;
        while(flag==true || c<=INIT_CAPACITY) {
          //Scanner in = new Scanner(System.in);
            //String key = in.next();
            Random r=new Random();
            String key= String.valueOf(r.nextInt());
            if(flag)
            st.put(key, i,"put");
            else 
            {
                flag=true;
                break;
            }
           i++;

        }
        }
           System.out.println("Average Count for k:"+k+" "+count/100);
     }
   }
}
