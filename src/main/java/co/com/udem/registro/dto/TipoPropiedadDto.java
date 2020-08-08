package co.com.udem.registro.dto;

public class TipoPropiedadDto {
	
	private Long idTipoPropiedad;
    private String descripcion;

    public TipoPropiedadDto(Long idTipoPropiedad, String descripcion) {
		this.idTipoPropiedad = idTipoPropiedad;
		this.descripcion = descripcion;
	}

	public TipoPropiedadDto() {	
	}

	public Long getIdTipoPropiedad() {
		return idTipoPropiedad;
	}

	public void setIdTipoPropiedad(Long idTipoPropiedad) {
		this.idTipoPropiedad = idTipoPropiedad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    


}
