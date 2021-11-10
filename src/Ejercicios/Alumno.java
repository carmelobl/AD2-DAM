package Ejercicios;

public class Alumno {
	private int edad;
	private String nombre;
	public Alumno(int edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
	}
	public Alumno() {
		
	}
	@Override
	public String toString() {
		return "alumno [edad=" + edad + ", nombre=" + nombre + "]";
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
