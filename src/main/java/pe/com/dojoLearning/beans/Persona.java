package pe.com.dojoLearning.beans;

public class Persona {
	private String nombre;
	private String apellidos;
	private String cargo;
	
	public Persona(String nombre, String apellidos, String cargo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cargo = cargo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	} 
	public StringBuilder info() {
		StringBuilder data = new StringBuilder();
		// adds 9 character string at beginning
		data.append("Persona [nombre=");
		data.append(nombre);
		data.append(", apellidos=");
		data.append(apellidos);
		data.append(", cargo=");
		data.append(cargo);
		data.append("]");
		return data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
