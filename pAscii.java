import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
class pAscii{
	String path;
	private String[][] pixels;
	public pAscii(String path){
		this.path = path;
	}
	public void getPixelArray(){
		try{
			File imgFile = new File(path);
			BufferedImage img = ImageIO.read(imgFile);
			int h = img.getHeight();
			int w = img.getWidth();
			
			pixels = new String[h][w];
			for (int i=0;i<h;i++){
				for (int j=0;j<w;j++){
					int pix = img.getRGB(j,i);
					Color color = new Color(pix);
					int r = color.getRed();
					int g = color.getGreen();
					int b = color.getBlue();
					int sum = r+g+b;
					int total = 3*255;
					float avg = sum/((float)total);
					pixels[i][j] = ""+getChar(avg);
				}
			}
			return pixels;
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void printAscii(){
		//printing array
		for (int i=0;i<h;i++){
			for (int j=0;j<w;j++){
				System.out.print(pixels[i][j]);
			}
			System.out.println();
		}
	}
	public char getChar(float Avg){
		if (Avg <  0.1){
			return '.';
		}
		else if(Avg <  0.2){
			return ',';
		}
		else if (Avg <  0.3){
			return ';';
		}
		else if (Avg <  0.4){
			return '!';
		}
		else if (Avg <  0.5){
			return 'v';
		}
		else if (Avg <  0.6){
			return 'l';
		}
		else if (Avg <  0.7){
			return 'L';
		}
		else if (Avg <  0.8){
			return 'F';
		}
		else if (Avg <  0.9){
			return 'E';
		}
		else if (Avg <= 1.0){
			return '$';
		}
		return ' ';
	}
}
