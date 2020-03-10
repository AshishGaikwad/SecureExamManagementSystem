package batu.dev.sem.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CacheLoader {
	private static CacheLoader lCacheLoader = null;	
	private static Map<String, String> lUserMap = null;
	private static Map<String, Long> lLastRequest = null;
	private static Map<Long, String> lVisitorType = null;
	private static Map<Long, String> lDocType = null;
	private ResourceBundle lVisitorsBundle= ResourceBundle.getBundle("batu.dev.sem.resources.visitors");
	
	private CacheLoader() {
		lUserMap = new HashMap<String, String>();
		lLastRequest = new HashMap<String, Long>();
		lVisitorType = new HashMap<Long, String>();
		lDocType = new HashMap<Long, String>();
		loadOnStart();
	}
	static {
		lCacheLoader = new CacheLoader();
	}
	public static CacheLoader getInstance()
	{
		return lCacheLoader;
	}
	
	public Map<String ,String> userMap()
	{
		return lUserMap;
	}
	
	public Map<Long ,String> visitorTypeMap()
	{
		return lVisitorType;
	}
	
	public Map<Long ,String> docTypeMap()
	{
		return lDocType;
	}
	
	public Map<String ,Long> lastRequest()
	{
		return lLastRequest;
	}
	
	
	public void loadOnStart()
	{
		
		try {
			System.out.println(this.getClass().getName()+"--Loading Visitors from properties file (visitors.properties) **************");
			String[] lVisitorsTypeRange = lVisitorsBundle.getString("visitors.type").split("~");
			for (int i = Integer.parseInt(lVisitorsTypeRange[0]); i < Integer.parseInt(lVisitorsTypeRange[1]); i++) {
				visitorTypeMap().put((long) i, lVisitorsBundle.getString(""+i));
			}
			
			
			System.out.println(this.getClass().getName()+"--Loading Document Type from properties file (visitors.properties)************");
			String[] lDocumentTypeRange = lVisitorsBundle.getString("document.type").split("~");
			for (int i = Integer.parseInt(lDocumentTypeRange[0]); i < Integer.parseInt(lDocumentTypeRange[1]); i++) {
				docTypeMap().put((long) i, lVisitorsBundle.getString(""+i));
			}
		} catch (Exception e) {
			System.out.println("Exception while loading on startup");
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
}
