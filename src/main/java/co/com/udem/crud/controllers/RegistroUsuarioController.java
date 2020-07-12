package co.com.udem.crud.controllers;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.udem.crud.dto.RegistroUsuarioDto;
import co.com.udem.crud.entities.RegistroUsuario;
import co.com.udem.crud.repositories.RegistroUsuarioRepository;
import co.com.udem.crud.util.Constantes;
import co.com.udem.crud.util.ConverRegistroUsuario;

@RestController
public class RegistroUsuarioController {

	@Autowired
	private RegistroUsuarioRepository registroUsuarioRepository;
	
	@Autowired
	private ConverRegistroUsuario converRegistroUsuario;
	
	
	@PostMapping("/registroUsuario/adicionar")
	public Map<String, String> addRegistroUsuario(@RequestBody RegistroUsuarioDto registroUsuarioDto) {
		 Map<String, String> response = new HashMap<>();
		try {
			
			RegistroUsuario registroUsuario= converRegistroUsuario.convertToEntity(registroUsuarioDto);
			registroUsuarioRepository.save(registroUsuario);
						
			 			 
			response.put(Constantes.CODIGO_HTTP, "200");
            response.put(Constantes.MENSAJE_EXITO, "Registrado insertado exitosamente");
            return response;
        } catch (ParseException e) {
            response.put(Constantes.CODIGO_HTTP, "500");
            response.put(Constantes.MENSAJE_ERROR, "Ocurrió un problema al insertar");
            return response;
        }
	}

	
	
	@GetMapping("/registroUsuario")
	public Iterable<RegistroUsuarioDto> listfindAll() throws ParseException{
				
		return converRegistroUsuario.listConvertToDTO(registroUsuarioRepository.findAll());		
	}
	
}
