package co.com.core.services;

import java.util.List;

import co.com.core.dto.PriorityDTO;

public interface IPriorityService {

	public List<PriorityDTO> getAll(); 
	
	public void create(PriorityDTO dto);
	
	public void delete(PriorityDTO dto);
	
	public void update(PriorityDTO dto);
	
}
