package co.com.udem.registro.util;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.udem.registro.dto.RegistroUsuarioDto;
import co.com.udem.registro.entities.RegistroUsuario;

public class ConverRegistroUsuario {
	
	@Autowired
	private ModelMapper modelMapper;
	
    public RegistroUsuario convertToEntity(RegistroUsuarioDto registroUsuarioDto)  {
        return modelMapper.map(registroUsuarioDto, RegistroUsuario.class);
    }
    
    public RegistroUsuarioDto convertToDTO(RegistroUsuario registroUsuario)  {
        return modelMapper.map(registroUsuario, RegistroUsuarioDto.class);
    }

	public Iterable<RegistroUsuarioDto> listConvertToDTO(Iterable<RegistroUsuario> entity) {				 			 
		return Arrays.asList(modelMapper.map(entity, RegistroUsuarioDto[].class));
	}
		
	public Iterable<RegistroUsuario> listConvertToEntity(Iterable<RegistroUsuarioDto> listRegistroUsuarioDto) {				 	
		return Arrays.asList(modelMapper.map(listRegistroUsuarioDto, RegistroUsuario[].class));

	}

}
