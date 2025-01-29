package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class VentanaJuego {
    private JFrame jframe;

    public VentanaJuego(PanelJuego juegoPanel) {
        jframe = new JFrame();
       
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(juegoPanel);
        jframe.setResizable(false); //Tamaño estatico
        jframe.setLocationRelativeTo(null);
        
        jframe.pack(); //Pa que pille el tamaño del jpanel mas facil
        jframe.setVisible(true);
        
        jframe.addWindowFocusListener(new WindowFocusListener() { //Realizamos esto para no perder el foco(El foco es cuando no esta seleccionando la ventana y esta selccionando otra que esta por debajo)
        	
        	@Override
        	public void windowLostFocus(WindowEvent e) {
        		juegoPanel.getJuego().windowFocusLost();
        	}
        	
        	@Override
        	public void windowGainedFocus(WindowEvent e) {
        		
        	}
        	
        });
    }
}