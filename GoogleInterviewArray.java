/**
 * 
 */
package com.epam.algo;

/**
 * @author Krishnakanth_Yachareni
 *
 */
public class GoogleInterviewArray {

    public static final int[] add(int[] arr) {
        int carry = 1;
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (carry == 0)
                break;
            int val = arr[i] + carry;
            result[i] = val % 10;
            carry = val / 10;
        }
        if (carry == 1) {
            result = new int[arr.length + 1];
            result[0] = 1;
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = { 9, 9, 9 };
        // add(a, 2, 0);
        for (int i : add(a)) {
            System.out.print(i);
        }
    }

}
