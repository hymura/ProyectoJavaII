package co.com.udem.registro;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.udem.registro.dto.TipoIdentificacionDto;
import co.com.udem.registro.util.ConverRegistroUsuario;
import co.com.udem.registro.util.ConvertTipoIdentificacion;

@SpringBootApplication
public class ProyectoJavaIiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoJavaIiApplication.class, args);
	}
	
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
