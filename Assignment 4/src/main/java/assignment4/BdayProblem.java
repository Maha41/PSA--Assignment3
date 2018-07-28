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
public class BdayProblem<Key, Value> {
    private static  int INIT_CAPACITY;
    public static boolean flag=true;
    public static int count=0;
    public int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables


    /**
     * Initializes an empty symbol table.
     */
    public BdayProblem() {
        this(INIT_CAPACITY);
    } 

    public BdayProblem(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    

//     hash value between 0 and m-1
//    private int hash(Key key) {
//        return (key.hashCode() & 0x7fffffff) % m;
//    } 
    private int hash(Key key) {
       char[] k=String.valueOf(key).toCharArray();
        int hash=79;
  	
 	  
 	   for (int i = 0; i < k.length; i++)
 		  hash =(int) (k[k.length-1] * 365) %m;
 	   
 	    return hash;

    } 

    public int size() {
        return n;
    } 

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
           if(st[i].getCollision(key)){
        	   count+=n;
               flag=false;
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
        for(int k=1000;k<=10000;k+=100){  
            
           INIT_CAPACITY=k; 
        for(int j=0;j<=100;j++)
        {
        BdayProblem<String, Integer> st = new BdayProblem<String, Integer>(INIT_CAPACITY);
  
        Random r=new Random(INIT_CAPACITY);
        int[] array=new int[k];
        for (int i = 0; i<array.length; i++) 
          {
           array[i] = r.nextInt(365); // TODO populate the array with real random data
          }

        for (int i = 0; i<array.length; i++) {
          //Scanner in = new Scanner(System.in);
            //String key = in.next();
            String key= String.valueOf(array[i]);
            if(flag)
            st.put(key, i,"put");
            else 
            {
                flag=true;
                break;
            }
          }
        }
           System.out.println("Average Count for k:"+k+" "+count/100);

    }
   }
}
