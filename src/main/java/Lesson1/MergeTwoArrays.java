package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MergeTwoArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int array1Len = Integer.parseInt(br.readLine());
        String arr = br.readLine();

        int array2Len = Integer.parseInt(br.readLine());
        String arr2 = br.readLine();

        if (array1Len == 0 && array2Len == 0) {
            System.out.println("");
            return;
        }

        mergeSort(arr, array1Len, arr2, array2Len);
    }

    private static void mergeSort(String array1, int leftLen, String array2, int rightLen) {
        Scanner left = new Scanner(array1);
        Scanner right = new Scanner(array2);
        StringBuilder builder = new StringBuilder();

        Long leftVal = null;
        if (leftLen > 0) {
            leftVal = left.nextLong();
        }

        Long rightVal = null;
        if (rightLen > 0) {
            rightVal = right.nextLong();
        }

        int leftPos = 0;
        int rightPos = 0;

        if (leftVal != null & rightVal != null) {
            while (leftPos < leftLen && rightPos < rightLen) {
                if (leftVal <= rightVal) {
                    builder.append(leftVal).append(" ");
                    leftPos++;
                    if (left.hasNextLong()) {
                        leftVal = left.nextLong();
                    }

                } else {
                    builder.append(rightVal).append(" ");
                    rightPos++;
                    if (right.hasNextLong()) {
                        rightVal = right.nextLong();
                    }

                }

            }
        }

        if (leftVal != null) {
            while (leftPos < leftLen) {
                builder.append(leftVal).append(" ");
                leftPos++;
                if (left.hasNextLong()) {
                    leftVal = left.nextLong();
                }
            }
        }

        if (rightVal != null) {
            while (rightPos < rightLen) {
                builder.append(rightVal).append(" ");
                rightPos++;
                if (right.hasNextLong()) {
                    rightVal = right.nextLong();
                }
            }
        }

        System.out.println(builder.toString());
    }

}