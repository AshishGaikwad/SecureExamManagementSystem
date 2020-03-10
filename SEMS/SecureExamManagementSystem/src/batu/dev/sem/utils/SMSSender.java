package batu.dev.sem.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;


public class SMSSender {


public static int sendSMS(String pMobile, String pBody) throws Exception{
	try {
	String baseUrl = "http://api.mVaayoo.com/mvaayooapi/MessageCompose";
  
  StringBuilder queryParam = new StringBuilder();
  queryParam
  .append("user=").append("devendrasuhasjoglekar@gmail.com:deva@0203")
  .append("&senderID=").append("BATUNI")
  .append("&receipientno=").append(""+pMobile)
  .append("&msgtxt=").append(""+URLEncoder.encode(pBody, "UTF-8"))
  .append("&state=").append("4");
    URL url = new URL(baseUrl+"?"+queryParam.toString());
    
    HttpURLConnection con =(HttpURLConnection) url.openConnection();
    System.out.print(url);
    return con.getResponseCode();
    
		
	} catch (Exception e) {
		e.printStackTrace();
	}
    
   
    
    return -1;
}


public static int getOTP() {
	return  new Random().nextInt(900000) + 100000;
	
}


  public static void main(String[] args) throws Exception {
  
   int res =sendSMS("7977407828","Hieee How are you?");
   
   System.out.print(res);
  }
}