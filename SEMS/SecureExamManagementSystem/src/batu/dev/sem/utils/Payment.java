package batu.dev.sem.utils;

import org.json.JSONObject;

import com.instamojo.wrapper.api.ApiContext;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.HTTPException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;

public class Payment {
	
	public static PaymentOrder createPayment(PaymentOrder order)
	{
		
		ApiContext context = ApiContext.create(Util.getProperty("Config", "PAYMENT_GATEWAY_CLIENT_ID"), Util.getProperty("Config", "PAYMENT_GATEWAY_CLIENT_SECRET"), ApiContext.Mode.TEST);
		Instamojo api = new InstamojoImpl(context);
		
		try {
		    PaymentOrderResponse paymentOrderResponse = api.createPaymentOrder(order);
		    System.out.println(paymentOrderResponse.getPaymentOrder().getStatus());
		    return getPaymentDetails(order.getTransactionId());
		} catch (HTTPException e) {
		    System.out.println(e.getStatusCode());
		    System.out.println(e.getMessage());
		    System.out.println(e.getJsonPayload());

		} catch (ConnectionException e) {
		    System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	
	public static PaymentOrder getPaymentDetails(String pTransactionId)
	{
		ApiContext context = ApiContext.create(Util.getProperty("Config", "PAYMENT_GATEWAY_CLIENT_ID"), Util.getProperty("Config", "PAYMENT_GATEWAY_CLIENT_SECRET"), ApiContext.Mode.TEST);
		Instamojo api = new InstamojoImpl(context);
		try {
		    PaymentOrder paymentOrder = api.getPaymentOrderByTransactionId(pTransactionId);
		    return paymentOrder;
		} catch (HTTPException e) {
		    System.out.println(e.getStatusCode());
		    System.out.println(e.getMessage());
		    System.out.println(e.getJsonPayload());

		} catch (ConnectionException e) {
		    System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) {
		
//		PaymentOrder order = new PaymentOrder();
//		order.setName("AShish Gaikwad");
//		order.setEmail("ashishgaikwad1997@gmail.com");
//		order.setPhone("8976834278");
//		order.setCurrency("INR");
//		order.setAmount(new Double("1000"));
//		order.setDescription("");
//		order.setRedirectUrl(Util.getProperty("Config", "CURRENT_HOSTNAME")+Util.getProperty("Config", "CURRENT_BASEPACKAGE")+Util.getProperty("Config", "PAYMENT_GATEWAY_REDIRECT"));
//		order.setWebhookUrl(Util.getProperty("Config", "CURRENT_HOSTNAME")+Util.getProperty("Config", "CURRENT_BASEPACKAGE")+Util.getProperty("Config", "PAYMENT_GATEWAY_WEBHOOK"));
//		order.setTransactionId("BATU-"+System.currentTimeMillis());
//		System.out.println(createPayment(order));

		
//		System.out.println(getPaymentDetails("BATU-1583052270546"));
		
		
		
		
	}
	
//	public static void main(String[] args) {
//		ApiContext context = ApiContext.create(Util.getProperty("Config", "PAYMENT_GATEWAY_CLIENT_ID"), Util.getProperty("Config", "PAYMENT_GATEWAY_CLIENT_SECRET"), ApiContext.Mode.TEST);
//		Instamojo api = new InstamojoImpl(context);
//
//		/*
//		 * Create a new payment order
//		 */
//		PaymentOrder order = new PaymentOrder();
//		order.setName("AShish Gaikwad");
//		order.setEmail("ashishgaikwad1997@gmail.com");
//		order.setPhone("8976834278");
//		order.setCurrency("INR");
//		order.setAmount(new Double("100"));
//		order.setDescription("This is a test transaction.");
//		order.setRedirectUrl(Util.getProperty("Config", "CURRENT_HOSTNAME")+Util.getProperty("Config", "CURRENT_BASEPACKAGE")+Util.getProperty("Config", "PAYMENT_GATEWAY_REDIRECT"));
//		order.setWebhookUrl(Util.getProperty("Config", "CURRENT_HOSTNAME")+Util.getProperty("Config", "CURRENT_BASEPACKAGE")+Util.getProperty("Config", "PAYMENT_GATEWAY_WEBHOOK"));
//		order.setTransactionId("2000");
//
//		try {
//		    PaymentOrderResponse paymentOrderResponse = api.createPaymentOrder(order);
//		    System.out.println(paymentOrderResponse.getPaymentOrder().getStatus());
//
//		} catch (HTTPException e) {
//		    System.out.println(e.getStatusCode());
//		    System.out.println(e.getMessage());
//		    System.out.println(e.getJsonPayload());
//
//		} catch (ConnectionException e) {
//		    System.out.println(e.getMessage());
//		}
//		
//		
//		
//		try {
//		    PaymentOrder paymentOrder = api.getPaymentOrderByTransactionId("2000");
//		    System.out.println(paymentOrder.toString());
//		    System.out.println(paymentOrder.getStatus());
//
//		} catch (HTTPException e) {
//		    System.out.println(e.getStatusCode());
//		    System.out.println(e.getMessage());
//		    System.out.println(e.getJsonPayload());
//
//		} catch (ConnectionException e) {
//		    System.out.println(e.getMessage());
//		}
//	}
}
