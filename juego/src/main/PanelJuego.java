package main;

import inpunts.KeyboardInputs;
import inpunts.MouseInpunts;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelJuego extends JPanel {
	
	private MouseInpunts mouseInpunts;	
//Esta clase se encarga de dibujar
	public PanelJuego() {
		
		//Llamamos a la clase que gestiona las llamadas de eventos
		mouseInpunts = new MouseInpunts(this);
		
		
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

	}

	




}