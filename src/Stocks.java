import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Stocks {

	public static void main(String[] args) {
		String fileName = "D:/abc/Stocks/doc/data.csv";
		//Table table = loadTable("data.csv", "header");
		//to read the file.
		File file = new File(fileName);	
		String[] stockId = new String[6];
 		String[] side = new String[6];
 		String[] company = new String[6];
 		String[] quantity = new String[6];
 		int[] quantity1 = new int[5];
		int i=0;
		try
		{
		Scanner scan = new Scanner(file);
		while(scan.hasNext())
		{				
			String data = scan.nextLine();//gets a whole line
	 		String[] values = data.split(",");
	 		String stockId1 = values[0];
	 		String side1 = values[1];
	 		String company1 = values[2];
	 		String quantity2 = values[3];
		 	System.out.println(stockId1+" "+side1+" "+company1+" "+quantity2);		 
	 		stockId[i]=stockId1;
	 		side[i]=side1;
	 		company[i]=company1;
	 		quantity[i]=quantity2;	 			
	 		i++;
		}
		System.out.println("-------------------------------------");
			int length = 5;
			quantity1[0] = 0;
	 		for(i=1;i<length-1;i++)
			{
				for(int j=i+1;j<length;j++)
				{
					if(side[i].equals("BUY") && side[j].equals("SELL"))
					{
						
						if(company[i].equals( company[j]))
						{
							
							//System.out.println(quantity[i]+" "+quantity[j]);
							int sum=0;
							for(int k=0;k<quantity[i].length();k++)
							{
								sum=sum*10;
								sum = sum+Character.getNumericValue(quantity[i].charAt(k));		
							}
							
							int sum1=0;
							for(int k=0;k<quantity[j].length();k++)
							{
								sum1=sum1*10;
								//System.out.println(Character.getNumericValue(quantity[j].charAt(k)));
								sum1 = sum1+Character.getNumericValue(quantity[j].charAt(k));
								
							}
							//System.out.println(sum1+" "+sum);							
							quantity1[j-1] = sum1-sum;
							
						}
						
						else if(company[i].equals(company[j]) && side[i].equals("BUY") && side[j].equals("BUY"))
						{
							//System.out.println(quantity[i]+" "+quantity[j]);
							int sum2=0;
							for(int k=0;k<quantity[i].length();k++)
							{
							//System.out.println(quantity[i].length());	
								sum2=sum2*10;
								sum2 = sum2+Character.getNumericValue(quantity[i].charAt(k));		
							}
							
							int sum3=0;
							for(int k=0;k<quantity[j].length();k++)
							{
								sum3=sum3*10;
						//	System.out.println(Character.getNumericValue(quantity[j].charAt(k)));
							
							sum3 = sum3+Character.getNumericValue(quantity[j].charAt(k));	
								
							}
							quantity1[j-1]=sum2+sum3;				
							//System.out.println("BUY of xyz:"+quantity1[j-1]);						
						}
												
						else
						{
							//System.out.println(quantity1[i]);
							quantity1[i] = 0;							
						}
					}
					
			}
				  
		}
		for(i=0;i<length;i++)
		{
			System.out.println(quantity1[i]);
			if(quantity1[i]==0)
			System.out.println("CLOSED");
			else
			System.out.println("OPENED");
			System.out.println("-------------------------------------------");
		}
		}	 
		catch(FileNotFoundException e)
		{
			System.out.println("This is not a file");
			e.printStackTrace();
		}	
	}
	}


