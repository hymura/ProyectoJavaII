package co.com.udem.crud.controllers;

import java.util.HashMap;
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

import co.com.udem.crud.dto.TipoIdentificacionDto;
import co.com.udem.crud.entities.TipoIdentificacion;
import co.com.udem.crud.repositories.TipoIdentificacionRepository;
import co.com.udem.crud.util.ConvertTipoIdentificacion;
import co.com.udem.crud.util.Constantes;


@RestController
public class TipoIdentificacionRestController {
	
		
	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;
	
	@Autowired
	private ConvertTipoIdentificacion convertTipoIdentificacion;
	
	@PostMapping("tipoIdentificacion/registrar")
	public ResponseEntity<String> adicionarTipoDocumento(@RequestBody TipoIdentificacionDto tipoIdentificacionDto) {
		
		TipoIdentificacion tipoIdentifEntity= convertTipoIdentificacion.convertToEntity(tipoIdentificacionDto);
		tipoIdentificacionRepository.save(tipoIdentifEntity);
		return ResponseEntity.ok("Registro guardado");
	}
	
	
	@PostMapping("/tipoIdentificacion/adicionar")
	public Map<String, String> addTipoIdentificacion(@RequestBody TipoIdentificacionDto tipoIdentificacionDto) {
		 Map<String, String> response = new HashMap<>();
		try {
			
			TipoIdentificacion tipoIdentificacion= convertTipoIdentificacion.convertToEntity(tipoIdentificacionDto);
			tipoIdentificacionRepository.save(tipoIdentificacion);
						
			 			 
			response.put(Constantes.CODIGO_HTTP, "200");
            response.put(Constantes.MENSAJE_EXITO, "Registrado insertado exitosamente");
            return response;
        } catch (Exception e) {
            response.put(Constantes.CODIGO_HTTP, "500");
            response.put(Constantes.MENSAJE_ERROR, "Ocurrió un problema al insertar");
            return response;
        }
	}

	
	
	@PutMapping("/tipodocumento/{id}")
	public ResponseEntity<Object> updateTipoDocumento(@RequestBody TipoIdentificacionDto newTipoDocumento, @PathVariable Long id ) 
	{
		if (tipoIdentificacionRepository.findById(id).isPresent()) {
			TipoIdentificacion tipoIdentificacion=convertTipoIdentificacion.convertToEntity(newTipoDocumento);
			tipoIdentificacionRepository.save(tipoIdentificacion);
			 return ResponseEntity.ok("Se actualizó exitosamente");
		}
		return null;
	}
	
	@GetMapping("/tipodocumento")
	public Iterable<TipoIdentificacionDto> listfindAll() {
				
		return convertTipoIdentificacion.listConvertToDTO(tipoIdentificacionRepository.findAll());		
	}
	
	@DeleteMapping("/tipodocumento/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		tipoIdentificacionRepository.deleteById(id);
		
	}

}
