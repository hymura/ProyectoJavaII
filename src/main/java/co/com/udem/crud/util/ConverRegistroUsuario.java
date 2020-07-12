package co.com.udem.crud.util;

import java.text.ParseException;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.udem.crud.dto.RegistroUsuarioDto;
import co.com.udem.crud.entities.RegistroUsuario;

public class ConverRegistroUsuario {
	
	@Autowired
	private ModelMapper modelMapper;
	
    public RegistroUsuario convertToEntity(RegistroUsuarioDto registroUsuarioDto) throws ParseException {
        return modelMapper.map(registroUsuarioDto, RegistroUsuario.class);
    }
    
    public RegistroUsuarioDto convertToDTO(RegistroUsuario registroUsuario) throws ParseException {
        return modelMapper.map(registroUsuario, RegistroUsuarioDto.class);
    }

	public Iterable<RegistroUsuarioDto> listConvertToDTO(Iterable<RegistroUsuario> entity) throws ParseException{				 	
		return Arrays.asList(modelMapper.map(entity, RegistroUsuarioDto[].class));

	}
	
	
	public Iterable<RegistroUsuario> listConvertToEntity(Iterable<RegistroUsuarioDto> listRegistroUsuarioDto) throws ParseException{				 	
		return Arrays.asList(modelMapper.map(listRegistroUsuarioDto, RegistroUsuario[].class));

	}

}
