//COEN 352 Assignment 2, Question 6
//Name: Rayan Alkayal
//Student ID: 40051210

//Program that takes X input and generates X unique time stamps in hh:mm:ss

import java.util.*;

public class Question6
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter desired # of time objects: ");
        int N = Integer.parseInt(scan.nextLine());
        Time[] timeObjects = new Time[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++)
        {
            int hour = rand.nextInt(12);
            int minute = rand.nextInt(59);
            int second = rand.nextInt(59);
            Time time = new Time(hour, minute, second);
            timeObjects[i] = time;
        }

        Arrays.sort(timeObjects);
        System.out.print("Times:");

        for(int i = 0; i < N; i++)
            System.out.printf("\n%02d:%02d:%02d", timeObjects[i].hour, timeObjects[i].minute, timeObjects[i].second);

        if(Time.isDistinct)
            System.out.println("Not all time objects are distinct");

        else
            System.out.println("\nAll time objects are distinct");
    }
}

class Time implements Comparable<Time>
{
    int hour, minute, second;

    public Time(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    static boolean isDistinct = false;

    public int compareTo(Time next)
    {
        if(this.hour == next.hour)
        {
            if(this.minute == next.minute)
            {
                if(this.second == next.second)
                {
                    isDistinct = true;
                    return 0;
                }
                else
                    return this.second - next.second;
            }
            else
                return this.minute-next.minute;
        }
        return this.hour-next.hour;
    }
}

