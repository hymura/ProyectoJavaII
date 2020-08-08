package co.com.udem.registro.entities.factory;

import co.com.udem.registro.dto.TipoPropiedadDto;


import co.com.udem.registro.entities.TipoPropiedad;

public final class TipoPropiedadFactory {

	private  TipoPropiedadFactory() {	}
	
	public static TipoPropiedadDto toModel(TipoPropiedad entity) {
		return new TipoPropiedadDto(entity.getIdTipoPropiedad(),entity.getDescripcion());	
	}
	
    public static TipoPropiedad toEntity(TipoPropiedadDto tipoPropiedadDto) {
        return TipoPropiedad.builder().
        		idTipoPropiedad(tipoPropiedadDto.getIdTipoPropiedad())
        		.descripcion(tipoPropiedadDto.getDescripcion())                
                .build();
    }
	
	

}
