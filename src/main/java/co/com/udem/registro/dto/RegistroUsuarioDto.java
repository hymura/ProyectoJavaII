package co.com.udem.registro.dto;
import static java.util.Objects.requireNonNull;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.udem.registro.util.ManejoExcepcion;

public class RegistroUsuarioDto {
	
	private Long idUsuario;
	private String nombres;
	private String apellidos;
    private String identificacion;
	private String direccion;
	private String telefono;
	private String email;
	private String password;
	
	@Autowired
	private TipoIdentificacionDto tipoIdentificacionDto;	

	public RegistroUsuarioDto(Long idUsuario, String nombres, String apellidos, String identificacion, String direccion,
			String telefono, String email, String password, TipoIdentificacionDto tipoIdentificacionDto) {

		this.idUsuario = idUsuario;
		this.nombres = requireNonNull(nombres);
		this.apellidos = apellidos;
		this.identificacion = requireNonNull(identificacion);
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = requireNonNull(email);
		this.password = requireNonNull(password);
		this.tipoIdentificacionDto = tipoIdentificacionDto;
	}


	public RegistroUsuarioDto() {
	
	}

	
	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) throws ManejoExcepcion {
		 if (nombres.matches("[a-zA-Z- ]+")) {
	            this.nombres = nombres;
	        } else {
	            throw new ManejoExcepcion("El Nombre no cumple con las especificaciones minimas a-z o A-Z");
	        }
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) throws ManejoExcepcion {
		
		if (apellidos.matches("[a-zA-Z- ]+")) {
		this.apellidos = apellidos;
		}else {
			 throw new ManejoExcepcion("El Apellido no cumple con las especificaciones minimas a-z o A-Z");
		}
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) throws ManejoExcepcion {
		if (identificacion.matches("[a-zA-Z0-9]+")) {
		this.identificacion = identificacion;
		}else
		{throw new ManejoExcepcion("El Documento de Identidad no cumple con las especificaciones minimas a-z o A-Z");
		}
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
	public void setTelefono(String telefono) throws ManejoExcepcion {
		 if (telefono.length() < 7) {
	            throw new ManejoExcepcion("El numero telefónico  debe ser mayor a 6 digitos ");
	        }
	        this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws ManejoExcepcion {
		if(email.matches("[^@]+@[^@]+\\.[a-zA-Z]{2,}")) {
			this.email = email;
		}
			else {
	            throw new ManejoExcepcion("El Mail no cumple con las especificaciones minimas");
	        }
		
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
