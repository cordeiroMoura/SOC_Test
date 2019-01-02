package br.com.soc.commons;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CaptureScreen {
	
	public static String capturePage(File savePathEvidence, String titlePage) throws AWTException, IOException {

        String format = "jpg";
        Robot robot = new Robot ();

        // Printa tela
        Rectangle screenRect = new Rectangle (Toolkit.getDefaultToolkit ().getScreenSize ());
        BufferedImage screenFullImage = robot.createScreenCapture (screenRect);
        ImageIO.write (screenFullImage, format, new File (savePathEvidence + "/" + titlePage + ".jpg"));
        String pathEvidence = savePathEvidence + "/" + titlePage + ".jpg";

        return pathEvidence;
    }
}
