//COEN 352 Assignment 2, Question 4
//Name: Rayan Alkayal
//Student ID: 40051210

//Program that sorts an array of strings by alphabetical order

import java.util.*;

public class Question4
{
    public static void main(String[] args)
    {
        String arr[] = {"B", "A", "B", "A", "B", "A", "B", "A", "C", "A", "D", "A", "B", "R", "A"};
        System.out.println(Arrays.toString(arr));
        optimalSort(arr);
    }
    private static void show(Comparable[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void optimalSort(String[] array)
    {
        sortPartition(array, 0, array.length - 1);
    }

    private static void sortPartition(String[] arr, int min, int max)
    {
        if (max <= min)
            return;

        int li = min;
        int gi = max;
        String lowerElement = arr[min];
        int i = min;

        while (i <= gi)
        {
            int val = arr[i].compareTo(lowerElement);
            if (val < 0) {
                swap(arr, li++, i++);
                show(arr);
                System.out.println();
            }
            else if (val > 0) {
                swap(arr, i, gi--);
                show(arr);
                System.out.println();
            }
            else
                i++;
        }

        sortPartition(arr, min, li - 1);
        sortPartition(arr, gi + 1, max);
    }
    private static void swap(String[] arr, int x, int y)
    {
        String a = arr[x];
        arr[x] = arr[y];
        arr[y] = a;
    }
}
