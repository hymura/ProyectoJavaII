package co.com.udem.registro.entities.factory;

import java.util.Arrays;

import co.com.udem.registro.dto.RegistroUsuarioDto;
import co.com.udem.registro.dto.TipoIdentificacionDto;
import co.com.udem.registro.entities.RegistroUsuario;

public final class RegistroUsuarioFactory {


	private RegistroUsuarioFactory() {
	
	}

	
	public  static RegistroUsuarioDto toModel(RegistroUsuario entity) {
		TipoIdentificacionDto tipoIdentificacionDto= TipoIdentificacionFactory.toModel(entity.getTipoIdentificacion());
		return new RegistroUsuarioDto(entity.getIdUsuario(), 
										entity.getNombres(),
										entity.getApellidos(),
										entity.getIdentificacion(),
										entity.getDireccion(),
										entity.getTelefono(), 
										entity.getEmail(), 
										entity.getPassword(),
										tipoIdentificacionDto);
		
	}
	
	 public static RegistroUsuario toEntity(RegistroUsuarioDto registroUsuarioDto ) {
		 
	        return RegistroUsuario.builder()
	                .idUsuario(registroUsuarioDto.getIdUsuario())
	                .nombres(registroUsuarioDto.getNombres())
	                .apellidos(registroUsuarioDto.getApellidos())
	                .identificacion(registroUsuarioDto.getIdentificacion())
	                .direccion(registroUsuarioDto.getDireccion())
	                .telefono(registroUsuarioDto.getTelefono())
	                .email(registroUsuarioDto.getEmail())
	                .password(registroUsuarioDto.getPassword())
	                .tipoIdentificacion(TipoIdentificacionFactory.toEntity(registroUsuarioDto.getTipoIdentificacionDto()))
	                .roles(Arrays.asList( "ROLE_USER"))
	                 .build();
	    }


}
