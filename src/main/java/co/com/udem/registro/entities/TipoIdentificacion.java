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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
		

}
