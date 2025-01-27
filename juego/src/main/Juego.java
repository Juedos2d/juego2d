package main;

public class Juego implements Runnable{
	private VentanaJuego ventanaJuego;
	private PanelJuego panelJuego;
	private Thread juegoHilo;
	private final int FPS_LIMITADOR = 120;
	private final int UPS_SET = 200;
	
	public Juego() {
		panelJuego = new PanelJuego();
		ventanaJuego = new VentanaJuego(panelJuego);
		panelJuego.setFocusable(true);
		panelJuego.requestFocus(); // Establece un foco de entrada para los eventos
		empezarJuego();
	}
	
	
	private void empezarJuego() {
		juegoHilo = new Thread(this);
		juegoHilo.start();
	}

	public void update() {
		panelJuego.actualizarJuego();
        
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
				update();
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
}