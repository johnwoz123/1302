import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;



public class SayMyNumber 
{
	
	public static String say ( long l )
	{
		String result = " ";
		
		if(l>= 1000000000000000000L)
			result = say( l/1000000000000000000L) + " Quintillion " + say(l%1000000000000000000L);
		else if(l>= 1000000000000000L)
			result = say (l/1000000000000000L) + " quadrillion " + say(l %1000000000000000L);
		else if(l >= 1000000000000L)
			result = say (l/1000000000000L) + " trillion " + say(l %1000000000000L);
		else if(l>= 1000000000)
			result = say (l/1000000000) + " billion " + say(l %1000000000);
		else if(l>= 1000000)
			result = say (l/1000000L) + " million " + say(l%1000000); 
		else if(l >= 1000)
			result = say ( l/1000) + " thousand " + say ( l%1000 );
		else if(l >= 100)
			result = say ( l/100 ) + " hundred " + say ( l % 100 );
		else if(l >= 20)
		{
			switch ( (int)(l/10) ) 
			{
			case 1: result = "one" + say (1%10); break;
			case 2: result = "twenty" + say ( 1%10 ); break;
			case 3: result = "thirty" + say (1%10); break;
			case 4: result = "fourty" + say (1%10); break;
			case 5: result = "fifty" + say (1%10); break;
			case 6: result = "sixty" + say (1%10); break;
			case 7: result = "seventy" + say (1%10); break;
			case 8: result = "eighty" + say (1%10); break;			
			case 9: result = "ninety" + say (l%10 ); break;
			}
		}
		else
		{
			switch( (int ) l)
			{
			case 1: result = "one"; break;
			case 2: result = "two"; break;
			case 3: result = "three";break;
			case 4: result = "four"; break;
			case 5: result = "five"; break;
			case 6: result = "six"; break;
			case 7: result = "seven"; break;
			case 8: result = "eight"; break;
			case 9: result = "nine"; break;
			case 10: result = "ten"; break;
			case 11: result = "eleven"; break;
			case 12: result = "twelve"; break;
			case 13: result = "thirteen"; break;
			case 14: result = "fourteen"; break;
			case 15: result = "fifteen"; break;
			case 16: result = "sixteen"; break;
			case 17: result = "seventeen"; break;
			case 18: result = "eighteen"; break;
			case 19: result = "nineteen"; break;
			}
		}
		
		
		
		return result;
	}
	
	
	public static void main (String[] args )
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a number between 1 and 9.2 Quadrillion !!");
		
		Long n = in.nextLong();
		
		String url = "http://tts-api.com/tts.mp3?q=100";
		
		
		if(Desktop.isDesktopSupported())
		{
			Desktop desktop = Desktop.getDesktop();
			
			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec ("xdg-open " + url + say(0));
			} catch (IOException e)
			{
				e.printStackTrace();
		}
	}
		
		System.out.println("You Entered: " + say ( n ) );
		
		
		
	}
	
	
}