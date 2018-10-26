package utill;

/*@shubsing
 * Compare two images pixel by pixel
 * Pixel Threshold is set to 30
 * Return true/false based on the comparison
 */
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class Imagetest extends Generic {

	final int PixelThreshold = 30;

	public static boolean compare(String exp, String Act) {

		String FinalPath = exp + ".PNG";
		BufferedReader reader = null;
		Imagetest t = new Imagetest();
		reader = t.getFileStream(FinalPath);
		boolean ispass = false;
		if (reader != null) {
			System.out.println("File exists");
			try {
				BufferedImage expImage = ImageIO.read(new File(FinalPath));
				BufferedImage actImage = ImageIO.read(new File(Act));
				ispass = t.imagesMatch(expImage, actImage);

				System.out.println(ispass);
			} catch (Exception e) {
				
				logger(Test, "Error in reading image", "E");
				e.printStackTrace();
			}
		} else
			System.out.println("File does not exist");
		
		return ispass;

	}

	public static boolean compareSame(String FinalPath, String Act) {

		BufferedReader reader = null;
		Imagetest t = new Imagetest();
		reader = t.getFileStream(FinalPath);
		boolean ispass = false;
		if (reader != null) {
			System.out.println("File exists");
			try {
				BufferedImage expImage = ImageIO.read(new File(FinalPath));
				BufferedImage actImage = ImageIO.read(new File(Act));
				ispass = t.imagesMatch(expImage, actImage);

				System.out.println(ispass);
			} catch (Exception e) {
				// System.out.println("Error in reading image");
				logger(Test, "Error in reading image", "E");
				e.printStackTrace();
			}
		} else
			System.out.println("File dont exists");
		// logger(Test, "File don't exists", "F");
		return ispass;

	}

	private boolean imagesMatch(BufferedImage expimage, BufferedImage actimage)

	{

		int pixel_diff = 0;

		Raster exp_rast = expimage.getData();
		Raster act_rast = actimage.getData();
		DataBuffer exp_db = exp_rast.getDataBuffer();
		DataBuffer act_db = act_rast.getDataBuffer();

		System.out.println(exp_db.getSize() + ">> " + act_db.getSize());

		if (exp_db.getSize() != act_db.getSize()) {
			pixel_diff = exp_db.getSize() - act_db.getSize();
			logger(Test, "Pixel Diff:-" + pixel_diff + "The Size of the Actual image and the Expected image differ. ",
					"I");

		} else {
			for (int p = 0; p < act_db.getSize(); p++) {
				if (exp_db.getElem(p) != act_db.getElem(p))
					pixel_diff++;
			}
		}
		System.out.println("pixel_diff found is :" + pixel_diff);
		if ((pixel_diff <=PixelThreshold)&&(pixel_diff>=0)) {
			logger(Test, "Actual Image matched from BaseLine Image", "I");
			return true;

		} else {
			logger(Test, "Pixel Diff:-" + pixel_diff + "Actual Image is not matched from BaseLine Image", "I");
			return false;
			
		}
		
		
	}

	public BufferedReader getFileStream(String filename) {
		BufferedReader br = null;
		try {
			if (filename.startsWith("http://")) {
				URLConnection Scr_Con = null;
				URL myurl = new URL(filename);
				Scr_Con = myurl.openConnection();
				br = new BufferedReader(new InputStreamReader(Scr_Con.getInputStream()));
			} else
				br = new BufferedReader(new FileReader(filename));
		} catch (Exception e) {
			
			System.out.println("Error opening file stream : " + e.getStackTrace());
		}
		return br;
	}

}
