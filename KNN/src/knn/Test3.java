package knn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Test3 
{
public static void main(String[]args) throws NumberFormatException, IOException
{
	File file= new File("D:\\iris.txt");
	int j=0;
	
	 
	Double []r=new Double[150];
	double a,b,c,d;
	int k;
	
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter k: ");
		k=sc.nextInt();
		
		
		System.out.println("Enter unknown point: ");
		a=sc.nextDouble();
		b=sc.nextDouble();
		c=sc.nextDouble();
		d=sc.nextDouble();
		
	}
	
	try (BufferedReader br = new BufferedReader(new FileReader(file)))
	{
		String st;
		DataBlock[] Db= new DataBlock[150];
		
		while((st=br.readLine())!= null)
		{
			
			String[] s=st.split(",");
		
		
			
			double foo1 =Double.parseDouble(s[0]);
			//System.out.println(foo1);
			double foo2 =Double.parseDouble(s[1]);
			double foo3 =Double.parseDouble(s[2]);
		    double foo4 =Double.parseDouble(s[3]);
			
			String foo5=s[4];                                                                                                                       		
			
			 Db[j]=new DataBlock(foo1,foo2,foo3,foo4,foo5);
			
			// System.out.println(j+1+" = "+Math.sqrt((foo1-x)*(foo1-x)+(foo2-y)*(foo2-y)));
			// System.out.println(foo1+" "+foo2+" "+foo3+" "+foo4+" "+foo5);
			 r[j]=Math.pow((Math.sqrt((a-foo1)*(a-foo1)+(b-foo2)*(b-foo2)+(c-foo3)*(c-foo3)+(d-foo4)*(d-foo4))),-1);
			// System.out.println(r[j]);
			
			
			j++;	
		}
		
		
		
		/*
		 for(int i=0;i<j;i++)
		    {
		    	System.out.println(r[i]);
		    }
		
	*/
		 double[] r1=new double[150];

		 for(int i=0;i<150;i++)
		    {
		    	r1[i]=r[i];
		    }
		 
		 
		 Arrays.sort(r1);
		 
		/*System.out.println("After sorting:");
		 for(int i=0;i<150;i++)
		    {
		    	System.out.println(r1[i]);
		    }
	 */
		 
		 int c1=0;
		 int c2=0;
		 int c3=0;
		 for(int i1=0;i1<k;i1++)
		 {
			 for(int j2=0;j2<150;j2++)
			 {
			    if(r1[i1]==r[j2])
			  {
			    	
				// System.out.println(j2+" "+i1+" "+r[j2]);
				// System.out.println(Db[j2].e);
				 
				 
				 if(Db[j2].e.equals("Iris-setosa"))
				 {
					 c1++;
				
					
				 }
				 
				 else if(Db[j2].e.equals("Iris-versicolor"))
				  {
					 c2++;
					
				
			       }
				 
				 else if(Db[j2].e.equals("Iris-virginica"))
				  {
					 c3++;
					
				
			       }
			
			 }
			    
			  
		 }
			 		
			}
	//	System.out.println(c1+" "+c2+" "+c3);
		
		if( c1 >= c2 && c1 >= c3)
	          System.out.println(" the sample is Iris-setosa");

	      else if (c2 >= c1 && c2 >= c3)
	          System.out.println("the sample is Iris-versicolor");

	      else
	          System.out.println("the sample is Iris-virginica");
		
}
}
}
