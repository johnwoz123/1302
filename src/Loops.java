import java.util.Arrays;
import java.util.Scanner;


public class Loops 
{
	
	public Loops()
	{
		int number;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("please enter a number: ");
		scan.nextInt();
	}
	public static String tostr( int[][] A)
	{
		String s = " ";
		for(int row=0; row<A.length; row++)
		{
			s+=Arrays.toString(A[row]) + "\n";
		}
		System.out.println(s);
		return s;
	}
	
	
}
