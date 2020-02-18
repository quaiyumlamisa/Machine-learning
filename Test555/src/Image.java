import java.io.File;

public class Image 
{
  File original=null;
  File mask=null;
  
   public void ImageRead(File files1,File files2)
  {
	  this.original=files1;
	  this.mask=files2;
	  
  }

public File getOriginal() {
	return original;
}

public void setOriginal(File original) {
	this.original = original;
}

public File getMask() {
	return mask;
}

public void setMask(File mask) {
	this.mask = mask;
}
  
  
  
}
