package main;

import inpunts.KeyboardInputs;
import inpunts.MouseInpunts;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
public class PanelJuego extends JPanel {
	
	private MouseInpunts mouseInpunts;	
	private Juego juego;

	public PanelJuego(Juego juego) {
		
		//Llamamos a la clase que gestiona las llamadas de eventos
		mouseInpunts = new MouseInpunts(this);
		this.juego= juego;
		
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInpunts);
		addMouseMotionListener(mouseInpunts);
	} 
	

	private void setPanelSize() {
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
}

	public void actualizarJuego() {

    }
	
	//Para dibujar necesitas un jpanel pero no es el que dibuja es el contenedor 
	public void paintComponent (Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.white);
		for (int i = 0; i < 64; i++)
			for (int j = 0; j < 40; j++)
				g.fillRect(i * 20, j * 20, 20, 20);

		juego.render(g);
	}
	
	public Juego getJuego() {
		return juego;
	}
}