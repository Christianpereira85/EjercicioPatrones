package Ejercicio4;


public class Persona  {
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String documento;
	private int id;
	public Persona(int id,String documento, String apellido1, String apellido2,String nombre1, String nombre2) {
		
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.documento = documento;
		this.id = id;
		
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Persona [nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", documento=" + documento + ", id=" + id + "]";
	}
			
}
