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
	private BufferedImage[][] animaciones;
	private int  aniSegundo, aniNormal; //Para crear el recorrido completo de las animaciones
	private int  velocidadAni = 30; //velocidad de las animaciones

	
//Esta clase se encarga de dibujar
	public PanelJuego() {
		
		//Llamamos a la clase que gestiona las llamadas de eventos
		mouseInpunts = new MouseInpunts(this);
		
		importarImagen();
		cargarAnimaciones();
		
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInpunts);
		addMouseMotionListener(mouseInpunts);
		setFocusable(true);
        requestFocusInWindow();
	} 
	
	private void cargarAnimaciones() {
		animaciones = new BufferedImage[8][6];
		
		for(int j = 0; j < animaciones.length; j++)
	  
			for(int i = 0; i < animaciones[j].length; i++) {
				animaciones[i][j] = imagen.getSubimage(i*128, j * 179 ,128 ,179);
	    }
	}

	private void importarImagen() {
		InputStream flujo = getClass().getResourceAsStream("/Warrior_Blue.png");
		
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
	
	
	private void cargarAnimacionCompleta() {
		aniSegundo++;
		
		if(aniSegundo >= velocidadAni ){
			aniSegundo = 0;
			aniNormal++;
			
			
		}if(aniNormal >= listaDefecto.length) {
			aniNormal = 0;
		}
			
		
	}
	
	//Para dibujar necesitas un jpanel pero no es el que dibuja es el contenedor
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
	
		cargarAnimacionCompleta(); 
		g.drawImage(listaDefecto[aniNormal], (int) xLado, (int) yArriba, 128, 179, null); // LLamo aqui a la posicion 3 ya que es la que esta a mitad de la animacion

	}


}