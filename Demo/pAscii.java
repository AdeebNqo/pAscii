import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
class pAscii{
	String path;
	public pAscii(String path){
		this.path = path;
	}
	public void start(){
		try{
			File imgFile = new File(path);
			BufferedImage img = ImageIO.read(imgFile);
			int h = img.getHeight();
			int w = img.getWidth();
			
			String[][] pixels = new String[h][w];
			for (int i=0;i<h;i++){
				for (int j=0;j<w;j++){
					int pix = img.getRGB(j,i);
					if (pix==-1){
						pixels[i][j]=" ";
					}
					else{
						pixels[i][j]="|";
					}
				}
			}
			//printing array
			for (int i=0;i<h;i++){
				for (int j=0;j<w;j++){
					System.out.print(pixels[i][j]);
				}
				System.out.println();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
