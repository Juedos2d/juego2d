package main;

public class Juego implements Runnable{
	private VentanaJuego ventanaJuego;
	private PanelJuego panelJuego;
	private Thread juegoHilo;
	
	public Juego() {
		panelJuego = new PanelJuego();
		ventanaJuego = new VentanaJuego(panelJuego);
		panelJuego.setFocusable(true);
		panelJuego.requestFocus(); // Establece un foco de entrada para los eventos
		
	}
	
	
	@Override
	public void run() {
		
	}
}