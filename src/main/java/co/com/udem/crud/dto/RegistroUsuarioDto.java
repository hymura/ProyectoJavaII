package co.com.udem.crud.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class RegistroUsuarioDto {
	
	private Long id;
	private String nombres;
	private String apellidos;
    private String identificacion;
	private String direccion;
	private String telefono;
	private String email;
	private String password;
	
	@Autowired
	private TipoIdentificacionDto tipoIdentificacionDto;	


	
	
	
	public RegistroUsuarioDto(Long id, String nombres, String apellidos, String identificacion, String direccion,
			String telefono, String email, String password, TipoIdentificacionDto tipoIdentificacionDto) {

		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.tipoIdentificacionDto = tipoIdentificacionDto;
	}



	public RegistroUsuarioDto(Long id, String nombres, String apellidos, String identificacion, String direccion,
			String telefono, String email, String password, Long tipoIdentificacion) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.tipoIdentificacionDto.setIdTipoIdent(tipoIdentificacion);		
		
	}
	
	
	
	public RegistroUsuarioDto() {
	
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public TipoIdentificacionDto getTipoIdentificacionDto() {
		return tipoIdentificacionDto;
	}
	public void setTipoIdentificacionDto(TipoIdentificacionDto tipoIdentificacionDto) {
		this.tipoIdentificacionDto = tipoIdentificacionDto;
	}

}
