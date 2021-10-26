package ObjetOutput;

import java.io.Serializable;

public class Libro extends Biblioteca implements Prestable,Serializable{
	
	boolean prestado;

	public Libro(String codigo, String titulo, int a�oPublicacion) {
		super(codigo,titulo,a�oPublicacion);
		this.prestado = false;
	}
	@Override
	public String toString() {
		return "Libro [prestado=" + prestado + ", codigo=" + codigo + ", titulo=" + titulo + ", A�oPublicacion="
				+ A�oPublicacion + "]";
	}
	public  int getA�o() {
		return A�oPublicacion;
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
