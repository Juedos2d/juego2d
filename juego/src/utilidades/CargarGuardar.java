package utilidades;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import main.Juego;

public class CargarGuardar {

    public static final String JUGADOR = "Warrior_Blue.png";
    public static final String NIVEL = "terreno.png";
    public static final String Nivel_Datos = "";

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
    
    public static int[][] ObtenerDatosNivel() {
    	int[][] nivelDatos = new int [Juego.TILES_IN_HEIGHT][Juego.TILES_IN_WIDHT];
    	BufferedImage imagen = GetSpriteAtlas(Nivel_Datos);
    	
    	for(int y = 0; y < imagen.getHeight(); y++)
    		for(int x = 0; x < imagen.getWidth(); x++) {
    			Color color = new Color(imagen.getRGB(x, y));
    			int valor = color.getRed();
    			if (valor >= 40)
    				valor = 0;
    			nivelDatos[y][x] = valor;
    		}
    	return nivelDatos;
    }
    
}