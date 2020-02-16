package Skin;

import java.io.File;

public class detection1
{
	/*
   public static void main(String[]args)
   {
	   File folder1 = new File("F:\\Skin detection\\ibtd\\original");
	   File folder2 = new File("F:\\Skin detection\\ibtd\\Mask");

	    File[] files1=folder1.listFiles();
	    File[] files2=folder2.listFiles();
	    
	    int a=files1.length;
	    System.out.println(a);
	    
	    int filesInFolds=a/5;
	    System.out.println(filesInFolds);
	    
	    
	   int f1= 0;
	   int f2=0;
	   int f3=0;
	   int f4=0;
	   int f5=0;
	    
	    File[] folder3 = new File[filesInFolds+1];
	    File[] folder4 = new File[filesInFolds+1];
	    File[] folder5 = new File[filesInFolds];
	    File[] folder6 = new File[filesInFolds];
	    File[] folder7 = new File[filesInFolds];
	    
	    int k=0;
	    for(int i=0;i<files1.length;i++)
	    {
	    	//while(f1<filesInFolds)
	    	//{
	    		
	    	folder3[f1] = files1[i];
	    	//f1++;
	    	if(f1<=filesInFolds-1)
	    		break;
	    	else
	    		f1++;
	    
	    	}

	    	
	   // }
	    System.out.println(f1);
	    
	    
	    for(int i=f1;i<files1.length;i++)
	    {
	    	while(f2<filesInFolds-1)
	    	{
	    		
	    	folder4[f2] = files1[i];
	    	f2++;
	    
	    	}
    	
    }
    //System.out.println(f1+f2);
	    f2+=f1;
	    //System.out.println(f2);
	   
	    for(int i=f2;i<files1.length;i++)
	    {
	    	while(f3<filesInFolds-1)
	    	{
	    		
	    	folder5[f3] = files1[i];
	    	f3++;
	    
	    	}
	    }
	   // System.out.println(f2+f3);
	    f3+=f2;
	   
	    for(int i=f3;i<files1.length;i++)
	    {
	    	while(f4<filesInFolds-1)
	    	{
	    		
	    	folder6[f4] = files1[i];
	    	f4++;
	    
	    	}
	    	
	    }
	    
	    f4+=f3;
	    for(int i=f4;i<files1.length;i++)
	    {
	    	while(f5<filesInFolds-1)
	    	{
	    		
	    	    folder7[f5] = files1[i];
	    	    f5++;
	    	}
	    	
	    }
       f5+=f4;
       System.out.println(f5);
       
       System.out.println("baaal");
       System.out.println(folder3.length);
       System.out.println(folder4.length);
       System.out.println(folder5.length);
       System.out.println(folder6.length);
       System.out.println(folder7.length);
       
       
       
       */
	
	File[] folder1 = new File[111];
    File[] folder2 = new File[111];
    File[] folder3 = new File[111];
    File[] folder4 = new File[111];
    File[] folder5 = new File[111];

    static int[] previousIndexLimit= new int[5],
    		postIndexLimit= new int[5];
    static int p=555,m=1,limit=0,previousLimit=0,preIndex=0,postIndex=0;
    int  c=555/5;

    public (File[] ln, File[] lm) throws IOException {
        super(ln, lm);
    }

    public void arrInitializer(){
        for(int i=0;i<5;i++){
            previousIndexLimit[i]=0;
            postIndexLimit[i]=0;
        }
    }



    public void fiveFolding()
    {
               while(m<=5)
               {
                   limit = c*m;

                   if(m==1){
                       previousIndexLimit[m-1]=previousLimit;
                       postIndexLimit[m-1]=limit;
                       folder1=folderMaker(folder1,previousLimit,limit);
                   }
                   else if(m==2){
                       previousIndexLimit[m-1]=previousLimit;
                       postIndexLimit[m-1]=limit;
                       folder2=folderMaker(folder2,previousLimit,limit);
                   }

                   else if(m==3){
                   previousIndexLimit[m-1]=previousLimit;
                       postIndexLimit[m-1]=limit;
                       folder3=folderMaker(folder3,previousLimit,limit);
                   }
                   else if(m==4){
                   previousIndexLimit[m-1]=previousLimit;
                       postIndexLimit[m-1]=limit;
                       folder4=folderMaker(folder4,previousLimit,limit);
               }
                   else{
                   previousIndexLimit[m-1]=previousLimit;
                       postIndexLimit[m-1]=limit;
                       folder5=folderMaker(folder5,previousLimit,limit);
                   }

                   previousLimit=limit;
                   m++;
               }


           }



    private static File[] folderMaker(File[] folder, int previousLimit, int limit)
    {
        int i=0;
        for(int j=previousLimit;j<limit;j++)
        {
            folder[i++] = listOfMainFiles[j];
        }
        return folder;
    }

	    

	   
	    
	    
   }
   

