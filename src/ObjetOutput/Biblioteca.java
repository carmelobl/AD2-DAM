package ObjetOutput;

import java.io.Serializable;

public class Biblioteca implements Serializable {
	String codigo,titulo;
	int A�oPublicacion;
	public Biblioteca(String codigo, String titulo, int a�oPublicacion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.A�oPublicacion = a�oPublicacion;
	}
	
	
	
}
