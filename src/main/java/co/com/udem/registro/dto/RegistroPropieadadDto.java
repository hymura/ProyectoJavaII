package co.com.udem.registro.dto;

public class RegistroPropieadadDto {
	
	private Long idPropiedad;
	private String area;
	private Integer numeroHabitaciones;
	private Integer numeroBanos;
	private Double valor;	
	private TipoPropiedadDto tipoPropiedadDto;
	private RegistroUsuarioDto registroUsuarioDto;


	public RegistroPropieadadDto(Long idPropiedad, String area, Integer numeroHabitaciones, Integer numeroBanos, Double valor,
			TipoPropiedadDto tipoPropiedadDto, RegistroUsuarioDto registroUsuarioDto) {

		this.idPropiedad = idPropiedad;
		this.area = area;
		this.numeroHabitaciones = numeroHabitaciones;
		this.numeroBanos = numeroBanos;
		this.valor = valor;
		this.tipoPropiedadDto = tipoPropiedadDto;
		this.registroUsuarioDto = registroUsuarioDto;
	}

	public RegistroPropieadadDto() {
	}

	public Long getId() {
		return idPropiedad;
	}

	public void setId(Long idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(Integer numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public Integer getNumeroBanos() {
		return numeroBanos;
	}

	public void setNumeroBanos(Integer numeroBanos) {
		this.numeroBanos = numeroBanos;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoPropiedadDto getTipoPropiedadDto() {
		return tipoPropiedadDto;
	}

	public void setTipoPropiedadDto(TipoPropiedadDto tipoPropiedadDto) {
		this.tipoPropiedadDto = tipoPropiedadDto;
	}

	public RegistroUsuarioDto getRegistroUsuarioDto() {
		return registroUsuarioDto;
	}

	public void setRegistroUsuarioDto(RegistroUsuarioDto registroUsuarioDto) {
		this.registroUsuarioDto = registroUsuarioDto;
	}
	


}
