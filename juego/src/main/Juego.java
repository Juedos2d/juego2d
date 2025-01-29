package main;

import java.awt.Graphics;

import entidades.Jugador;

public class Juego implements Runnable{
	private VentanaJuego ventanaJuego;
	private PanelJuego panelJuego;
	private Thread juegoHilo;
	private final int FPS_LIMITADOR = 120;
	private final int UPS_SET = 200;

	private Jugador jugador;
	
	public Juego() {
		initClases();
		panelJuego = new PanelJuego(this);
		ventanaJuego = new VentanaJuego(panelJuego);
		panelJuego.setFocusable(true);
		panelJuego.requestFocus(); // Establece un foco de entrada para los eventos
		
		
		empezarJuego();
		
	}

	private void initClases() {
		jugador = new Jugador(200, 200); // Posiciona el jugador en un sitio
    }
	
	
	private void empezarJuego() {  // LLamamos al hilo el cual lleva la ejecucion del juego
		juegoHilo = new Thread(this);
		juegoHilo.start();
	}

	public void actualiza() {
		jugador.actualiza();
        
    }
	
	public void render(Graphics g) {
		jugador.render(g);
		
	}
	
	
	@Override
	public void run() {
		
		double tiempoPorFrame =  1000000000 / FPS_LIMITADOR; //  Lo pondre en nanosegundos para que sea mas exacto
		double tiempoPorActualizacion = 1000000000 / UPS_SET;

		long tiempoanterior= System.nanoTime();

		int frames = 0;
		int updates = 0;
		long ultimaActfps = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		
		while (true) {
			long tiempoActual = System.nanoTime();
			
			deltaU += (tiempoActual - tiempoanterior) / tiempoPorActualizacion;
			deltaF += (tiempoActual - tiempoanterior) / tiempoPorFrame;
			tiempoanterior = tiempoActual;

			if (deltaU >=1){
				actualiza();
				updates++;
				deltaU--;
			}

			if(deltaF >= 1){
				panelJuego.repaint();
				frames++;
				deltaF--;
			}

			if(System.currentTimeMillis() - ultimaActfps >= 1000) {
				ultimaActfps = System.currentTimeMillis();
				System.out.println("FPS: " + frames + "| UPS:" + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	
	public void windowFocusLost() {
		jugador.resetearBoleanos();
	}
	
	
	
	public Jugador getJugador() {
		return jugador;
	}
	


}