package utilidades;

public class Constantes {

	public static class Directions{
		public static final int IZQUIERDA  = 0;
		public static final int ARRIBA  = 1;
		public static final int DERECHA  = 2;
		public static final int ABAJO  = 3;

	}
	
	
	public static class JugadorConstantes{
		public static final int ESTANDAR = 0;
		public static final int CORRER = 1;
		public static final int SALTAR = 2;
		public static final int GOLPE = 3;
		public static final int ATAQUE_1 = 4;
		public static final int ATAQUE_2 = 5;
		
		public static int GetSpritesCantidad(int jugador_accion) {
			
			switch(jugador_accion) {
			case ESTANDAR:
			case CORRER:
			case SALTAR:
			case GOLPE:
			case ATAQUE_1:
			case ATAQUE_2:
				return 6;
			default:
				return 1;
				
			
			}
			
		}
	}

}
