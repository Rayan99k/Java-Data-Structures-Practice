//COEN 352 Assignment 3, Question 1
//Name: Rayan Alkayal
//Student ID: 40051210

import java.util.*;

public class Question1
{
    private int size;
    private PriorityQueue minPriorityQueue = new PriorityQueue();
    private PriorityQueue maxPriorityQueue = new PriorityQueue();

    public Question1(int i)
    {
        this.size = 0;
        minPriorityQueue = new PriorityQueue(i);
        maxPriorityQueue = new PriorityQueue(i, Collections.reverseOrder());
    }

    public int getSize()
    {
        return size;
    }

    public void insert(Object i)
    {
        minPriorityQueue.add(i);
        maxPriorityQueue.add(i);
        size++;
    }

    @Override
    public String toString()
    {
        return "Question1{" + "minPriorityQueue=" + minPriorityQueue +
                "}, maxPriorityQueue=" + maxPriorityQueue + '}';
    }

    public Object findMax()
    {
        return maxPriorityQueue.peek();
    }

    public Object findMin()
    {
        return minPriorityQueue.peek();
    }

    public Object removeMax()
    {
        Object item = maxPriorityQueue.poll();
        minPriorityQueue.remove(item);
        size--;
        return item;
    }

    public Object removeMin()
    {
        Object item = minPriorityQueue.poll();
        maxPriorityQueue.remove(item);
        size--;
        return item;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of heap: ");
        int size = scan.nextInt();

        Question1 heap = new Question1(size);

        Random rand = new Random();

        for (int i = 0; i < size; i++)
        {
            heap.insert((int)rand.nextInt()/100000000);
        }

        System.out.println("Count of items in heap: " + heap.getSize());
        System.out.println("Heap: " + heap.toString());
        System.out.println("Max item in heap: " + heap.findMax());
        System.out.println("Min item in heap: " + heap.findMin());
        System.out.println("Calling removeMax(): " + heap.removeMax());
        System.out.println("Heap after removeMax(): " + heap.toString());
        System.out.println("Calling removeMin(): " + heap.removeMin());
        System.out.println("Heap after removeMin(): " + heap.toString());
    }
}
