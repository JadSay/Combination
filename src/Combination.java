/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jadsay2
 */
// Java program to print all combination of size r in an array of size n
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import java.util.*;

class Combination {

    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed 
    
    */
    static int combinationUtil(int arr[], int data[], int start,
            int end, int index, int r, boolean write, boolean print, BufferedWriter bw, int count) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            if (consecutive(data, 1)) {
                for (int j = 0; j < r; j++) {
                    if (write) {
                        try {

                            bw.write(data[j] + " ");

                        } catch (IOException e) {

                            e.printStackTrace();

                        }
                    }
                    if (print) {
                        System.out.print(data[j] + " ");

                    }
                }
                if (write) {
                    try {

                        bw.write("\n");

                    } catch (IOException e) {

                        e.printStackTrace();

                    }
                }
                if (print) {
                    System.out.println("");

                }
                count++;
                return count;
            }
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
//                        System.out.println(index);
//                                                System.out.println(i);

            data[index] = arr[i];
            count = combinationUtil(arr, data, i + 1, end, index + 1, r, write, print, bw, count);
        }

        return count;
//        System.out.println(count);
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r, boolean write, boolean print) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];
        BufferedWriter bw = null;
        if (write) {
            FileWriter fw = null;
            try {

                fw = new FileWriter("Permutation.txt");
                bw = new BufferedWriter(fw);

            } catch (IOException e) {

                e.printStackTrace();

            }
        }
        // Print all combination using temprary array 'data[]'
        int count = combinationUtil(arr, data, 0, n - 1, 0, r, write, print, bw, 0);
        if (write) {
            try {
                bw.close();

            } catch (Exception e) {

            }
        }
        System.out.println(count);

    }

    public static boolean consecutive(int arr[], int range) {
        //      Arrays.sort(arr);
        //List<Integer> list = Arrays.asList(range);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
               return false;
            } 
        }
//
        return true;
    }        
//    List<Integer> arrayList = new ArrayList<Integer>() {
//            {
//                for (int i : arr) {
//                    add(i);
//                }
//            }
//        };
//        ListIterator iterator = arrayList.listIterator();
//        //        ListIterator it = arrayList.listIterator();
//
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            Object nextIndex = iterator.nextIndex();
//            int size = arrayList.size();
//            if((Integer) nextIndex < size){
//                Object nextItem = arrayList.get((Integer) nextIndex);
//                if((Integer)next+1 != (Integer) nextItem) {
//                    return false;
//                }
//            }
//        }

    public static boolean hasConsecutive(int a[], int consecutiveNumbers) {
        if (consecutiveNumbers == 1 || consecutiveNumbers > a.length) {
            return false;
        }
        int cnt = 1;
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] + 1 == a[i + 1]) {
                cnt++;
                if (cnt == consecutiveNumbers) {
                    return true;
                }
            } else {
                cnt = 1;
            }
        }
        return false;
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        boolean print = false;
        boolean write = false;
        int[] numbers = new int[9];
        for (int i = 0; i <= numbers.length - 1; i++) {
            numbers[i] = i + 1;
        }
        int r = 6;
        int n = numbers.length;
        printCombination(numbers, n, r, write, print);
//        int[] arr = {2,3,4,5,6};
//        List<Integer> arrayList = new ArrayList<Integer>(){{ for (int i : arr) add(i); }};
//        Iterator<Integer> iterator = arrayList.iterator();
//        ListIterator it = arrayList.listIterator();
//        while(it.hasNext()){
//            Object next = it.next();
//            Object nextIndex = it.nextIndex();
//            int a = arrayList.size();
//            
////            Object nextItem = arrayList.get((Integer) nextIndex);
//            System.out.println(next+" "+nextIndex+" "+a);
//
//        }
//        if (consecutive(arr, 1)){
//            System.out.println("Consecutive");
//        } else {
//            System.out.println("Not Consecutive");
//
//        }
    }
}
