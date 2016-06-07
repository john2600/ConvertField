
public class User {
	private String nombre;
	private String role;
	private String inter;
	
	
	public User(String nombre, String role, String inter){
		this.nombre = nombre;
		this.role = role;
		this.inter = inter;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [nombre=" + nombre + ", role=" + role + "]";
	}
	

}
