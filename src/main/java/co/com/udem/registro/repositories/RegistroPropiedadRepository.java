package co.com.udem.registro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.udem.registro.entities.RegistroPropieadad;

public interface RegistroPropiedadRepository extends CrudRepository<RegistroPropieadad, Long> {
	
	
	@Query(
			  value = "SELECT * FROM registro_propiedad p "+
	                   "where 1=1 "
	                   + "and exists(select 'x' from registro_usuario u "
	                   + " where p.id_usuario=u.id_usuario "
	                   + "and u.identificacion =:identificacion) "
	                   +"and (:precio is null or p.valor >= :precio ) "
	                   +"and (:numeroHabitaciones is null or p.numero_habitaciones = :numeroHabitaciones ) "
	                   +"and (:area is null or p.area =:area ) ",
			  nativeQuery = true)
		
    public List<RegistroPropieadad> consultarPropiedadesUsuario(@Param("identificacion") String identificacion , @Param("precio")  Double precio, @Param("numeroHabitaciones") Integer numeroHabitaciones,@Param("area") String area);

}
