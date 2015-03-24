package Dice;

public class Die
{	
	private int MAX = 6; // This is the absolute max that the face value can be!
	
	public int FaceValue;

	
	
	// Create a constructor with 
	
	public Die()
	{
		FaceValue = 1;
	}
	
	// constructor that rolls the die and returns the value
	
	public int roll()
	{
		FaceValue = (int) (Math.random() *MAX) + 1;
		
		return FaceValue;
		
	}
	// Face value acessor!
	
	public int GetFaceValue() 
	{
		return FaceValue;
	}
}
