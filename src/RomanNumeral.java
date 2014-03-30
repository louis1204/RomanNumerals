
public class RomanNumeral {

	private String stringNumeral;
	private int intNumeral;

	public RomanNumeral(String num)
	{
		try {
			checkRomanNumeral(num);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			stringNumeral = null;
			intNumeral = -1;
		}
	}

	public RomanNumeral(int num) {
		try {
			checkArabicNumeral(num);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			stringNumeral = null;
			intNumeral = -1;
		}
	}

	private void checkRomanNumeral(String num) throws NumberFormatException
	{
		int j = 0, temp = 0, states = 13, count = 0;
		num = num.toUpperCase();

		for(int i = 0; i < states; i++)
		{
			switch(i)
			{
				// 1000
				case 0:
					while(j < num.length() && num.substring(j, j+1).matches("M"))
					{
						temp += 1000;	// Add 1000 until no more m's
						j++;	// increase string position
					}
					continue;
				// 900
				case 1:
					if(j < num.length() - 1 && num.substring(j, j+2).matches("CM"))
					{
						temp += 900;
						j += 2;
						i = 4;	// makes the next state 5
						continue;
					}
					break;
				// 500
				case 2:
					if(j < num.length() && num.substring(j, j+1).matches("D"))
					{
						temp += 500;
						j++;
						i = 3;	// makes the next state 4
						continue;
					}
					break;
				// 400
				case 3:
					if(j < num.length() - 1 && num.substring(j, j+2).matches("CD"))
					{
						temp += 400;
						j += 2;
						i = 4;	// makes the next state 5
						continue;
					}
					break;
				// 100
				case 4:
					count = 0;
					while(j < num.length() && num.substring(j, j+1).matches("C"))
					{
						temp += 100;
						j++;
						count++;
					}
					if(count > 4)
					{
						throw new NumberFormatException("Not a valid roman numeral");
					}
					continue;
				// 90
				case 5:
					if(j < num.length() - 1 && num.substring(j, j+2).matches("XC"))
					{
						temp += 90;
						j += 2;
						i = 8;	// Makes next state 9
						continue;
					}
					break;
				// 50
				case 6:
					if(j < num.length() && num.substring(j, j+1).matches("L"))
					{
						temp += 50;
						j++;
						i = 7;	// Makes next state 8
						continue;
					}
					break;
				// 40
				case 7:
					if(j < num.length() - 1 && num.substring(j, j+2).matches("XL"))
					{
						temp += 40;
						j += 2;
						i = 8; // Makes next state 9
						continue;
					}
					break;
				// 10
				case 8:
					count = 0;

					while(j < num.length() && num.substring(j, j+1).matches("X"))
					{
						temp += 10;
						j++;
						count++;
					}
					if(count > 4)
					{
						throw new NumberFormatException("Not a valid roman numeral");
					}
					continue;
				// 9
				case 9:
					if(j < num.length() - 1 && num.substring(j, j+2).matches("IX"))
					{
						temp += 9;
						j += 2;
						i = 12;	// Theoretically we're done
						continue;
					}
					break;
				// 5
				case 10:
					if(j < num.length() && num.substring(j, j+1).matches("V"))
					{
						temp += 5;
						j++;
						i = 11; // Makes next state 12
						continue;
					}
					break;
				// 4
				case 11:
					if(j < num.length() - 1 && num.substring(j, j+2).matches("IV"))
					{
						temp += 4;
						j += 2;
						i = 12; // We're done
						continue;
					}
					break;
				// 1
				case 12:
					count = 0;
					while(j < num.length() && num.substring(j, j+1).matches("I"))
					{
						temp++;
						j++;
						count++;
					}
					if(count > 4)
					{
						throw new NumberFormatException("Not a valid roman numeral");
					}
			}
		}

		this.stringNumeral = num;
		this.intNumeral = temp;

		if(j != num.length())
		{
			throw new NumberFormatException("Not a valid roman numeral");
		}
	}

	private void checkArabicNumeral(int num) throws NumberFormatException
	{
		String temp = "";
		int tempNum = num;
		if(num < 1 || num > 3999)
		{
			throw new NumberFormatException("Arabic numeral is out of range");
		}

		while(num >= 1000)
		{
			num -= 1000;
			temp += "M";
		}

		if(num >= 900)
		{
			num -= 900;
			temp += "CM";
		}

		if(num >= 500)
		{
			num -= 500;
			temp += "D";
		}

		if(num >= 400)
		{
			num -= 400;
			temp += "CD";
		}

		while(num >= 100)
		{
			num -= 100;
			temp += "C";
		}

		if(num >= 90)
		{
			num -= 90;
			temp += "XC";
		}

		if(num >= 50)
		{
			num -= 50;
			temp += "L";
		}

		if(num >= 40)
		{
			num -= 40;
			temp += "XL";
		}

		while(num >= 10)
		{
			num -= 10;
			temp += "X";
		}

		if(num >= 9)
		{
			num -= 9;
			temp += "IX";
		}

		if(num >= 5)
		{
			num -= 5;
			temp += "V";
		}

		if(num >= 4)
		{
			num -= 4;
			temp += "IV";
		}

		while(num > 0)
		{
			num -= 1;
			temp += "I";
		}

		this.intNumeral = tempNum;
		this.stringNumeral = temp;
	}

	public String toString()
	{
		return this.stringNumeral;
	}

	public int toInt() {
		return this.intNumeral;
	}
}
