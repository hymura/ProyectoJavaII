package co.com.udem.registro.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tipo_identificacion")
public class TipoIdentificacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTipoIdent;
	private String tipo;
	private String descripcion;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_ident")	
	private Set<RegistroUsuario> registroUsuario;
	



	public TipoIdentificacion(Long idTipoIdent, String tipo, String descripcion) {
		super();
		this.idTipoIdent = idTipoIdent;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}


	public TipoIdentificacion() {
	
	}


	public Long getIdTipoIdent() {
		return idTipoIdent;
	}


	public void setIdTipoIdent(Long idTipoIdent) {
		this.idTipoIdent = idTipoIdent;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	

}
