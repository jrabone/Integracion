package negocio;

public class Vendedor {
	private int idVendedor;
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	
	public Vendedor(int idVendedor, String email, String password,
			String nombre, String apellido) {
		this.idVendedor = idVendedor;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public int getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
