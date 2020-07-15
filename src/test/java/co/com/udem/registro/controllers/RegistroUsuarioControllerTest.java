package co.com.udem.registro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import co.com.udem.registro.ProyectoJavaIiApplication;
import co.com.udem.registro.dto.RegistroUsuarioDto;
import co.com.udem.registro.dto.TipoIdentificacionDto;
import co.com.udem.registro.entities.RegistroUsuario;
import co.com.udem.registro.entities.TipoIdentificacion;
import co.com.udem.registro.util.ManejoExcepcion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProyectoJavaIiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistroUsuarioControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}



	@Test
	public void testGetRegistroUsuario() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/registroUsuario", HttpMethod.GET, entity,
				String.class);
		assertNotNull(response.getBody());
	}

	
	@Test
	public void testCreateRegistroUsuario() throws ManejoExcepcion {
	long l = 10;
     TipoIdentificacionDto tipoIdentificacionDto= new TipoIdentificacionDto(l,"CC","Cédula de Ciudadanía");
	
	RegistroUsuarioDto registroUsuarioDto= new RegistroUsuarioDto();
	registroUsuarioDto.setNombres("Victor Manuel");
	registroUsuarioDto.setApellidos("Gomez");
	registroUsuarioDto.setDireccion("Las palmas de la gran canaria");
	registroUsuarioDto.setEmail("victor.gomez@familia.com");
	registroUsuarioDto.setIdentificacion("1256789");
	registroUsuarioDto.setPassword("12345");
	registroUsuarioDto.setTelefono("4424485");
	registroUsuarioDto.setTipoIdentificacionDto(tipoIdentificacionDto);
	
	
	ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/registroUsuario/adicionar",
	registroUsuarioDto, String.class);
	assertNotNull(postResponse);
	assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testUpdateUsuario() {
     long l = 10;
	 TipoIdentificacion tipoIdentificacion= new TipoIdentificacion(l,"CC","Cédula de Ciudadanía");
		
		int id = 1;
	RegistroUsuario registroUsuario= restTemplate.getForObject(getRootUrl() + "/registroUsuario/" + id, RegistroUsuario.class);
	registroUsuario.setNombres("Victor Manuel");
	registroUsuario.setApellidos("Gomez");
	registroUsuario.setDireccion("Las palmas de la gran canaria");
	registroUsuario.setEmail("victor.gomez@familia.com");
	registroUsuario.setIdentificacion("1256789");
	registroUsuario.setPassword("12345");
	registroUsuario.setTelefono("4424485");
	registroUsuario.setTipoIdentificacion(tipoIdentificacion);
	
	restTemplate.put(getRootUrl() + "/usuarios/" + id, registroUsuario);
	RegistroUsuario updatedUsuario = restTemplate.getForObject(getRootUrl() + "/registroUsuario/" + id, RegistroUsuario.class);
	assertNotNull(updatedUsuario);
	}

	
	
}
