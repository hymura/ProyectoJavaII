package co.com.udem.registro.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.udem.registro.dto.TipoIdentificacionDto;
import co.com.udem.registro.util.ConverRegistroUsuario;
import co.com.udem.registro.util.ConvertTipoIdentificacion;

@Configuration
public class BeanConfig {
	@Bean
	public ConvertTipoIdentificacion convertTipoIdentificacion() {
		return new ConvertTipoIdentificacion();
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	public ConverRegistroUsuario converRegistroUsuario() {
		return new ConverRegistroUsuario();
		
	}
		
	@Bean
	public TipoIdentificacionDto tipoIdentificacionDto() {
		return new TipoIdentificacionDto();
	}
	


}
