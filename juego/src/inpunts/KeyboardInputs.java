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
			panelJuego.setDirection(ARRIBA);
			break;
		case KeyEvent.VK_A:
			panelJuego.setDirection(IZQUIERDA);
			break;
		case KeyEvent.VK_S:
			panelJuego.setDirection(ABAJO);
			break;
		case KeyEvent.VK_D:
			panelJuego.setDirection(DERECHA);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:		
		case KeyEvent.VK_A:			
		case KeyEvent.VK_S:
		case KeyEvent.VK_D:
			panelJuego.setMoving(false);
			break;
		
		}
		
	}

}
