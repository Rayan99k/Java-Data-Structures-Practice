//COEN 352 Assignment 2, Question 3
//Name: Rayan Alkayal
//Student ID: 40051210

import java.util.*;

public class Question3
{
    public static class merge
    {
        private static Comparable[] temp;
        private static int[] perm;
        private static int[] temp2;

        public static int[] indirectSort(Comparable[] arr)
        {
            temp = new Comparable [arr.length];
            perm = new int[arr.length];
            temp2 = new int[arr.length];

            for (int i = 0; i < arr.length; i++)
                perm[i] = i;

            indirectSort(arr, 0, arr.length - 1);
            return perm;
        }

        public static void indirectSort(Comparable[] arr, int min, int max)
        {
            if (max <= min)
            {
                return;
            }
            int mid = min + (max-min)/2;

            indirectSort(arr, min, mid);
            indirectSort(arr, mid + 1, max);
            Merge(arr, min, mid, max);
        }

        public static void Merge(Comparable[] a, int min, int mid, int max)
        {
            int i = min, j = mid + 1;
            for (int k = min; k <= max; k++)
            {
                temp[k] = a[perm[k]];
                temp2[k] = perm[k];
            }
            for (int k = min; k <= max; k++)
            {
                if (i > mid)
                {
                    perm[k] = temp2[j++];
                }
                else if (j > max)
                {
                    perm[k] = temp2[i++];
                }
                else if (temp[j].compareTo(temp[i]) < 0)
                {
                    perm[k] = temp2[j++];
                }
                else
                    perm[k] = temp2[i++];
            }
        }
    }

    public static void main(String[] args)
    {
        int N = 10;
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++)
        {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(merge.indirectSort(arr)));
        System.out.println(Arrays.toString(arr) + "\n");
        for (int i = 0; i < N; i++)
        {
            arr[i] = N - 1 - i;
        }
        System.out.println(Arrays.toString(merge.indirectSort(arr)));
        System.out.println(Arrays.toString(arr) + "\n");
        Random r = new Random();
        for (int i = 0; i < N; i++)
        {
            arr[i] = r.nextInt(N);
        }
        System.out.println(Arrays.toString(merge.indirectSort(arr)));
        System.out.println(Arrays.toString(arr));
    }
}
