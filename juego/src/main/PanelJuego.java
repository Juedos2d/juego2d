package main;

import java.awt.Graphics;


import javax.swing.JPanel;

import inpunts.KeyboardInputs;
import inpunts.MouseInpunts;

public class PanelJuego extends JPanel {
	
	private MouseInpunts mouseInpunts;
	private int xLado = 100, yArriba = 100; //Instancio variables de movimiento para los movimientos
	
//Esta clase se encarga de dibujar
	public PanelJuego() {
		
		//Llamamos a la clase que gestiona las llamadas de eventos
		mouseInpunts = new MouseInpunts(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInpunts);
		addMouseMotionListener(mouseInpunts);
		setFocusable(true);
        requestFocusInWindow();
	}
	
	public void cambiarYArriba(int valor) {
		this.yArriba += valor;
		repaint(); //Actualizamos el dibujo por asi llamarlo
		
	}
	
	public void cambiarXLado(int valor) {
		this.xLado += valor;
		repaint();
	}
	
	public void setPosicion(int x, int y) {
		this.yArriba = y;
		this.xLado = x;
		repaint();
		
	}
	
	
	//Para dibujar necesitas un jpanel pero no es el que dibuja es el contenedor
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(xLado, yArriba, 200, 50);
		
	}
}