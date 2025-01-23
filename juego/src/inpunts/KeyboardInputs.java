package inpunts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:
			panelJuego.cambiarYArriba(-5);
			panelJuego.repaint();
			break;
		case KeyEvent.VK_A:
			panelJuego.cambiarXLado(-5);
			panelJuego.repaint();
			break;
		case KeyEvent.VK_S:
			panelJuego.cambiarYArriba(5);
			panelJuego.repaint();
			break;
		case KeyEvent.VK_D:
			panelJuego.cambiarXLado(5);
			panelJuego.repaint();
			break;
		}
		
	}

}
