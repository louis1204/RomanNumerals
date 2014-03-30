import java.util.Scanner;


public class Main {
	public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String input;
        RomanNumeral rn;

        do{
        	System.out.print("Enter a Roman numeral or Arabic numeral: ");
        	input = keyboard.nextLine().toLowerCase().trim();
        	if(!input.isEmpty())
        	{
        		if(tryParse(input))
        		{
        			rn = new RomanNumeral(Integer.parseInt(input));
        			if(rn.toString() != null)
        				System.out.println(rn.toString());
        			else
        				System.out.println("Please enter an Arabic numeral 1-3999");
        		}
        		else
        		{
        			rn = new RomanNumeral(input);
        			if(rn.toInt() != -1)
        				System.out.println(rn.toInt());
        			else
        				System.out.println("Please enter a valid Roman numeral");
        		}
        	}
        }while(!input.isEmpty());
        System.out.println("Goodbye");
        keyboard.close();
    }

	private static boolean tryParse(String num)
	{
		try
		{
			Integer.parseInt(num);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
}
