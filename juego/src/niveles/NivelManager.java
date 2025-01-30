package niveles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Juego;
import utilidades.CargarGuardar;

public class NivelManager {
    private Juego juego;
    private BufferedImage[] nivelSprite;
    private Nivel nivelUno;
    
    public NivelManager(Juego juego) {
        this.juego = juego;
      //  nivelSprite = CargarGuardar.GetSpriteAtlas(CargarGuardar.NIVEL);
        importFueraSprites();
        nivelUno = new Nivel(CargarGuardar.ObtenerDatosNivel());
    }
    
    private void importFueraSprites() {
    	BufferedImage img = CargarGuardar.GetSpriteAtlas(CargarGuardar.NIVEL);
    	nivelSprite = new BufferedImage[40];
    	for(int y = 0; y < 4; y++)
    		for(int x = 0; x < 10; x++) {
    			int comienzo = y *10 + x;
    			nivelSprite [comienzo] = img.getSubimage(x * 32, y * 32, 32, 32);
    		}
		
	}

	public void draw(Graphics g) {
		for (int y = 0; y < Juego.TILES_IN_HEIGHT; y++)
			for(int x = 0; x < Juego.TILES_IN_WIDHT; x++) {
				int comienzo  = nivelUno.getSpriteComienzo(x, y);
				g.drawImage(nivelSprite[comienzo], Juego.TILES_SIZE* x, Juego.TILES_SIZE * y, Juego.TILES_SIZE, Juego.TILES_SIZE, null);
			}
    	
    }
    public void actualizar() {
    	
    }
    
    
    
}