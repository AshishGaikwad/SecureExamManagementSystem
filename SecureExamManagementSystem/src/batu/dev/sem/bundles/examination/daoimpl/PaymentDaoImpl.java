package batu.dev.sem.bundles.examination.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.instamojo.wrapper.model.PaymentOrder;

import batu.dev.sem.bundles.examination.dao.PaymentDao;
import batu.dev.sem.bundles.examination.entity.ExaminationEntity;
import batu.dev.sem.utils.MySQLConnector;
import batu.dev.sem.utils.Payment;

public class PaymentDaoImpl implements PaymentDao {

	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";
	private Gson gson =  new Gson();
	
	public static void main(String[] args) {
		//INSERT INTO `examinationportal`.`instamojo_fee_payment_order` (`transactionId`,`id`,`status`,`currency`,`amount`,`payments`) VALUES(?,?,?,?,?,?)

		
//		System.out.println(""+Payment.getPaymentDetails("BATU-9-1583162345150").getPayments().get(0).getStatus());
		
//		System.out.println(new PaymentDaoImpl().getByTransactionId("BATU-9-1583162345150").getPayments().get(0));
	}

	@Override
	public boolean save(PaymentOrder lPaymentOrder) {
		try {
				lQuery = "INSERT INTO `examinationportal`.`payment_order` (`transactionId`,`id`,`status`,`currency`,`amount`,`payments`) VALUES(?,?,?,?,?,?)";
				lConnection = MySQLConnector.getConnection();

				lConnection.setAutoCommit(false);
				lPreparedStatement = lConnection.prepareStatement(lQuery);
				lPreparedStatement.setString(1, lPaymentOrder.getTransactionId());
				lPreparedStatement.setString(2, lPaymentOrder.getId());
				lPreparedStatement.setString(3, lPaymentOrder.getStatus());
				lPreparedStatement.setString(4, lPaymentOrder.getCurrency());
				lPreparedStatement.setDouble(5, lPaymentOrder.getAmount());
				lPreparedStatement.setString(6, lPaymentOrder.getPayments().toString());

				
				int res = lPreparedStatement.executeUpdate();
				lConnection.commit();

				if (res > 0)
					return true;
				else
					return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			if (lConnection != null) {
				try {
					lConnection.rollback();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			return false;
		}
	}

	@Override
	public boolean update(PaymentOrder lPaymentOrder) {
		try {
			lQuery = "UPDATE `examinationportal`.`payment_order`SET`transactionId` =?,`id` =?,`status` = ?,`currency` = ?,`amount` = ?,`payments` = ? WHERE `transactionId` =?;;";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setString(1, lPaymentOrder.getTransactionId());
			lPreparedStatement.setString(2, lPaymentOrder.getId());
			lPreparedStatement.setString(3, lPaymentOrder.getStatus());
			lPreparedStatement.setString(4, lPaymentOrder.getCurrency());
			lPreparedStatement.setDouble(5, lPaymentOrder.getAmount());
			lPreparedStatement.setString(6, lPaymentOrder.getPayments().toString());
			lPreparedStatement.setString(7, lPaymentOrder.getTransactionId());
			
			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			if (res > 0)
				return true;
			else
				return false;
		
	} catch (Exception e) {
		e.printStackTrace();
		if (lConnection != null) {
			try {
				lConnection.rollback();
				lPreparedStatement.close();
				lConnection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return false;
	}
	}

	@Override
	public PaymentOrder getByTransactionId(String pTransactionId) {
		try {
			PaymentOrder lPaymentOrder = null;
			lQuery = "SELECT "
					+ "`payment_order`.`transactionId`,"
					+ "`payment_order`.`id`,"
					+ "`payment_order`.`status`,"
					+ "`payment_order`.`currency`,"
					+ "`payment_order`.`amount`,"
					+ "`payment_order`.`payments` "
					+ "FROM `examinationportal`.`payment_order` WHERE `payment_order`.`transactionId` = ?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setString(1, pTransactionId);
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				lPaymentOrder = new PaymentOrder();
				lPaymentOrder.setTransactionId(lResultSet.getString(1));
				lPaymentOrder.setId(lResultSet.getString(2));
				lPaymentOrder.setStatus(lResultSet.getString(3));
				lPaymentOrder.setCurrency(lResultSet.getString(4));
				lPaymentOrder.setAmount(lResultSet.getDouble(5));
				lPaymentOrder.setPayments(gson.fromJson(lResultSet.getString(6).replace("Payment", ""), List.class));
				
			} else {
				return null;
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lPaymentOrder;

		} catch (Exception e) {

			e.printStackTrace();
			if (lConnection != null) {
				try {
					lResultSet.close();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			return null;
		}
	}

}
