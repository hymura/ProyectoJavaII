package co.com.udem.registro.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

import co.com.udem.autenticacion.dto.AutenticationRequestDTO;
import co.com.udem.autenticacion.dto.AutenticationResponseDTO;
import co.com.udem.registro.ProyectoJavaIiApplication;
import co.com.udem.registro.dto.RegistroPropieadadDto;
import co.com.udem.registro.dto.RegistroUsuarioDto;
import co.com.udem.registro.dto.TipoIdentificacionDto;
import co.com.udem.registro.dto.TipoPropiedadDto;
import co.com.udem.registro.util.ManejoExcepcion;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProyectoJavaIiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistroPropiedadControllerTest {
	

	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	private AutenticationRequestDTO autenticationRequestDTO = new AutenticationRequestDTO();
    private String token; 
    private TipoPropiedadDto tipoPropiedadDto;
    private RegistroPropieadadDto registroPropieadadDto;	    
    private TipoIdentificacionDto tipoIdentificacionDto;
	private RegistroUsuarioDto registroUsuarioDto;
	    
	@Before
	public void setup() throws ManejoExcepcion  {
		
		long idPropieadad=1;
		long  idusuario=2;
		long idTipo = 1;
		long idPropidad=1;
		
		tipoPropiedadDto= new TipoPropiedadDto(idPropieadad, "Venta"); 
		tipoIdentificacionDto = new TipoIdentificacionDto(idTipo, "CC", "Cédula de Ciudadanía");

		registroUsuarioDto = new RegistroUsuarioDto();
		registroUsuarioDto.setIdUsuario(idusuario);
		registroUsuarioDto.setNombres("Prueba");
		registroUsuarioDto.setApellidos("Gomez");
		registroUsuarioDto.setDireccion("Las palmas de la gran canaria");
		registroUsuarioDto.setEmail("victor.gomez@familia.com");
		registroUsuarioDto.setIdentificacion("1256789");
		registroUsuarioDto.setPassword("prueba1234");
		registroUsuarioDto.setTelefono("4424485");
	 	registroUsuarioDto.setTipoIdentificacionDto(tipoIdentificacionDto);
		
	 	registroPropieadadDto = new RegistroPropieadadDto();
	 	registroPropieadadDto.setId(idPropidad);
	 	registroPropieadadDto.setNumeroBanos(2);
	 	registroPropieadadDto.setNumeroHabitaciones(4);
	 	registroPropieadadDto.setArea("150");
	 	registroPropieadadDto.setValor(280000000.00);
	 	registroPropieadadDto.setRegistroUsuarioDto(registroUsuarioDto);
	 	registroPropieadadDto.setTipoPropiedadDto(tipoPropiedadDto);
	 	
	 	autenticationRequestDTO.setUsername(registroUsuarioDto.getIdentificacion());
		autenticationRequestDTO.setPassword(registroUsuarioDto.getPassword());

		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/auth/signin", autenticationRequestDTO, String.class);		
		Gson g = new Gson();		
		AutenticationResponseDTO autenticationResponseDTO = g.fromJson(postResponse.getBody(), AutenticationResponseDTO.class);
		token = autenticationResponseDTO.getToken();
	 	
	}
	  
	@Test
	public void testCreateRegistroUsuario() throws ManejoExcepcion {
		
		
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));		
	     HttpEntity<Object> entity1 = new HttpEntity<>(registroUsuarioDto, headers);	    
	     ResponseEntity<String> response  =restTemplate.exchange(getRootUrl() + "/registroUsuario/adicionar", HttpMethod.POST, entity1, String.class);	     
	     assertEquals(200, response.getStatusCode().value());
		
	}
	
	@Test
	public void testCreateTipoPropiedad() throws ManejoExcepcion {
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		 headers.set("Authorization", "Bearer "+token);
		 HttpEntity<Object> entity1 = new HttpEntity<>(tipoPropiedadDto, headers);
		 ResponseEntity<String> response  =restTemplate.exchange(getRootUrl() + "/tipoPropiedad/registrar", HttpMethod.POST, entity1, String.class);
				     
	     assertEquals(200, response.getStatusCode().value());
		
	}	
	
	@Test
	public void testCreatePropieadad() throws ManejoExcepcion {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));		
		headers.set("Authorization", "Bearer "+token);
	    HttpEntity<Object> entity1 = new HttpEntity<>(registroPropieadadDto, headers);
		ResponseEntity<String> response  =restTemplate.exchange(getRootUrl() + "/propiedades/registrar", HttpMethod.POST, entity1, String.class);
		  	         
	    assertEquals(200, response.getStatusCode().value());
		
	}
	


}
