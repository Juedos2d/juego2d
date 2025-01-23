package entidades;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class jugador extends entidad{

	private BufferedImage[][] animations;
	public jugador(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		
		
	}
	
	public void render() {
		
		
	}
	
	private void loadAnimations() {
		
		InputStream flujo = getClass().getResourceAsStream("/Warrior_Blue.png");
		
		try {
			BufferedImage img = ImageIO.read(flujo);
			animations = new BufferedImage[6][6];
			for(int j =0; j < animations.length;j++)
				for(int i = 0; i <animations[j].length;i++)
					animations[j][i] = img.getSubimage(i * 128, j *179,128,179);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		
	}

}
