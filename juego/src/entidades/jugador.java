package entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import static utilidades.Constantes.JugadorConstantes.*;
import static utilidades.Constantes.Directions.*;

public class Jugador extends entidad{

	private BufferedImage[][] animaciones;
	private int  aniSegundo, aniNormal, velocidadAni = 45; //Para crear el recorrido completo de las animaciones //velocidad de las animaciones
	private int jugadorAccion = ESTANDAR;
	private int jugadorDir = -1;
	private boolean moving = false;
	


	public Jugador(float x, float y) {
		super(x, y);
		loadAnimations();
		
	}
	
	public void update() {
		cargarAnimacionCompleta(); 
		setAnimacion();
		cambiarPos();
		
		
	}
	
	public void render(Graphics g) {
		g.drawImage(animaciones[jugadorAccion][aniNormal], (int) x, (int) y, 128, 179, null); // LLamo aqui a la posicion 3 ya que es la que esta a mitad de la animacion
		
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
				x -=5;
				break;
			case ARRIBA:
				y -=5;
				break;
			case DERECHA:
				x +=5;
				break;
			case ABAJO:
				y +=5;
				break;
			
			}
		}
	}
	
	private void loadAnimations() {
		
		InputStream flujo = getClass().getResourceAsStream("/Warrior_Blue.png");
		
		try {
			BufferedImage imagen = ImageIO.read(flujo);

			animaciones = new BufferedImage[6][6];
		
			for(int j = 0; j < animaciones.length; j++)
				for(int i = 0; i < animaciones[j].length; i++) 
					animaciones[j][i] = imagen.getSubimage(i*195, j * 179 ,128 ,179);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				flujo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}		
}


