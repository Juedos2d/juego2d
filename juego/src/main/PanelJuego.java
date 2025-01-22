package main;

import inpunts.KeyboardInputs;
import inpunts.MouseInpunts;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelJuego extends JPanel {
	
	private MouseInpunts mouseInpunts;
	private float  xLado = 100, yArriba = 100; //Instancio variables de movimiento para los movimientos
	private float xDirc = 0.03f, yDirc = 0.03f;
	private int frames = 0;
	private long ultimaActfps = 0;
	private Color color = new Color(150,20,90);
	
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
		
		updateRectangle();
		g.setColor(new Color(150, 20, 90));
		g.fillRect((int)xLado,(int) yArriba, 200, 50);
		
		frames++;
		if(System.currentTimeMillis() - ultimaActfps >= 1000) {
			ultimaActfps = System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames = 0;
		}
		
		repaint(); //Actualizamos el dibujo por asi llamarlo
		
	}

    private void updateRectangle() {
		xLado += xDirc;
		if(xLado > 400 || xLado < 0 ){
			xDirc *= -1;
		}
			
		
		yArriba += yDirc;
		if(yArriba > 400 || yArriba < 0 ){
			yDirc *= -1;
		}
    }

}