package main;

public class Juego implements Runnable{
	private VentanaJuego ventanaJuego;
	private PanelJuego panelJuego;
	private Thread juegoHilo;
	private final int FPS_LIMITADOR = 120;
	
	public Juego() {
		panelJuego = new PanelJuego();
		ventanaJuego = new VentanaJuego(panelJuego);
		panelJuego.setFocusable(true);
		panelJuego.requestFocus(); // Establece un foco de entrada para los eventos
		empezarJuego();
	}
	
	
	private void empezarJuego() {
		juegoHilo = new Thread();
		juegoHilo.start();
	}
	
	
	@Override
	public void run() {
		int frames = 0;
		double tiempoPorFrame =  1000000000 / FPS_LIMITADOR; //  Lo pondre en nanosegundos para que sea mas exacto
		long ultimoFrame = System.nanoTime();
		long ahora =  System.nanoTime();
		long ultimaActfps = System.nanoTime();
		
		while (true) {
			ahora = System.nanoTime(); // Lo pongo dentro del bucle para que se vaya actualizando 
			if(System.nanoTime() - ultimoFrame >= FPS_LIMITADOR) {
			panelJuego.repaint();
			ultimoFrame = ahora;
			frames++;
			
			}
			if(System.currentTimeMillis() - ultimaActfps >= 1000) {
				ultimaActfps = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
		
		
	}
}