
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Cluster 
{
	
	private static final double EPSILON =  (double) 0.0000001d;
	private static Scanner sc;
	

	public static double dist(int x,int y,int x1,int y1,int x2,int y2)
	  {
		       double distance=Math.pow((x-y),2)+Math.pow((x1-y1),2)+Math.pow((x1-y1),2);
			   distance = Math.sqrt(distance); 
				  
		return distance; 
		  
		  
	  }
	
	
	  	
	
  public static void main (String[]args) throws IOException
  {
	  
	  BufferedImage image = null;
      File f = null;
     
     
      
       sc = new Scanner(System.in);
	   int k;
		
		k=sc.nextInt();
		  
		int k1[]=new int[k];
		 
		      f = new File("D:\\1.jpg");
		      image = ImageIO.read(f);
		      
		      int w=image.getWidth();
		      int h=image.getHeight();
		  
		   double arr[]=new double[k];
		
		   int r[]=new int[k];
		   int g[]=new int[k];
		   int b[]=new int[k];
		   
		   
		   int r1[]=new int[k];
		   int g1[]=new int[k];
		   int b1[]=new int[k];
		   
		   
		  
			
			int y[]=new int[k];
			int x[]=new int[k];
			
			 for(int i=0;i<k;i++)
			  {
				    Random rand=new Random();
					
				    y[i]=rand.nextInt(w-0);
				    x[i]=rand.nextInt(h-0);
				    
				    int pixel = image.getRGB(y[i], x[i]);
				    
				    int red = (pixel >> 16) & 0xff;
		            int green = (pixel >> 8) & 0xff;
		            int blue = (pixel) & 0xff;
		            
		            r[i]=red;
		            g[i]=green;
		            b[i]=blue;
		       
					System.out.println("i:"+i+"\tr:"+r[i]+"\tg:"+g[i] +"\tb:"+b[i]); 
				  
			  }
		
		   
		   
		   
		  while(true)
		  {
		   
			  for(int i=0;i<k;i++)
			  {
				  k1[i]=0;
				  
			  }
		   for (int i = 0; i < h; i++)
		   {
		       for (int j = 0; j < w; j++)
		       {
		     	
		     	 
		     	  
		     	  for(int a=0;a<3;a++)
		     	  {
		     		  arr[a]=0;
		     		  
		     	  }
		     	  
		     	
		           int pixel = image.getRGB(j, i);
		     	  
		     	   int red = (pixel >> 16) & 0xff;
		           int green = (pixel >> 8) & 0xff;
		           int blue = (pixel) & 0xff;
		       
		          
		           
		         
		           for(int l=0;l<3;l++)
		           {
		         	  
		           
		               arr[l]=dist(red,r[l],green,g[l],blue,b[l]);
		           
		           
		           }
		           
		
		           
		           int min=(int) arr[0];
		           int index=0;
		           
		           
		           for(int c=0;c< k;c++)
		           {
		           if(min>arr[c])
		           {
		         	  min=(int) arr[c];
		         	  index=c;
		         	  
		           }
		         	
		           
		         
		           }
		           
		       
		          
		           
		        	   r1[index]+=red;
		        	   g1[index]+=green;
		        	   b1[index]+=blue; 
		        	   
		        	   k1[index]++;
		        	   
		           
		           
		           
		       }
		   }
		  
		   
		  for(int i=0;i<k;i++)
		  {
		   if(k1[i]!=0)
		   {
		   r1[i]=r1[i]/k1[i];
		   g1[i]=g1[i]/k1[i];
		   b1[i]=b1[i]/k1[i];
		   }
		   
		   else
		   {
			 r1[i]=0;
			 g1[i]=0;
			 b1[i]=0;
			   
		   }
		  }
		  
		  
		   
		    int c=0;
		    for(int i1=0;i1<k;i1++)
		    {
		    	if(dist(r1[i1],r[i1],g1[i1],g[i1],b1[i1],b[i1])<EPSILON)
		    	{
		    	   c++;	
		    	}
		    
		    
		      r[i1]=r1[i1];
			  g[i1]=g1[i1];
			  b[i1]=b1[i1];
			  
		    }
		    if( c==k )
		    {
		    	
		    	break;
		    }
		    
		     
			  
		  }
		  
		  System.out.println("final r");
		   for(int i=0;i<k;i++)
		   {
			   
			   System.out.println(r[i]+" , "+g[i]+" ' "+b[i]);
		   }
		  
		  
		   for (int i = 0; i < h; i++)
		   {
		       for (int j = 0; j < w; j++)
		       {
		    	  
		    	   Color rgb = new Color(image.getRGB(j, i));
		      	  
		            
		            int red = rgb.getRed();
		            int green = rgb.getGreen();
		            int blue = rgb.getBlue();
		            
		            
		          
		            for(int l=0;l<k;l++)
		            {
		          	   arr[l]=dist(red,r[l],green,g[l],blue,b[l]);
		            }
		         
		            int min=(int) arr[0];
		          
		            
					 int index1=0;
		            for(int c=0;c< k;c++)
		            {
		            if(min>arr[c])
		            {
		          	  min=(int) arr[c];
		          	  index1=c;
		          	 
		          	  
		            }
		          	
		            }
		            
		           
		             
		            
		              
		            	image.setRGB(j,i,(new Color(r[index1],g[index1],b[index1])).getRGB());
		          
		            
		             
		       }
		   }
	
      try
       { 
           f = new File("D:\\1.jpg"); 
           ImageIO.write(image, "jpg", f); 
       } 
       catch(IOException e) 
       { 
           System.out.println(e); 
       } 
	   
	   
	  
	   
	   
	  
  }
}


/*
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


import javax.imageio.ImageIO;

public class Cluster 
{
	
	private static final double EPSILON =  (double) 0.0000001d;
	

	public static double dist(int x,int y,int x1,int y1,int x2,int y2)
	  {
		       double distance=Math.pow((x-y),2)+Math.pow((x1-y1),2)+Math.pow((x1-y1),2);
			   distance = Math.sqrt(distance); 
				  
		return distance; 
		  
		  
	  }
	
	
	  	
	
  public static void main (String[]args) throws IOException
  {
	  
	  BufferedImage image = null;
      File f = null;
      int k1;
      int k2;
      int k3;
      
     
		int k=3;
		  
		  
		 
		      f = new File("D:\\2.jpg");
		      image = ImageIO.read(f);
		      
		      int w=image.getWidth();
		      int h=image.getHeight();
		  
		   double arr[]=new double[3];
		
		   int r[]=new int[3];
		   int g[]=new int[3];
		   int b[]=new int[3];
		   
		   
		   int r1[]=new int[3];
		   int g1[]=new int[3];
		   int b1[]=new int[3];
		   
		   
		  
			
			int y[]=new int[k];
			int x[]=new int[k];
			
			 for(int i=0;i<k;i++)
			  {
				    Random rand=new Random();
					
				    y[i]=rand.nextInt(w-0);
				    x[i]=rand.nextInt(h-0);
				    
				    int pixel = image.getRGB(y[i], x[i]);
				    
				    int red = (pixel >> 16) & 0xff;
		            int green = (pixel >> 8) & 0xff;
		            int blue = (pixel) & 0xff;
		            
		            r[i]=red;
		            g[i]=green;
		            b[i]=blue;
		       
					System.out.println("i:"+i+"\tr:"+r[i]+"\tg:"+g[i] +"\tb:"+b[i]); 
				  
			  }
		
		   
		   
		   
		  while(true)
		  {
		   k1=0;
		   k2=0;
		   k3=0;
		   for (int i = 0; i < h; i++)
		   {
		       for (int j = 0; j < w; j++)
		       {
		     	
		     	 
		     	  
		     	  for(int a=0;a<3;a++)
		     	  {
		     		  arr[a]=0;
		     		  
		     	  }
		     	  
		     	
		           int pixel = image.getRGB(j, i);
		     	  
		     	   int red = (pixel >> 16) & 0xff;
		           int green = (pixel >> 8) & 0xff;
		           int blue = (pixel) & 0xff;
		       
		          
		           
		         
		           for(int l=0;l<3;l++)
		           {
		         	  
		           
		               arr[l]=dist(red,r[l],green,g[l],blue,b[l]);
		           
		           
		           }
		           
		
		           
		           int min=(int) arr[0];
		           int index=0;
		           
		           
		           for(int c=0;c< 3;c++)
		           {
		           if(min>arr[c])
		           {
		         	  min=(int) arr[c];
		         	  index=c;
		         	  
		           }
		         	
		           
		         
		           }
		           
		       
		           
		           if(index==0)
		           {
		        	   r1[0]+=red;
		        	   g1[0]+=green;
		        	   b1[0]+=blue;
		        	   
		        	   k1++;
		           }
		           
		           if(index==1)
		           {
		        	   r1[1]+=red;
		        	   g1[1]+=green;
		        	   b1[1]+=blue;
		        	   
		        	   k2++;
		           }
		           if(index==2)
		           {
		        	   r1[2]+=red;
		        	   g1[2]+=green;
		        	   b1[2]+=blue;
		        	   
		        	   k3++;
		           }
		       }
		   }
		  
		   
		 
		   if(k1!=0)
		   {
		   r1[0]=r1[0]/k1;
		   g1[0]=g1[0]/k1;
		   b1[0]=b1[0]/k1;
		   }
		
		   if(k2!=0)
		   {
		   r1[1]=r1[1]/k2;
		   g1[1]=g1[1]/k2;
		   b1[1]=b1[1]/k2;
		   }
		  
		   if(k3!=0)
		   {
		   r1[2]=r1[2]/k3;
		   g1[2]=g1[2]/k3;
		   b1[2]=b1[2]/k3;
		   }
		  
		    double n1=dist(r1[0],r[0],g1[0],g[0],b1[0],b[0]);
		    double n2=dist(r1[1],r[1],g1[1],g[1],b1[1],b[1]);
		    double n3=dist(r1[2],r[2],g1[2],g[2],b1[2],b[2]);
		    
		    
		    if(n1<EPSILON && n2<EPSILON &&  n3<EPSILON  )
		    {
		    	
		    	break;
		    }
		    
		      r[0]=r1[0];
			  g[0]=g1[0];
			  b[0]=b1[0];
			  
			  
			  r[1]=r1[1];
			  g[1]=g1[1];
			  b[1]=b1[1];
			  
			  
			  r[2]=r1[2];
			  g[2]=g1[2];
			  b[2]=b1[2];
			  
		  }
		  
		  System.out.println("final r");
		   for(int i=0;i<3;i++)
		   {
			   
			   System.out.println(r[i]+" , "+g[i]+" ' "+b[i]);
		   }
		  
		  
		   for (int i = 0; i < h; i++)
		   {
		       for (int j = 0; j < w; j++)
		       {
		    	  
		    	   Color rgb = new Color(image.getRGB(j, i));
		      	  
		            
		            int red = rgb.getRed();
		            int green = rgb.getGreen();
		            int blue = rgb.getBlue();
		            
		            
		          
		            for(int l=0;l<3;l++)
		            {
		          	   arr[l]=dist(red,r[l],green,g[l],blue,b[l]);
		            }
		         
		            int min=(int) arr[0];
		          
		            
					 int index1=0;
		            for(int c=0;c< 3;c++)
		            {
		            if(min>arr[c])
		            {
		          	  min=(int) arr[c];
		          	  index1=c;
		          	 
		          	  
		            }
		          	
		            }
		            
		           
		
		            if(index1==0)
		            {
		              
		            	image.setRGB(j,i,(new Color(r[0],g[0],b[0])).getRGB());
		                
		            }
		            
		            else if(index1==1)
		            {
		            	
		            	image.setRGB(j,i,(new Color(r[1],g[1],b[1])).getRGB());
		            }
		            
		            else if(index1==2)
		            {
		            	image.setRGB(j,i,(new Color(r[2],g[2],b[2])).getRGB());
		            }
		            
		             
		       }
		   }
	
      try
       { 
           f = new File("D:\\2.jpg"); 
           ImageIO.write(image, "jpg", f); 
       } 
       catch(IOException e) 
       { 
           System.out.println(e); 
       } 
	   
	   
	  
	   
	   
	  
  }
}
*/