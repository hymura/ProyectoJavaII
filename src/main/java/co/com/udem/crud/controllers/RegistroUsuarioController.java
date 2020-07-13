package co.com.udem.crud.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.udem.crud.dto.RegistroUsuarioDto;
import co.com.udem.crud.dto.TipoIdentificacionDto;
import co.com.udem.crud.entities.RegistroUsuario;
import co.com.udem.crud.repositories.RegistroUsuarioRepository;
import co.com.udem.crud.util.Constantes;
import co.com.udem.crud.util.ConverRegistroUsuario;
import co.com.udem.crud.util.ConvertTipoIdentificacion;

@RestController
public class RegistroUsuarioController {

	@Autowired
	private RegistroUsuarioRepository registroUsuarioRepository;
	
	@Autowired
	private ConverRegistroUsuario converRegistroUsuario;
	
	@Autowired
	private ConvertTipoIdentificacion convertTipoIdentificacion;
	
	
	@PostMapping("/registroUsuario/adicionar")
	public Map<String, String> addRegistroUsuario(@RequestBody RegistroUsuarioDto registroUsuarioDto) {
		 Map<String, String> response = new HashMap<>();
		try {
			
			RegistroUsuario registroUsuario= converRegistroUsuario.convertToEntity(registroUsuarioDto);
			registroUsuarioRepository.save(registroUsuario);
						
			 			 
			response.put(Constantes.CODIGO_HTTP, "200");
            response.put(Constantes.MENSAJE_EXITO, "Registrado insertado exitosamente");
            return response;
        } catch (Exception e) {
            response.put(Constantes.CODIGO_HTTP, "500");
            response.put(Constantes.MENSAJE_ERROR, "Ocurrió un problema al insertar");
            return response;
        }
	}

	
	@PutMapping("/registroUsuario/{id}")	
	public   ResponseEntity<Object> updateCliente(@RequestBody RegistroUsuarioDto newUser, @PathVariable Long id ){
		
		 if(registroUsuarioRepository.findById(id).isPresent()) {
		    RegistroUsuario  registroUsuario=converRegistroUsuario.convertToEntity(newUser);		    
		    registroUsuarioRepository.save(registroUsuario);
		 return ResponseEntity.ok("Se actualizó exitosamente");
    }else {
        return null;
    }
				
	}
		
	
	@GetMapping("/registroUsuario")
	public Iterable<RegistroUsuarioDto> listfindAll(){
		
		List<RegistroUsuarioDto> listUsuarioDto =new ArrayList<>();
			
		for (RegistroUsuario usuario: registroUsuarioRepository.findAll()) {
			listUsuarioDto.add(new RegistroUsuarioDto(usuario.getId(),usuario.getNombres(), usuario.getApellidos(),usuario.getIdentificacion(),usuario.getDireccion(),usuario.getTelefono(),usuario.getEmail(),usuario.getPassword(),					
					new TipoIdentificacionDto(usuario.getTipoIdentificacion().getIdTipoIdent(), usuario.getTipoIdentificacion().getTipo(), usuario.getTipoIdentificacion().getDescripcion())
					
					)
					);
				
		}
  
		return listUsuarioDto;	

	}
	
	
	@DeleteMapping("/registroUsuario/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		registroUsuarioRepository.deleteById(id);
		
	}
	
}
