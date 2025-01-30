package entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import static utilidades.Constantes.JugadorConstantes.*;
import static utilidades.Constantes.Directions.*;

public class Jugador extends Entidad{

	private BufferedImage[][] animaciones;
	private int  aniSegundo, aniNormal, velocidadAni = 45; //Para crear el recorrido completo de las animaciones //velocidad de las animaciones
	private int jugadorAccion = ESTANDAR;
	private boolean moving = false, atacar = false;
	private boolean izq, arriba, der, abajo;
	private float jugadorVelocidad = 2.0f;


	public Jugador(float x, float y) {
		super(x, y);
		loadAnimations();
		
	}
	
	public void actualiza() {
		cambiarPos();
		cargarAnimacionCompleta(); 
		setAnimacion();
		
	}
	
	public void render(Graphics g) {
		g.drawImage(animaciones[jugadorAccion][aniNormal], (int) x, (int) y, 128, 179, null); // LLamo aqui a la posicion 3 ya que es la que esta a mitad de la animacion
		
	}
	
	private void cargarAnimacionCompleta() {
		aniSegundo++;
		if(aniSegundo >= velocidadAni ){
			aniSegundo = 0;
			aniNormal++;	
			if(aniNormal >= GetSpritesCantidad(jugadorAccion)) {
				aniNormal = 0;
				atacar = false;
			}
			
		}
	}
	
	private void setAnimacion() {
		
		int startAni = jugadorAccion;
		
		if(moving)
			jugadorAccion = CORRER;
		else
			jugadorAccion = ESTANDAR;
		if(atacar)
			jugadorAccion = ATAQUE_1;
		if(startAni != jugadorAccion)
			resetearAniSeg();
			
		
	}
	
	private void resetearAniSeg() {
		aniNormal = 0;
		aniSegundo = 0;
	}

	private void cambiarPos() { // Esto lo realizamos cuando pulsamos dos teclas a la vez 
		
		moving = false;
		
		if(izq && !der) {
			x -= jugadorVelocidad;
			moving = true; // Instanciarlo despues no se guarda el cambio ya se que es xd esque me paso
		} else if ( der && !izq) {
			x += jugadorVelocidad;
			moving = true;
		}
		
		if(arriba && !abajo) {
			y -= jugadorVelocidad;
			moving = true;
		} else if ( abajo && !arriba) {
			y += jugadorVelocidad;
			moving = true;
		}
	}
	
	private void loadAnimations() {
		
		InputStream flujo = getClass().getResourceAsStream("/Warrior_Blue.png");
		
		try {
			BufferedImage imagen = ImageIO.read(flujo);

			animaciones = new BufferedImage[6][6];
		
			for(int y = 0; y < animaciones.length; y++)
				for(int x = 0; x < animaciones[y].length; x++) 
					animaciones[y][x] = imagen.getSubimage(x*195, y * 179 ,128 ,179);  // x,y,ancho,altura

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				flujo.close();
				if (flujo != null) {
                    flujo.close();
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setAtacar(boolean atacar) {
		this.atacar = atacar;
		
		
	}
	

	public boolean isIzq() {
		return izq;
	}

	public void setIzq(boolean izq) {
		this.izq = izq;
	}

	public boolean isArriba() {
		return arriba;
	}

	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}

	public boolean isDer() {
		return der;
	}

	public void setDer(boolean der) {
		this.der = der;
	}

	public boolean isAbajo() {
		return abajo;
	}

	public void setAbajo(boolean abajo) {
		this.abajo = abajo;
	}

	public void resetearBoleanos() {
			izq = false;
			der = false;
			arriba  = false;
			abajo = false;
	}	
}