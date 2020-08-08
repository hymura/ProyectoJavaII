package co.com.udem.registro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "registro_propiedad")
public class RegistroPropieadad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPropiedad;
	private String area;
	private Integer numeroHabitaciones;
	private Integer numeroBanos;
	private Double valor;
	
	@ManyToOne
	  @JoinColumn(name="id_usuario")	  
	private RegistroUsuario registroUsuario;
	
	@ManyToOne
	  @JoinColumn(name="id_tipo_propiedad")	  
	private TipoPropiedad tipoPropiedad;
	
}
