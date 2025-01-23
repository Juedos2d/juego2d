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
import static utilidades.Constantes.Directions.*;

public class PanelJuego extends JPanel {
	
	private MouseInpunts mouseInpunts;
	private float  xLado = 100, yArriba = 100; //Instancio variables de movimiento para los movimientos
	private BufferedImage imagen;
	private BufferedImage[][] animaciones;
	private int  aniSegundo, aniNormal, velocidadAni = 45; //Para crear el recorrido completo de las animaciones //velocidad de las animaciones
	private int jugadorAccion = ESTANDAR;
	private int jugadorDir = -1;
	private boolean moving = false;

	
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
	} 
	
	private void cargarAnimaciones() {
		animaciones = new BufferedImage[6][6];
		
		for(int j = 0; j < animaciones.length; j++)
			for(int i = 0; i < animaciones[j].length; i++) 
				animaciones[j][i] = imagen.getSubimage(i*195, j * 179 ,128 ,179);
	    
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

	public void setDirection(int direccion) {
		this.jugadorDir = direccion;
		moving = true;
		
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
		
	}
	

	
	
	private void cargarAnimacionCompleta() {
		aniSegundo++;
		
		if(aniSegundo >= velocidadAni ){
			aniSegundo = 0;
			aniNormal++;
			
			
		}if(aniNormal >= GetSpritesCantidad(jugadorAccion)) {
			aniNormal = 0;
		}
			
		
	}
	private void setAnimacion() {
		if(moving)
			jugadorAccion = CORRER;
		else
			jugadorAccion = ESTANDAR;
		
	}
	private void cambiarPos() {
		if(moving) {
			switch(jugadorDir) {
			case IZQUIERDA:
				xLado-=5;
				break;
			case ARRIBA:
				yArriba-=5;
				break;
			case DERECHA:
				xLado+=5;
				break;
			case ABAJO:
				yArriba +=5;
				break;
			
			}
		}
	}
	
	//Para dibujar necesitas un jpanel pero no es el que dibuja es el contenedor 
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
	
		cargarAnimacionCompleta(); 
		setAnimacion();
		cambiarPos();
		g.drawImage(animaciones[jugadorAccion][aniNormal], (int) xLado, (int) yArriba, 128, 179, null); // LLamo aqui a la posicion 3 ya que es la que esta a mitad de la animacion

	}

	




}