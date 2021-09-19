//COEN 352 Assignment 2, Question 2
//Name: Rayan Alkayal
//Student ID: 40051210

//Program that demonstrates selection sort

import java.util.*;

public class Question2
{
    public static void main(String[] args) {
        int N = 12;
        int M = 4;
        int numOfBlocks = N / M;

        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++)
            arr[i] = (int) (Math.random()*10);

        System.out.println("Size N: " + N);
        System.out.println("Size M: " + M);
        System.out.println("Number of Blocks N/M: " + numOfBlocks);
        System.out.println("Original Array: " + Arrays.toString(arr));

        int key = 0;
        int block = 1;
        while (key < N) {
            System.out.print("\nSelection sort at Block #" + block);
            sort(arr, key, key + M);
            printArray(arr, M);
            key = key + M;
            block = block + 1;
        }

        key = 0;
        block = 1;
        while (key < numOfBlocks - 1 && !sorted(arr)) {
            System.out.print("\nMerging Blocks ");
            for (int i = 0; i < block + 1; i++) {
                if (i == 0)
                    System.out.print("<");
                if (i < block)
                    System.out.print((i + 1) + " and ");
                else if (i == block)
                {
                    if (key == 0)
                        System.out.print((i + 1) + "> ");
                    else if (i == block)
                        System.out.print((i + 1) + ">");
                }
                if (i == block)
                    System.out.println();
            }

                merge(arr, 0, (key + 1) * M, ((key + 2) * M));
                printArray(arr, M);
                key = key + 1;
                block = block + 1;
        }
        System.out.println("\nArray after sorting: " + Arrays.toString(arr));
    }

    private static void sort(Comparable[] arr, int min, int max)
    {
        for (int i = min; i < max; i++) {
            int lowest = i;
            for (int j = i + 1; j < max; j++) {
                if (less(arr[j], arr[lowest]))
                    lowest = j;
            }
            swap(arr, i, lowest);
        }
    }

    private static void merge(Comparable[] arr, int min, int mid, int max)
    {
        int i = min;
        int j = mid;
        Comparable[] temp = new Comparable[arr.length];

        for (int k = min; k < max; k++)
            temp[k] = arr[k];

        for (int k = min; k < max; k++)
        {
            if (i >= mid)
                arr[k] = temp[j++];
            else if (j >= max)
                arr[k] = temp[i++];
            else if (less(temp[i], temp[j]))
                arr[k] = temp[i++];
            else
                arr[k] = temp[j++];
        }
    }

    public static void printArray(Comparable[] arr, int M)
    {
        int block = 1;
        for (int i = 0; i < arr.length; i++)
        {
            if (i % M == 0)
            {
                System.out.print("\nBlock #" + block + ": ");
                block++;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void swap(Comparable[] arr, int x, int y)
    {
        Comparable a = arr[x];
        arr[x] = arr[y];
        arr[y] = a;
    }

    private static boolean less(Comparable x, Comparable y)
    {
        return x.compareTo(y) < 0;
    }

    public static boolean sorted(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (less(arr[i], arr[i - 1]))
                return false;
            return true;
    }
}
