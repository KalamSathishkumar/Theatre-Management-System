package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.PaymentDao;
import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.exception.PaymentIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class PaymentService {
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ResponseStructure<Payment> responseStructure;
	
	@Autowired
    ResponseStructureList<Payment> responseStructureList;
	
	public ResponseStructure<Payment> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succesfully data is inserted into DB");
		responseStructure.setData(paymentDao.savePayment(payment));
	   return responseStructure;
	}
	
	public ResponseStructure<Payment> updatePaymentById(int oldPaymentId, Payment newPayment) {
		  Payment payment=  paymentDao.fetchByPaymentId(oldPaymentId);
		  if(payment !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is updated in DB");
		responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
	   return responseStructure;
		  }else {
			  throw new PaymentIdNotFound();
		  }

	}
	
	public ResponseStructure<Payment> fetchByPaymentId(int paymentId) {
		  Payment payment=  paymentDao.fetchByPaymentId(paymentId);
		  if(payment !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("succesfully data is fetched from DB");
		responseStructure.setData(paymentDao.fetchByPaymentId(paymentId));
	   return responseStructure;
		  }else {
			  throw new PaymentIdNotFound();
		  }
	}
	
	public ResponseStructureList<Payment> fetchAllPayment(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(paymentDao.fetchAllPayment());
		return responseStructureList;
	}
	
	public ResponseStructure<Payment> deletePaymentById(int paymentId) {
		  Payment payment=  paymentDao.fetchByPaymentId(paymentId);
		  if(payment !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is deleted into DB");
		responseStructure.setData(paymentDao.deletePaymentById(paymentId));
	   return responseStructure;
		  }else {
			  throw new PaymentIdNotFound();
		  }
	
	}

}
