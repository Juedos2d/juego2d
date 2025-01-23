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
import static utilidades.Constantes.JugadorConstantes.*;

public class PanelJuego extends JPanel {
	
	private MouseInpunts mouseInpunts;
	private float  xLado = 100, yArriba = 100; //Instancio variables de movimiento para los movimientos
	private BufferedImage imagen;
	private BufferedImage[][] animaciones;
	private int  aniSegundo, aniNormal, velocidadAni = 30; //Para crear el recorrido completo de las animaciones //velocidad de las animaciones
	private int jugadorAccion = ESTANDAR;

	
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
		animaciones = new BufferedImage[6][6];
		
		for(int j = 0; j < animaciones.length; j++)
	  
			for(int i = 0; i < animaciones[j].length; i++) {
				animaciones[i][j] = imagen.getSubimage(i*190, j * 179 ,128 ,179);
	    }
	}

	InputStream flujo = getClass().getResourceAsStream("Warrior_Blue.png");
	
	private void importarImagen() {
		
		if (flujo == null) {
		    System.out.println("¡El archivo de imagen no se encuentra! Verifica la ruta.");
		} else {
		    try {
		        imagen = ImageIO.read(flujo);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
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
			
			
		}if(aniNormal >= 6) {
			aniNormal = 0;
		}
			
		
	}
	
	//Para dibujar necesitas un jpanel pero no es el que dibuja es el contenedor 
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
	
		cargarAnimacionCompleta(); 
		g.drawImage(animaciones[jugadorAccion][aniNormal], (int) xLado, (int) yArriba, 128, 179, null); // LLamo aqui a la posicion 3 ya que es la que esta a mitad de la animacion

	}


}