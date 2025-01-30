package utilidades;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class CargarGuardar {

    public static final String PLAYER_ATLAS = "Warrior_Blue.png";
    public static final String LEVEL_ATLAS = "Terrain.png";

    public static BufferedImage GetSpriteAtlas(String fileName){

        BufferedImage imagen = null;
        InputStream flujo = CargarGuardar.class.getResourceAsStream("/" + fileName);
		try {
			imagen = ImageIO.read(flujo);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				flujo.close();
				if (flujo != null) {
                    flujo.close();
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return imagen;
	}


}
