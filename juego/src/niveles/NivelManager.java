package niveles;

import java.awt.image.BufferedImage;
import main.Juego;
import utilidades.CargarGuardar;

public class NivelManager {
    private Juego juego;
    private BufferedImage nivelSprite;

    public NivelManager(Juego juego) {
        this.juego = juego;
        nivelSprite = CargarGuardar.GetSpriteAtlas(CargarGuardar.LEVEL_ATLAS);
    }
}