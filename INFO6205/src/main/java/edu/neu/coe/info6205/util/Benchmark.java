/*
 * Copyright (c) 2018. Phasmid Software
 */

package edu.neu.coe.info6205.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import edu.neu.coe.info6205.sort.simple.InsertionSort;
import edu.neu.coe.info6205.sort.simple.SelectionSort;
import edu.neu.coe.info6205.sort.simple.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Benchmark<T> {

    public Benchmark(Function<T, Void> f) {
        this.f = f;
    }
    
    static Integer[] temp = new Integer[1000];
    
    public double run(T t, int m) {
        double avg =0.0;
        for(int i=0;i<m;i++) {
        	long StartTime = System.nanoTime();
        	f.apply(t);
        	long EndTime = System.nanoTime();
        	avg = avg + (EndTime - StartTime);
        }
        
        return avg/m;
    }

    private final Function<T, Void> f;

    public static void main(String[] args) {
    	  String csvFile = "Ordered_Array.csv";
        FileWriter writer;
		try {
			writer = new FileWriter(csvFile);  
        int m = 10000; // This is the number of repetitions: sufficient to give a good mean value of timing
       
        //for (int i = 0; i < 1000; i++) array[i] = i; // TODO populate the array with real random data
        int n = 10;
        // TODO You need to apply doubling to n
        
        for(int i=0;i<10;i++) {
        	 Integer[] array = new Integer[n];
        
        	 ascendingArray(array);
        	Integer[]	insert_array = array.clone();
        	 Integer[]	select_array = array.clone();
        double sort1 = benchmarkSort(select_array, n, "SelectionSort", new SelectionSort<>(), m);
         writeLine(writer, Arrays.asList("SelectionSort", String.valueOf(n), String.valueOf(sort1), String.valueOf(n*n), String.valueOf(sort1/(n*n))));
    	    
        double sort2 = benchmarkSort(insert_array, n, "InsertionSort", new InsertionSort<>(), m);
         writeLine(writer, Arrays.asList("InsertionSort", String.valueOf(n), String.valueOf(sort2), String.valueOf(n), String.valueOf(sort2/n)));
       
       
             n = n*2;
        }
      
		   
		     	


		        writer.flush();
		        writer.close();
		    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		         
    }

    private static double benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
        Function<Integer, Void> sortFunction = (x) -> {
            sorter.sort(xs, 0, x);
            return null;
        };
        Benchmark<Integer> bm = new Benchmark<>(sortFunction);
      
	
        double x = bm.run(n, m);
        System.out.println(name + ": " + x + " nanosecs for n=" + n);
      
       return x;
   	 
        }
    
    public static void ascendingArray(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i; // TODO populate the array with real random data

		}
    }
    
    
    public static void randomArray(Integer[] array)
  {
         Random r=new Random();

         for (int i = 0; i< array.length; i++) 
        {
        array[i] = r.nextInt(); // TODO populate the array with real random data

        }

    }
    
    public static void partialArray(Integer[] array)
    {
           Random r=new Random();
         for (int i = 0; i< array.length/2; i++) 
        {
        array[i] = i; // TODO populate the array with real random data

        }
         for (int i = array.length/2; i< array.length; i++) 
        {
        array[i] = r.nextInt(); // TODO populate the array with real random data

        }

    }
    
    public static void reverseArray(Integer[] array) {
 		for (int i = 0, j = array.length; i < array.length && j>0 ; i++, j--) {
 			array[i] = j; // TODO populate the array with real random data
//System.out.println(array[i]);
 		}
     }
      
private static final char DEFAULT_SEPARATOR = ',';
    
    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

   
    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    } 
   
}
