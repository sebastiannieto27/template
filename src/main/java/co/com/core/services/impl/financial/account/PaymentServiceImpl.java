package co.com.core.services.impl.financial.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.dao.financial.account.PaymentDAO;
import co.com.core.dto.financial.account.PaymentDTO;
import co.com.core.services.financial.account.IPaymentService;

public class PaymentServiceImpl implements IPaymentService {

	private static final Logger logger = Logger.getLogger(PaymentServiceImpl.class);
	PaymentDAO paymentDAO;
	
	@Override
	public List<PaymentDTO> getAll() {
		List<PaymentDTO> ageList = new ArrayList<PaymentDTO>();
		/*List<Payment> entityList = accountAgeDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(Payment Payment : entityList) {
				ageList.add(PaymentUtil.getDtoFromEntity(Payment));
			}
		}*/
		return ageList;
	}

	@Override
	public List<PaymentDTO> getAllFilter(Map<String, Object> filter) {
		List<PaymentDTO> dtoList = new ArrayList<PaymentDTO>();
		
		PaymentDTO entry1 = new PaymentDTO();
		entry1.setPaymentDate(new Date());
		entry1.setPaymentNumber("332-7");
		entry1.setPaymentValue(387650000);
		entry1.setPaymentType("RECIBO DE CAJA");
		entry1.setDescription("Descuento desposte bovino");
		
		PaymentDTO entry2 = new PaymentDTO();
		entry2.setPaymentDate(new Date());
		entry2.setPaymentNumber("335-3");
		entry2.setPaymentValue(47650000);
		entry2.setPaymentType("RECIBO DE CAJA");
		entry2.setDescription("Descuento procesamiento carne");
		
		PaymentDTO entry3 = new PaymentDTO();
		entry3.setPaymentDate(new Date());
		entry3.setPaymentNumber("932-1");
		entry3.setPaymentValue(87650000);
		entry3.setPaymentType("CRUCE");
		entry3.setDescription("Descuento cuartos frios");
		
		PaymentDTO entry4 = new PaymentDTO();
		entry4.setPaymentDate(new Date());
		entry4.setPaymentNumber("232-0");
		entry4.setPaymentValue(187650000);
		entry4.setPaymentType("NOTA CREDITO");
		entry4.setDescription("Descuento distribución");
		
		dtoList.add(entry1);
		dtoList.add(entry2);
		dtoList.add(entry3);
		dtoList.add(entry4);
		
		return dtoList;
	}
	
	public PaymentDAO getPaymentDAO() {
		return paymentDAO;
	}

	public void setPaymentDAO(PaymentDAO accountAgeDAO) {
		this.paymentDAO = accountAgeDAO;
	}
}
