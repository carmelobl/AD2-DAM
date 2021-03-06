package ObjetOutput;

import java.io.Serializable;

public class Libro extends Biblioteca implements Prestable,Serializable{
	
	boolean prestado;

	public Libro(String codigo, String titulo, int aņoPublicacion) {
		super(codigo,titulo,aņoPublicacion);
		this.prestado = false;
	}
	@Override
	public String toString() {
		return "Libro [prestado=" + prestado + ", codigo=" + codigo + ", titulo=" + titulo + ", AņoPublicacion="
				+ AņoPublicacion + "]";
	}
	public  int getAņo() {
		return AņoPublicacion;
	}
	public String getCodigo() {
		return codigo;
	}
	public boolean getPrestado() {
		return prestado;
	}
	@Override
	public void prestar() {
		 this.prestado=true;
	}
	@Override
	public void devolver() {
		this.prestado=false;
	}

}
