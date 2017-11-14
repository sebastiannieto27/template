package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.MediaNacionalArea;
import co.com.core.dto.psaber.MediaNacionalAreaDTO;

public class MediaNacionalAreaUtil {

	public static MediaNacionalAreaDTO getDtoFromEntity(MediaNacionalArea entity) {
		MediaNacionalAreaDTO dto = new MediaNacionalAreaDTO();
		dto.setMediaNacionalAreaId(entity.getMediaNacionalAreaId());
		dto.setArchivoPruebaId(entity.getArchivoPruebaId());
		dto.setAreaId(entity.getAreaId());
		dto.setValor(entity.getValor());
		return dto;
	}
	
	public static MediaNacionalArea getEntityFromDto(MediaNacionalAreaDTO dto) {
		MediaNacionalArea entity = new MediaNacionalArea();
		entity.setMediaNacionalAreaId(dto.getMediaNacionalAreaId());
		entity.setArchivoPruebaId(dto.getArchivoPruebaId());
		entity.setAreaId(dto.getAreaId());
		entity.setValor(dto.getValor());
		return entity;
	}
}
