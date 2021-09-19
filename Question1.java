//COEN 352 Assignment 2, Question 1
//Name: Rayan Alkayal
//Student ID: 40051210

import java.util.*;

public class Question1
{
    public static void main(String[] args)
    {
        System.out.print("Enter numbers to sort: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] arr = input.split(" ");
        int[] intArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            intArr[i] = Integer.parseInt(arr[i]);

        evenSort(intArr);
        System.out.println(Arrays.toString(intArr));
    }

    public static void evenSort(int[] arr)
    {
        if (arr.length == 1)
        {
            return;
        }
        int[] tempArr = new int[arr.length - 1];
        for (int i = 0; i < tempArr.length; i++)
            tempArr[i] = arr[i];

        if (arr[arr.length - 1] % 2 == 0)
        {
            arr[0] = arr[arr.length - 1];
            evenSort(tempArr);
            for (int i = 0; i < arr.length - 1; i++)
                arr[i + 1] = tempArr[i];
            return;
        }
        else{
            evenSort(tempArr);
            for (int i = 0; i < arr.length - 1; i++)
                arr[i] = tempArr[i];
            return;
        }
    }
}

