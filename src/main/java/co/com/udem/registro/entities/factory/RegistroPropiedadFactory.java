package co.com.udem.registro.entities.factory;

import co.com.udem.registro.dto.RegistroPropieadadDto;
import co.com.udem.registro.dto.RegistroUsuarioDto;
import co.com.udem.registro.dto.TipoPropiedadDto;
import co.com.udem.registro.entities.RegistroPropieadad;

public class RegistroPropiedadFactory {

	private RegistroPropiedadFactory() {}
	
	public static RegistroPropieadadDto toModel(RegistroPropieadad entity) {
		
		TipoPropiedadDto tipoPropiedadDto= TipoPropiedadFactory.toModel(entity.getTipoPropiedad());
		RegistroUsuarioDto registroUsuarioDto= RegistroUsuarioFactory.toModel(entity.getRegistroUsuario());
		
		return new RegistroPropieadadDto(entity.getIdPropiedad(), 
										entity.getArea(),
										entity.getNumeroHabitaciones(),
										entity.getNumeroBanos(),
										entity.getValor(),
										tipoPropiedadDto,
										registroUsuarioDto
										);
		
	}
	

	 public static RegistroPropieadad toEntity(RegistroPropieadadDto registroPropiedadDto) {
	        return RegistroPropieadad.builder()
	                .idPropiedad(registroPropiedadDto.getId())
	                .area(registroPropiedadDto.getArea())
	                .numeroHabitaciones(registroPropiedadDto.getNumeroHabitaciones())
	                .numeroBanos(registroPropiedadDto.getNumeroBanos())
	                .valor(registroPropiedadDto.getValor())	                
	                .tipoPropiedad(TipoPropiedadFactory.toEntity(registroPropiedadDto.getTipoPropiedadDto()))
	                .registroUsuario(RegistroUsuarioFactory.toEntity(registroPropiedadDto.getRegistroUsuarioDto())) 
	                .build();
	 }

	
}
