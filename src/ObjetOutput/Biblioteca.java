package ObjetOutput;

import java.io.Serializable;

public class Biblioteca implements Serializable {
	String codigo,titulo;
	int AņoPublicacion;
	public Biblioteca(String codigo, String titulo, int aņoPublicacion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.AņoPublicacion = aņoPublicacion;
	}
	
	
	
}
