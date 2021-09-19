//COEN 352 Assignment 3, Question 3
//Name: Rayan Alkayal
//Student ID: 40051210

//Program that uses HashMaps to return a numerical score for a given letter grade

import java.util.*;

public class Question3
{
    public static void main(String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);

        HashMap<String, Double> grades = new HashMap<String, Double>();
        grades.put("A+", 4.33);
        grades.put("A", 4.00);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B", 3.00);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C", 2.00);
        grades.put("C-", 1.67);
        grades.put("D", 1.00);
        grades.put("F", 0.00);

        System.out.println("Enter Letter grade for numerical score: ");
        input = scan.next();
        while (!"0".equalsIgnoreCase(input))
        {
            if (grades.get(input) == null)
                System.out.println("Invalid Letter Grade, please try again: ");
            else
                System.out.println("Numerical Score: " + grades.get(input));

            System.out.println("Enter another letter grade, or 0 to exit the program: ");
            input = scan.next();
        }
    }
}
