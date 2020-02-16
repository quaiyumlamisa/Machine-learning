package sKIN;



import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;

public class DETECTION 
{
	public static void main(String args[])throws IOException
	 {
	
	 File folder1 = new File("F:\\Skin detection\\ibtd\\original");
     File folder2 = new File("F:\\Skin detection\\ibtd\\Mask");

    File[] files1=folder1.listFiles();
    File[] files2=folder2.listFiles();

    
    
    double S[][][]=new double[256][256][256];
    double NS[][][]=new double[256][256][256];
    
    for(int i=0;i<256;i++) {
    
     for(int j=0;j<256;j++) {
    
     for(int k=0;k<256;k++) {
    
     S[i][j][k]=0;
     NS[i][j][k]=0;
     }
     }
    }
    
  
    BufferedImage orgImage=null;

    BufferedImage maskImage=null;

   

    for(int f=0 ; f < files1.length ; f++ ){
    	orgImage = ImageIO.read(files1[f]) ;
    	maskImage = ImageIO.read(files2[f]) ;
    	
     
        
        int height=orgImage.getHeight();
        int width=orgImage.getWidth();
        
      
        int count = 0;
        
        for(int i=0; i<height; i++) {
       
           for(int j=0; j<width; j++) {
           
           
              count++;
              Color c = new Color( orgImage.getRGB(j, i));
              Color m = new Color(maskImage.getRGB(j, i));
             
              if(m.getRed()==255 && m.getGreen()==255 && m.getBlue()==255) {
             
              NS[c.getRed()][c.getGreen()][c.getBlue()]++;
             
              }
             
              else {
             
              S[c.getRed()][c.getGreen()][c.getBlue()]++;
              }
             
             
              //System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
           }
        }
  
     }
  
   
   
   double SS=0,SNS=0;
   
   for(int i=0;i<256;i++) {
   
    for(int j=0;j<256;j++) {
   
    for(int k=0;k<256;k++) {
   
    SS+=S[i][j][k];
    SNS+=NS[i][j][k];
    }
    }
   }
   
   
 
   
   
   for(int i=0;i<256;i++) {
   
    for(int j=0;j<256;j++) {
   
    for(int k=0;k<256;k++) {
   
    S[i][j][k]/=SS;
    NS[i][j][k]/=SNS;
    
    
        if(NS[i][j][k]==0 && S[i][j][k]!=0)
            S[i][j][k]=100;
       
        else if(NS[i][j][k]==0 && S[i][j][k]==0)
            S[i][j][k]=1;
       
        else  S[i][j][k]/=NS[i][j][k];
        
       // System.out.println(S[i][j][k]);
       
    }
    }
   }
        
   
       
   
        
	
	    BufferedImage n=null;
	    n= ImageIO.read(new File("F:\\Skin detection\\0001.jpg"));
		File f = null;
		Color t;
		       
		for(int i = 0; i < n.getHeight(); i++)
		{
			for(int j = 0; j < n.getWidth(); j++)
			{
				t = new Color(n.getRGB(j, i));
				
                if(S[t.getRed()][t.getGreen()][t.getBlue()]>2) {
					
					
					n.setRGB(j, i, n.getRGB(j,i));
				}
	        
				else 
				{
					
			        n.setRGB(j, i, Color.WHITE.getRGB());
			        
				}
			}
			
		}
		
      try
      {
		    
			f = new File("F:\\Skin detection\\TE1.jpg");
		    ImageIO.write(n, "jpg", f);
		
	  }
      
      catch(IOException e)
      {
			
			System.out.println("Error: " + e);
	  }
			
	}
}
        

  

   


   
	
   
   


