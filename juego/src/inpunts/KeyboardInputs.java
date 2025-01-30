package inpunts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utilidades.Constantes.Directions.*;

import main.PanelJuego;
	
public class KeyboardInputs implements KeyListener {

	private PanelJuego panelJuego;
	
	// Movimientos ponemos a la escucha las teclas que van a hacer una aciion o click.
	
	public KeyboardInputs(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;  // Para que se cambien los valores de las variables de movimiento
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:
			panelJuego.getJuego().getJugador().setArriba(true);
			break;
		case KeyEvent.VK_A:
			panelJuego.getJuego().getJugador().setIzq(true);
			break;
		case KeyEvent.VK_S:
			panelJuego.getJuego().getJugador().setAbajo(true);
			break;
		case KeyEvent.VK_D:
			panelJuego.getJuego().getJugador().setDer(true); // True para cuando se presiona al vez
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			panelJuego.getJuego().getJugador().setArriba(false);
			break;
		case KeyEvent.VK_A:
			panelJuego.getJuego().getJugador().setIzq(false);
			break;
		case KeyEvent.VK_S:
			panelJuego.getJuego().getJugador().setAbajo(false);
			break;
		case KeyEvent.VK_D:
			panelJuego.getJuego().getJugador().setDer(false);
			break;
		}
		
	}

}
