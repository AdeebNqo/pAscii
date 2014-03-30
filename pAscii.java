import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
class pAscii{
	String path;
	private String[][] pixels;
	int h; //height of img
	int w; //width of img
	public pAscii(String path){
		this.path = path;
	}
	public String[][] getPixelArray(){
		try{
			
			//reading in image
			File imgFile = new File(path);
			BufferedImage img = ImageIO.read(imgFile);
			
			//converting image to black and white
			for (int x = 0; x < img.getWidth(); ++x){
    				for (int y = 0; y < img.getHeight(); ++y)
    					{
        				int rgb = img.getRGB(x, y);
        				int r = (rgb >> 16) & 0xFF;
					int g = (rgb >> 8) & 0xFF;
        				int b = (rgb & 0xFF);

        				int grayLevel = (r + g + b) / 3;
        				int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel; 
        				img.setRGB(x, y, gray);
			    }
			}

			//creating pixel array from picture
			h = img.getHeight();
			w = img.getWidth();
			
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
		return null;
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
