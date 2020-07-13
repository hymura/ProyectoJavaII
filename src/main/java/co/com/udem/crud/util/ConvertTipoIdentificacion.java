package co.com.udem.crud.util;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.udem.crud.dto.TipoIdentificacionDto;
import co.com.udem.crud.entities.TipoIdentificacion;

public class ConvertTipoIdentificacion {
	
	@Autowired
	private ModelMapper modelMapper;
	
    public TipoIdentificacion convertToEntity(TipoIdentificacionDto tipoIdentificacionDto)  {
        return modelMapper.map(tipoIdentificacionDto, TipoIdentificacion.class);
    }
    
    public TipoIdentificacionDto convertToDTO(TipoIdentificacion tipoIdentificacion)  {
        return modelMapper.map(tipoIdentificacion, TipoIdentificacionDto.class);
    }

	public Iterable<TipoIdentificacionDto> listConvertToDTO(Iterable<TipoIdentificacion> entity) {				 	
		return Arrays.asList(modelMapper.map(entity, TipoIdentificacionDto[].class));

	}

}
