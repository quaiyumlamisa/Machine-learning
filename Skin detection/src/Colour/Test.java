
package Colour;
/*



import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileWriter;



public class Test
{
 public static void main(String args[])throws IOException
 {
 
 String dirPath = "C:\\Games\\image";
 String dirPath1 = "C:\\Games\\image1";
 
 File dir1 = new File(dirPath);
 String[] files = dir1.list();
 
 File dir2=new File(dirPath1);
 String[] files1 = dir2.list();
 
 

 
 
 
 if (files.length == 0) {
     System.out.println("The directory is empty");
     
 
     if (files1.length == 0) {
     System.out.println("The directory is empty");    
     
 } else {
     for ()
     {
        // System.out.println(aFile);
     
   
     }
 }
 
   //height of the image
   BufferedImage image = null;
   BufferedImage  image2= null;
   File f = null,f2=null;
 
 
   
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
   
   
   
   try{
     
   
   f = new File("C:\\Users\\rez1\\Downloads\\0000.jpg"); //image file path
   f2 = new File("C:\\Users\\rez1\\Downloads\\0000.bmp");
   
       //image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
       image = ImageIO.read(f);
       image2 = ImageIO.read(f2);
       
       System.out.println("Reading complete.");
   

       int width = image.getWidth();
int height = image.getHeight();

System.out.println("shamma");
System.out.println(height);    

   int count = 0;
       
        for(int i=0; i<height; i++) {
       
           for(int j=0; j<width; j++) {
           
           
              count++;
              Color c = new Color(image.getRGB(j, i));
              Color m = new Color(image2.getRGB(j, i));
             
              if(m.getRed()>250 && m.getGreen()>250 && m.getBlue()>250) {
             
              NS[m.getRed()][m.getGreen()][m.getBlue()]++;
             
              }
             
              else {
             
              S[m.getRed()][m.getGreen()][m.getBlue()]++;
              }
             
              //System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
           }
        }

     }
   catch (Exception e)
   {}
   
   
   int SS=0,SNS=0;
   
   for(int i=0;i<256;i++) {
   
    for(int j=0;j<256;j++) {
   
    for(int k=0;k<256;k++) {
   
    SS+=S[i][j][k];
    SNS+=NS[i][j][k];
    }
    }
   }
   
   FileWriter fileWriter = new FileWriter("F:\\Skin detection\\data.txt"); 
   
   
   for(int i=0;i<256;i++) {
   
    for(int j=0;j<256;j++) {
   
    for(int k=0;k<256;k++) {
   
    S[i][j][k]/=SS;
    NS[i][j][k]/=SNS;
   
    try{  
    if(NS[i][j][k]==0 && S[i][j][k]!=0)
    out.write((int) (S[i][j][k]=100));
   
    else if(NS[i][j][k]==0 && S[i][j][k]==0)
    out.write((int) (S[i][j][k]=0));
   
    else  out.write((int) (S[i][j][k]/=NS[i][j][k]));
    out.close();    
    }
    catch(Exception e){System.out.println(e);
    }
    
    fileWriter.flush(); fileWriter.close();    
   
    }
    }
   }
   
   
   
           
           
         
       
 
/*
   
   try{
   f = new File("C:\\\\Users\\\\rez1\\\\Downloads\\\\00000.jpg");  //output file path
   ImageIO.write(image, "jpg", f);
   System.out.println("Writing complete.");
   
        }
 catch(IOException e){
     System.out.println("Error: "+e);
   }
  
 }
 }
}
*/



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;

public class Test {
    double finalArray[][][] = new double[256][256][256] ;
    int count=500 ;
    DecimalFormat df = new DecimalFormat("#.##") ;
    
    public Test() throws IOException{
        
        training() ;
        
        testing();
        
        accuracy();
        
    }
    
    public void training() throws IOException{
    
        File folder1 = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\training\\mainImage");
        File folder2 = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\training\\maskImage");
        
        File [] file1 = folder1.listFiles();
        File [] file2 = folder2.listFiles();
        
        double skinArray[][][] = new double[256][256][256] ;
        double nonSkinArray[][][] = new double[256][256][256] ;
       
        int totalOfSkin=0 , totalOfNonSkin=0 ;
        
        for(int f=0 ; f < file1.length ; f++ ){
            BufferedImage img = ImageIO.read(file1[f]) ;
            BufferedImage mask = ImageIO.read(file2[f]) ;
            
            for(int i=0 ; i<img.getHeight() ; i++){
                for(int j=0 ; j<img.getWidth() ; j++){
                    int iR=0,iG=0,iB=0,mR=0,mG=0,mB=0 ;
                    
                    int imgRGB = img.getRGB(j,i) ;
                    iB = imgRGB & 0xff ;
                    iG = (imgRGB & 0xff00) >> 8 ;
                    iR = (imgRGB & 0xff0000) >> 16 ;
                  
                    int maskRGB = mask.getRGB(j,i) ;
                    mB = maskRGB & 0xff ;
                    mG = (maskRGB & 0xff00) >> 8 ;
                    mR = (maskRGB & 0xff0000) >> 16 ;
                    
                    if(mB>200 && mG>200 && mR>200){
                        nonSkinArray[iR][iG][iB]++ ;
                        totalOfNonSkin++ ;
                    }
                    else{
                        //System.out.println(mask.getRGB(j, i));
                        skinArray[iR][iG][iB]++ ;
                        totalOfSkin++ ;
                    }
                    
                }
            }
        }
        
        
        for(int i=0 ; i<256 ; i++){
            for(int j=0 ; j<256 ; j++){
                for(int k=0 ; k<256 ; k++){
                    skinArray[i][j][k] = skinArray[i][j][k]/totalOfSkin ;
                    nonSkinArray[i][j][k] = nonSkinArray[i][j][k]/totalOfNonSkin ;
                    
                    if(nonSkinArray[i][j][k]==0){
                        finalArray[i][j][k] = 0.5 ;
                        //System.out.println("helo0");
                    }
                    else 
                        finalArray[i][j][k] = skinArray[i][j][k]/nonSkinArray[i][j][k] ; 
                }
            }
        }
        
        
    }
    
    public void testing() throws IOException{
        
        File testFolder1 = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\Testing\\mainImage");
        File testFolder2 = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\testMask\\maskImage");
        
        File [] file1 = testFolder1.listFiles();
        File [] file2 = testFolder2.listFiles();
        
        
        
        for(int f=0 ; f < file1.length ; f++){
            
            BufferedImage image = ImageIO.read(file1[f]) ;
            
            for(int i=0 ; i<image.getHeight() ; i++){
                for(int j=0 ; j<image.getWidth() ; j++){
                    
                    int iR=0,iG=0,iB=0 ;

                    int imgRGB = image.getRGB(j,i) ;
                    iB = imgRGB & 0xff ;
                    iG = (imgRGB & 0xff00) >> 8 ;
                    iR = (imgRGB & 0xff0000) >> 16 ;

                    if(finalArray[iR][iG][iB]<0.5){
                        image.setRGB(j,i,0xFFFFFFFF);
                    }
                    else{
                        image.setRGB(j, i, image.getRGB(j, i));
                    }
                }
            }
            
            File newMask = new File("") ;
        
            if(count<10){
                newMask = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\testing\\testMask\\000" + count + ".jpg");
            }
            
            else if(count<100){
                newMask = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\testing\\testMask\\00" + count + ".jpg");
            }
            
            else if(count<1000){
                newMask = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\testing\\testMask\\0" + count + ".jpg");
            }
            
            
            
            
            ImageIO.write(image, "jpg", newMask) ;
            count++ ;
       
        }
    }

    public void accuracy() throws IOException{
        
    
        File folder1 = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\Testing\\maskImage");
        File folder2 = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\DBMS\\src\\Testing\\testMask");
        
        File [] file1 = folder1.listFiles();
        File [] file2 = folder2.listFiles();
        
        int yes[] = new int[55] ;
        int no[] = new int[55] ;
        double accuracy[] = new double[55] ;
        double finalAccuracy = 0 ;
        
        for(int i=0 ; i<55 ; i++){
            yes[i] = 1 ;
            no[i] = 0 ;
        }
        //System.out.println("matha");
        
        for(int f=0 ; f < file1.length ; f++ ){
            BufferedImage img = ImageIO.read(file1[f]) ;
            BufferedImage mask = ImageIO.read(file2[f]) ;
            //System.out.println("matha2");
            
            for(int i=0 ; i<img.getHeight() ; i++){
                for(int j=0 ; j<img.getWidth() ; j++){
                    int tR=0,tG=0,tB=0,mR=0,mG=0,mB=0 ;
                    
                    //System.out.println("matha6 " + j + " " + i );
                    
                    int testRGB = img.getRGB(j,i) ;
                    tB = testRGB & 0xff ;
                    tG = (testRGB & 0xff00) >> 8 ;
                    tR = (testRGB & 0xff0000) >> 16 ;
                    //System.out.println(file2[f].getName() + "matha7 " + j + "  " + i );
                    int maskRGB = mask.getRGB(j,i) ;
                    //System.out.println("matha11 " + file2[f].getName());
                    mB = maskRGB & 0xff ;
                    //System.out.println("matha9");
                    mG = (maskRGB & 0xff00) >> 8 ;
                    //System.out.println("matha8");
                    mR = (maskRGB & 0xff0000) >> 16 ;
                    
                    //System.out.println("matha3");
                    
                    if(mB>240 && mG>240 && mR>240 && tB>240 && tG>240 && tR>240){
                        yes[f]++ ;
                    }
                    
                    else if(mB<240 && mG<240 && mR<240 && tB<240 && tG<240 && tR<240){
                        yes[f]++ ;
                    }        
                    
                    else{
                        no[f]++ ;
                    }
                    
                    //System.out.println("matha4 " + f);
                }
            }
        
            accuracy[f] = yes[f]*1.0/(yes[f]+no[f]) ;
            //System.out.println("matha5 " + f);
        }   
    
        for(int i=0 ; i<55 ; i++){
            finalAccuracy = finalAccuracy + accuracy[i] ;
        }
        
        finalAccuracy = finalAccuracy*1.0 / 55 ;
        
        System.out.println("Average Accuracy: " + df.format(finalAccuracy*100) + "%");
        
    }
}


