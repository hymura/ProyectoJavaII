package co.com.udem.registro.controllers;

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
import co.com.udem.registro.dto.RegistroUsuarioDto;
import co.com.udem.registro.dto.TipoIdentificacionDto;
import co.com.udem.registro.entities.RegistroUsuario;
import co.com.udem.registro.util.ConvertTipoIdentificacion;
import co.com.udem.registro.util.ManejoExcepcion;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProyectoJavaIiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistroUsuarioControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ConvertTipoIdentificacion convertTipoIdentificacion;
	

	@LocalServerPort
	private int port;
	
	private AutenticationRequestDTO autenticationRequestDTO = new AutenticationRequestDTO();
	
    private String token;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	private TipoIdentificacionDto tipoIdentificacionDto;
	private RegistroUsuarioDto registroUsuarioDto;

	@Before
	public void setup() throws ManejoExcepcion {
						

		long l = 8;
		long idusuario = 20;
		tipoIdentificacionDto = new TipoIdentificacionDto(l, "CC", "Cédula de Ciudadanía");

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
		//	adicionarUsuario(registroUsuarioDto);
		
		autenticationRequestDTO.setUsername(registroUsuarioDto.getIdentificacion());
		autenticationRequestDTO.setPassword(registroUsuarioDto.getPassword());

		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/auth/signin", registroUsuarioDto, String.class);
		System.out.println("postResponse.getBody "+postResponse.getBody());
		
		Gson g = new Gson();		
		AutenticationResponseDTO autenticationResponseDTO = g.fromJson(postResponse.getBody(), AutenticationResponseDTO.class);
		System.out.println("autenticationResponseDTO user: "+autenticationResponseDTO.getUsername());
		System.out.println("autenticationResponseDTO token: "+autenticationResponseDTO.getToken());
		token = autenticationResponseDTO.getToken();


	}

	

	
	@Test
	public void testCreateTipoIdentificacion() throws ManejoExcepcion {
		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/tipoIdentificacion/adicionar",
				tipoIdentificacionDto, String.class);
		 System.out.println("postResponse tipo "+postResponse.getBody());
		assertEquals(200, postResponse.getStatusCode().value());
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
	public void testGetRegistroUsuario() {
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer "+token);
		
		System.out.println("token: "+token);
		 HttpEntity<RegistroUsuarioDto> entity = new HttpEntity<>(headers);
		 
		ResponseEntity<String> response =restTemplate.postForEntity(getRootUrl() + "/registroUsuario/adicionar", registroUsuarioDto, String.class);
		System.out.println("response usuario: "+response.getBody());
		assertEquals(200, response.getStatusCode().value());

	}
	
	
	
/*	
	@Test
	public void adicionarUsuarioTest() {
		
		
		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/auth/signin", autenticationRequestDTO, String.class);
		token=postResponse.getBody();
		adicionarUsuario(registroUsuarioDto);
		 System.out.println("Nuevo Token "+token);
		 
		 Gson g = new Gson();
		AutenticationResponseDTO autenticationResponseDTO = g.fromJson(postResponse.getBody(), AutenticationResponseDTO.class);
		token = autenticationResponseDTO.getToken();
		
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        System.out.println("El token es: "+this.token);
	        headers.set("Authorization", "Bearer "+this.token);
	        HttpEntity<RegistroUsuarioDto> entity = new HttpEntity<RegistroUsuarioDto>(registroUsuarioDto, headers);
	        ResponseEntity<String> postResponse1 = restTemplate.exchange(getRootUrl() + "/registroUsuario/adicionar", HttpMethod.POST, entity, String.class);      
	        //ResponseEntity<ClubFutbolDTO> postResponse = restTemplate.postForEntity(getRootUrl() + "/clubes/adicionarClub", clubFutbolDTO, ClubFutbolDTO.class);
	        assertEquals(200, postResponse1.getStatusCode().value());
	        //assertNotNull(postResponse);
	        //assertNotNull(postResponse.getBody());

	}
*/


	@Test
	public void testUpdateUsuario() {
		
		int id = 1;
		RegistroUsuario registroUsuario = restTemplate.getForObject(getRootUrl() + "/registroUsuario/" + id,
				RegistroUsuario.class);
		registroUsuario.setNombres(registroUsuarioDto.getNombres());
		registroUsuario.setApellidos(registroUsuarioDto.getApellidos());
		registroUsuario.setDireccion(registroUsuarioDto.getDireccion());
		registroUsuario.setEmail(registroUsuarioDto.getEmail());
		registroUsuario.setIdentificacion(registroUsuarioDto.getIdentificacion());
		registroUsuario.setPassword(registroUsuarioDto.getPassword());
		registroUsuario.setTelefono(registroUsuarioDto.getTelefono());
		registroUsuario.setTipoIdentificacion(convertTipoIdentificacion.convertToEntity(tipoIdentificacionDto));

		restTemplate.put(getRootUrl() + "/usuarios/" + id, registroUsuario);
		RegistroUsuario updatedUsuario = restTemplate.getForObject(getRootUrl() + "/registroUsuario/" + id,
				RegistroUsuario.class);
		assertNotNull(updatedUsuario);
	}
	
	private void adicionarUsuario(RegistroUsuarioDto registroUsuarioDto2) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/registroUsuario/adicionar", registroUsuarioDto2, String.class);
        postResponse.getBody();    
        System.out.println("Crear usuario: "+postResponse.getBody());
    }

}
