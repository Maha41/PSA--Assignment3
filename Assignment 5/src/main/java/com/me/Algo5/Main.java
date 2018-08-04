package com.me.Algo5;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        if (args.length>0) ParSort.cutoff = Integer.parseInt(args[0]);
//        Random random = new Random(0L);
//        int[] array = new int[2000];
//        for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000);
//        ParSort.sort(array, 0, array.length);
//        //for (int i : array) System.out.println(i);
//        if (array[0]==11) System.out.println("Success!");
    	
    	for(int l=0;l<10;l++){
            System.out.println("Enter cut off value");
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            Random random = new Random(0L);
            int[] array = new int[64000];
            for (int i = 0; i < array.length; i++) array[i] = random.nextInt(64000);
            long t1=System.nanoTime();
            ParSort.sort(array, 0, array.length-1,n);
    //    
            System.out.println( "Thread count: "+java.lang.Thread.activeCount());
            long t2=System.nanoTime();
            long totalTime=t2-t1;
            System.out.println("Total time taken in ms:"+totalTime/1000000);
            //System.out.println(array[0]);
            //for (int i : array) System.out.println(i);
            if (array[0]==11) System.out.println("Success!");
            }
    }
}

