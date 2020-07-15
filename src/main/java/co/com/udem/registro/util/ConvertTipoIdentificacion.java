package co.com.udem.registro.util;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.udem.registro.dto.TipoIdentificacionDto;
import co.com.udem.registro.entities.TipoIdentificacion;

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
