package co.com.udem.crud.util;

import java.text.ParseException;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.udem.crud.dto.TipoIdentificacionDto;
import co.com.udem.crud.entities.TipoIdentificacion;

public class ConvertTipoIdentificacion {
	
	@Autowired
	private ModelMapper modelMapper;
	
    public TipoIdentificacion convertToEntity(TipoIdentificacionDto tipoIdentificacionDto) throws ParseException {
        return modelMapper.map(tipoIdentificacionDto, TipoIdentificacion.class);
    }
    
    public TipoIdentificacionDto convertToDTO(TipoIdentificacion tipoIdentificacion) throws ParseException {
        return modelMapper.map(tipoIdentificacion, TipoIdentificacionDto.class);
    }

	public Iterable<TipoIdentificacionDto> listConvertToDTO(Iterable<TipoIdentificacion> entity) throws ParseException{				 	
		return Arrays.asList(modelMapper.map(entity, TipoIdentificacionDto[].class));

	}

}
