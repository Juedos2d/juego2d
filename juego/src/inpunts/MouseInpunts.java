package inpunts;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.PanelJuego;

public class MouseInpunts implements MouseListener, MouseMotionListener {
	
	private PanelJuego panelJuego;
	
	public MouseInpunts(PanelJuego panelJuego) {
		this.panelJuego  = panelJuego;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		panelJuego.setPosicion(e.getX(), e.getY());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
}