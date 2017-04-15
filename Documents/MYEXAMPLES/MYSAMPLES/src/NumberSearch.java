import java.util.*;
public class NumberSearch {
	
	public static void main(String [] args)
	{
	final int size=100000;
	long startTime, endTime;
	Random r = new Random();
	Integer []numbers = new Integer[size];
	for (int k=0; k < size; ++k) // Generate random numbers
	numbers[k] = new Integer(r.nextInt());
	startTime = System.currentTimeMillis();
	for (int k=0; k < size; ++k)
	if (numbers[k] == r.nextInt()) // Search for a number
	System.out.println("Found a match");
	endTime = System.currentTimeMillis();
	System.out.println("Integer[] used: " + (endTime - startTime) + " ms");
	
	Collection<Integer> listOfIntegers = new ArrayList<Integer>(size);
	for(int k=0; k < size; ++k){
	listOfIntegers.add(r.nextInt());
	}
	
	startTime = System.currentTimeMillis();
	for(Integer arrayList:listOfIntegers)
		if(arrayList.equals(r.nextInt()))
	System.out.println("Found a match using ArrayList");
	endTime = System.currentTimeMillis();
	System.out.println("Integer[] used: " + (endTime - startTime) + " ms");     
	Collection<Integer> linkedListOfIntegers = new LinkedList<Integer>();
	
	startTime = System.currentTimeMillis();
	for(int k=0; k < size; ++k){
	linkedListOfIntegers.add(r.nextInt());
	}
	for(Integer linkedList:linkedListOfIntegers )
		if(linkedList.equals(r.nextInt()))
    System.out.println("Found a match using LinkedList");
	endTime = System.currentTimeMillis();
	System.out.println("Integer[] used: " + (endTime - startTime) + " ms"); 	
	
	} // main
	} // Midterm

