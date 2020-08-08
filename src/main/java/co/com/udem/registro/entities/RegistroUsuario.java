package co.com.udem.registro.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registro_usuario")
public class RegistroUsuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String direccion;
	private String telefono;
	private String email;
	private String password;

	
	@ManyToOne
	  @JoinColumn(name="id_tipo_ident")	  
	private TipoIdentificacion tipoIdentificacion;
	
	@OneToMany
	 @JoinColumn(name="id_usuario")	  
	 private Set<RegistroPropieadad> registroPropieadad;
	

}
