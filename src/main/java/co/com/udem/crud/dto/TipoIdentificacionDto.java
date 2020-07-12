package co.com.udem.crud.dto;

public class TipoIdentificacionDto {
	
	private Long idTipoIdent;
	private String tipo;
	private String descripcion;
	
		
	public TipoIdentificacionDto(Long idTipoIdent, String tipo, String descripcion) {
		this.idTipoIdent = idTipoIdent;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	
	public TipoIdentificacionDto() {
	
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
