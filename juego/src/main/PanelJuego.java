package main;

import inpunts.KeyboardInputs;
import inpunts.MouseInpunts;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import static main.Juego.GAME_HEIGHT;
import static main.Juego.GAME_WIDTH;
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
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
		System.out.println("Size: " + GAME_HEIGHT + ": " + GAME_WIDTH);

}

	public void actualizarJuego() {

    }
	
	//Para dibujar necesitas un jpanel pero no es el que dibuja es el contenedor 
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		for (int i = 0; i < 64; i++)
			for (int j = 0; j < 40; j++)
				g.fillRect(i * 20, j * 20, 20, 20); // Aqui pongo las dimensiones para pintarlo todo negro todo el frame

		juego.render(g); // Llamamos para dibujar el muñeco
	}
	
	public Juego getJuego() {
		return juego;
	}
}