package co.com.core.services.financial.account;

import java.util.List;
import java.util.Map;

import co.com.core.dto.financial.account.PaymentDTO;

public interface IPaymentService {

	public List<PaymentDTO> getAll(); 

	public List<PaymentDTO> getAllFilter(Map<String, Object> filter); 

}
