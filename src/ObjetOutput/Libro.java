package ObjetOutput;

import java.io.Serializable;

public class Libro extends Biblioteca implements Prestable,Serializable{
	
	boolean prestado;

	public Libro(String codigo, String titulo, int añoPublicacion) {
		super(codigo,titulo,añoPublicacion);
		this.prestado = false;
	}
	@Override
	public String toString() {
		return "Libro [prestado=" + prestado + ", codigo=" + codigo + ", titulo=" + titulo + ", AñoPublicacion="
				+ AñoPublicacion + "]";
	}
	public  int getAño() {
		return AñoPublicacion;
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
