package co.com.udem.registro.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.udem.registro.entities.RegistroUsuario;

public interface RegistroUsuarioRepository extends CrudRepository<RegistroUsuario, Long> {
	
	
	@Query("Select u from RegistroUsuario u where u.identificacion =:identificacion")
	Optional<RegistroUsuario> findByUsername(@Param("identificacion")  String identificacion);
	//Optional<RegistroUsuario> findByUsername(String identificacion);

}
