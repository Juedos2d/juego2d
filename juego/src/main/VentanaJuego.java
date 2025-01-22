package main;

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
    }
}