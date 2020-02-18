import java.io.File;
import java.util.Random;

public class Main
{
	public static void main(String[]args)
	{
		 File folder1 = new File("D:\\ibtd\\Original");
		
		 File folder2 = new File("D:\\ibtd\\Mask");
		
		 File[] files1=folder1.listFiles();
		 File[] files2=folder2.listFiles();
		 
    	 Image[]img=new Image[555];
    	 
    	 for(int i=0;i<555;i++)
    	 {
    		 img[i]=new Image();
    		 
    	 }
    	 
    	 for(int i=0;i<555;i++)
    	 {
    		 
    		 img[i].ImageRead(files1[i],files2[i]);
    	 }
	 
    	 Random r = new Random(); 
    	 
    	 for(int i=0;i<555;i++)
    	 {
    		  int rand=r.nextInt(555);
    		  Image temp=img[rand];
    		  img[rand]=img[i];
    		  img[i]=temp;
    		  
    		 
    	 }
    	 
    	 for(int i=0;i<5;i++)
    	 {
    		System.out.println(img[i]. getOriginal()); 
    	 }
    	 
    	 for(int i=0;i<555;i++)
    	 {
    		files1[i]=img[i]. getOriginal(); 
    	 }

    	 for(int i=0;i<5;i++)
    	 {
    		System.out.println(files1[i]); 
    	 }
    	 
	    
		 
	}

}
