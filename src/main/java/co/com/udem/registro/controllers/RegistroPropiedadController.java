package co.com.udem.registro.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.udem.registro.dto.RegistroPropieadadDto;
import co.com.udem.registro.entities.RegistroPropieadad;
import co.com.udem.registro.entities.factory.RegistroPropiedadFactory;
import co.com.udem.registro.repositories.RegistroPropiedadRepository;
import co.com.udem.registro.util.Constantes;

@RestController
@RequestMapping("/propiedades")
public class RegistroPropiedadController {

	private final RegistroPropiedadRepository registroPropiedadRepository;

	@Autowired
	public RegistroPropiedadController(RegistroPropiedadRepository registroPropiedadRepository) {
		this.registroPropiedadRepository = registroPropiedadRepository;
	}

	@PostMapping("/registrar")
	public Map<String, String> adicionarTipoPropiedad(@RequestBody RegistroPropieadadDto registroPropieadadDto) {
		Map<String, String> response = new HashMap<>();
		try {
			RegistroPropieadad entity = RegistroPropiedadFactory.toEntity(registroPropieadadDto);
			registroPropiedadRepository.save(entity);

			response.put(Constantes.CODIGO_HTTP, "200");
			response.put(Constantes.MENSAJE_EXITO, "Registrado insertado exitosamente");
			return response;

		} catch (Exception e) {
			response.put(Constantes.CODIGO_HTTP, "500");
			response.put(Constantes.MENSAJE_ERROR, "Ocurrió un problema al insertar");
			return response;
		}
	}

	@GetMapping("/consultarPropiedadUsuario/{identificacion}")
	public List<RegistroPropieadadDto> buscarPropiedad(@PathVariable String identificacion,
			@RequestParam(value = "precio", required = false, defaultValue = "") Double precio,
			@RequestParam(value = "numeroHabitaciones", required = false, defaultValue = "") Integer numeroHabitaciones,
			@RequestParam(value = "area", required = false, defaultValue = "") String area) {

		List<RegistroPropieadad> listRegistroPropieadad;

		listRegistroPropieadad = registroPropiedadRepository.consultarPropiedadesUsuario(identificacion, precio,
				numeroHabitaciones, area);

		return listRegistroPropieadad.stream().map(RegistroPropiedadFactory::toModel).collect(Collectors.toList());

	}
	
	@GetMapping("/ListarPropiedades")
	public List<RegistroPropieadadDto> listfindAll() {
		List<RegistroPropieadad> listRegistroPropieadadDto;

		listRegistroPropieadadDto = (List<RegistroPropieadad>) registroPropiedadRepository.findAll();

		return listRegistroPropieadadDto.stream().map(RegistroPropiedadFactory::toModel).collect(Collectors.toList());

	}

	@GetMapping("/ConsultarPropiedades")
	public List<RegistroPropieadadDto> listPropiedades() {

		List<RegistroPropieadadDto> listRegistroPropieadadDto = new ArrayList<>();

		for (RegistroPropieadad registroPropieadad : registroPropiedadRepository.findAll()) {
			listRegistroPropieadadDto.add(RegistroPropiedadFactory.toModel(registroPropieadad));

		}

		return listRegistroPropieadadDto;

	}
	
	@GetMapping("/PropiedadesUsuario/{identificacion}")
	public List<RegistroPropieadadDto> listPropiedadesUsuario(@PathVariable String identificacion) {

		List<RegistroPropieadad> listRegistroPropieadad;
		listRegistroPropieadad = registroPropiedadRepository.consultarPropiedad(identificacion);		

		return listRegistroPropieadad.stream().map(RegistroPropiedadFactory::toModel).collect(Collectors.toList());
	}


	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Object> updateCliente(@RequestBody RegistroPropieadadDto usuarioPropiedadDto,
			@PathVariable Long id) {

		if (registroPropiedadRepository.findById(id).isPresent()) {
			RegistroPropieadad registroPropieadad = RegistroPropiedadFactory.toEntity(usuarioPropiedadDto);
			registroPropiedadRepository.save(registroPropieadad);
			return ResponseEntity.ok("Se actualizó exitosamente");
		} else {
			return null;
		}

	}
	
	@DeleteMapping("/borrar/{id}")
	public void eliminarPropidadUsuario(@PathVariable Long id) {
		registroPropiedadRepository.deleteById(id);

	}


}
