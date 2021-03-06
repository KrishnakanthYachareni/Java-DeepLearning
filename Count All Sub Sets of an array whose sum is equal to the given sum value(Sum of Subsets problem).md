```java
package com.epam.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Krishnakanth_Yachareni
 *
 */
public class AllSubsetsEqualsToSum {

    /**
     * @param an
     *            Integer Array.
     * @param sum
     *            int value.
     * @return count the number of subsets of an array sum is equals to the
     *         given sum.
     */
    public static long count(int[] a, int sum) {
        long finalValue = 0;
        List<List<Integer>> list = getAllSubsets(a);
        for (List<Integer> subList : list) {
            if (sum(subList) == sum) {
                finalValue++;
            }
        }
        return finalValue;
    }

    /**
     * This function can calculate the sum of list values and then it will
     * return that value.
     * @param subList
     * @return Sum of subset.
     */
    private static int sum(List<Integer> subList) {
        int sum = 0;
        for (Integer value : subList) {
            sum += value;
        }
        return sum;
    }

    /**
     * @param a
     *            Integer Array.
     * @return List.It contains the all the subsets of an array.
     */
    private static List<List<Integer>> getAllSubsets(int[] a) {
        List<Integer> one = new ArrayList<>();
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        dfs(a, 0, one, all);
        return all;
    }

    /**
     * This is a recursive function to travel the split the array into sub
     * arrays the it can add to the List.
     * @param a
     *            Integer Array.
     * @param pos
     *            Index value of an array.
     * @param one
     *            List to holds the sub array.
     * @param all
     *            List of List. It can holds the List of all SubArrays.
     */
    private static void dfs(int[] a, int pos, List<Integer> one,
            List<List<Integer>> all) {
        if (a.length == pos) {
            all.add(new ArrayList<Integer>(one));
            return;
        }
        dfs(a, pos + 1, one, all);
        one.add(a[pos]);
        dfs(a, pos + 1, one, all);
        one.remove(one.size() - 1);
    }

    /**
     * Main method to be called by JVM.
     * @param args
     *            command line arguments as String array.
     */
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5 };
        long valueCount = count(A, 10);
        System.out.println(valueCount);
    }

}

```