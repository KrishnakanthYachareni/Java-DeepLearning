```java
package com.epam.algo;

/**
 * @author Krishnakanth_Yachareni
 *
 */
public class PairsOfArray {

    /**
     * @param arr
     *            An Integer array.
     * @param k
     *            sum value.
     * @return count number of pairs of an array whose sum is equal to given
     *         sum.
     */
    public int count(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k && arr[i] != arr[j]) {
                    //System.out.println(arr[i] + "," + arr[j]);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Main method to be called by JVM.
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        PairsOfArray pairsOfArray = new PairsOfArray();
        int totalCount = pairsOfArray.count(arr, 6);
        System.out.println(totalCount);
    }
}

```