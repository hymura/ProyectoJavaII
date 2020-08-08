package co.com.udem.registro.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.udem.registro.dto.TipoPropiedadDto;
import co.com.udem.registro.entities.TipoPropiedad;
import co.com.udem.registro.entities.factory.TipoPropiedadFactory;
import co.com.udem.registro.repositories.TipoPropiedadRepository;
import co.com.udem.registro.util.Constantes;

@RestController
public class TipoPropiedadRestController {
	
	@Autowired
	private TipoPropiedadRepository tipoPropiedadRepository;
	
	
	@PostMapping("tipoPropiedad/registrar")
	public Map<String, String>  adicionarTipoPropiedad(@RequestBody TipoPropiedadDto tipoPropiedadDto) {
		 Map<String, String> response = new HashMap<>();
		try {	
		TipoPropiedad entity = TipoPropiedadFactory.toEntity(tipoPropiedadDto);
		tipoPropiedadRepository.save(entity);
		
		response.put(Constantes.CODIGO_HTTP, "200");
        response.put(Constantes.MENSAJE_EXITO, "Registrado insertado exitosamente");
	return response;

	}catch (Exception e) {
		  response.put(Constantes.CODIGO_HTTP, "500");
            response.put(Constantes.MENSAJE_ERROR, "Ocurrió un problema al insertar");
            return response;
	}
	}
	
}
