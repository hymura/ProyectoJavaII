package co.com.udem.registro.entities.factory;
import co.com.udem.registro.dto.TipoIdentificacionDto;
import co.com.udem.registro.entities.TipoIdentificacion;

public final class TipoIdentificacionFactory {

	private TipoIdentificacionFactory() {
		
	}
	
	public static TipoIdentificacionDto toModel(TipoIdentificacion entity) {
		return new TipoIdentificacionDto(entity.getIdTipoIdent(),entity.getTipo(),entity.getDescripcion());	
	}
	
    public static TipoIdentificacion toEntity(TipoIdentificacionDto tipoIdentificacionDto) {
        return TipoIdentificacion.builder()
        		.idTipoIdent(tipoIdentificacionDto.getIdTipoIdent())
        		.tipo(tipoIdentificacionDto.getTipo())
        		.descripcion(tipoIdentificacionDto.getDescripcion())
                .build();
    }
	
	
	

}
