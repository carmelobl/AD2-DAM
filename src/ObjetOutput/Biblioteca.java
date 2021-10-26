package ObjetOutput;

import java.io.Serializable;

public class Biblioteca implements Serializable {
	String codigo,titulo;
	int AñoPublicacion;
	public Biblioteca(String codigo, String titulo, int añoPublicacion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.AñoPublicacion = añoPublicacion;
	}
	
	
	
}
