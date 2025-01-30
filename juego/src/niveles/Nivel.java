package niveles;

public class Nivel {
	
	private int[][] nivelDatos;
	
	public Nivel(int[][] nivelDatos) {
		this.nivelDatos = nivelDatos;
		
		
	}

	public int getSpriteComienzo(int x, int y) {
		return nivelDatos[y][x];
	}
	
	
}
