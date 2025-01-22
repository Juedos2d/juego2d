package main;

import inpunts.KeyboardInputs;
import inpunts.MouseInpunts;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelJuego extends JPanel {
	
	private MouseInpunts mouseInpunts;
	private float  xLado = 100, yArriba = 100; //Instancio variables de movimiento para los movimientos
	private BufferedImage imagen;

	
//Esta clase se encarga de dibujar
	public PanelJuego() {
		
		//Llamamos a la clase que gestiona las llamadas de eventos
		mouseInpunts = new MouseInpunts(this);
		
		importarImagen();
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInpunts);
		addMouseMotionListener(mouseInpunts);
		setFocusable(true);
        requestFocusInWindow();
	} 
	
	private void importarImagen() {
		InputStream flujo = getClass().getResourceAsStream("/res/Warrior_Blue.png");
		
		try {
			imagen = ImageIO.read(flujo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}

	private void setPanelSize() {
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
}

	public void cambiarYArriba(int valor) {
		this.yArriba += valor;
		
		
	}
	
	public void cambiarXLado(int valor) {
		this.xLado += valor;

	}
	
	public void setPosicion(int x, int y) {
		this.yArriba = y;
		this.xLado = x;

		
	}
	
	
	//Para dibujar necesitas un jpanel pero no es el que dibuja es el contenedor
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		//g.drawImage(null, x, y, null);

	}
}