package batu.dev.sem.bundles.examination.dao;

import com.instamojo.wrapper.model.Payment;
import com.instamojo.wrapper.model.PaymentOrder;

public interface PaymentDao {
	public boolean save(PaymentOrder  lPaymentOrder );
	public boolean update(PaymentOrder  lPaymentOrder );
	public PaymentOrder getByTransactionId(String pTransactionId);
}
