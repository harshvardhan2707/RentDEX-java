import java.awt.Image;

import javax.swing.ImageIcon;

public class GenImage {
private Image img,mod_img;private String s;private int height,width;
public GenImage(String s,String im) {
	this.s=s;
	img=new ImageIcon(im).getImage();
	height = img.getHeight(null);
	width = img.getWidth(null);	
	mod_img=img.getScaledInstance(346*width/height,346 ,java.awt.Image.SCALE_SMOOTH);
}
public int getHeight() {
	return height;
}
public int getWidth() {
	return 346*width/height;
}
public ImageIcon getModifiedImage() {
	return new ImageIcon(mod_img);
}
public ImageIcon getModifiedImage(String s) {
	if(this.s.equals(s)) return getModifiedImage();
	return null;
}
public Image getImg() {
	return img;
}
public void setImg(Image img) {
	this.img = img;
}
public Image getMod_img() {
	return mod_img;
}
public void setMod_img(Image mod_img) {
	this.mod_img = mod_img;
}
public String getS() {
	return s;
}
public void setS(String s) {
	this.s = s;
}
}
