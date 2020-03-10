
package batu.dev.sem.utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.daoimpl.ScreenDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.ScreenEntity;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;

public class Util {
	// Resource Bundle for reading data from properties file
	static ResourceBundle lResourceBundle = null;
	private static Gson gson = new Gson();

	public static String getProperty(String pPropertyName, String pProperyKey) {
		try {
			lResourceBundle = ResourceBundle.getBundle("batu.dev.sem.resources." + pPropertyName);
			return lResourceBundle.getString(pProperyKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getProperty(String pPropertyName, int pProperyKey) {
		try {
			lResourceBundle = ResourceBundle.getBundle("batu.dev.sem.resources." + pPropertyName);
			return lResourceBundle.getString("" + pProperyKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void loadPage(HttpServletRequest lRequest, HttpServletResponse lResponse, String lPageName) {
		try {
			if (!lResponse.isCommitted())
				lRequest.getRequestDispatcher("/view/" + lPageName).forward(lRequest, lResponse);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	StringBuffer lMenuBuffer = new StringBuffer();

	public static String createMenus(HttpServletRequest lRequest) {
		ScreenDaoImpl lScreenDaoImpl = new ScreenDaoImpl();
		HttpSession lSession = lRequest.getSession();
		UserEntity lEntity = (UserEntity) lSession.getAttribute("USER_ENTITY");
		List<ScreenEntity> lList = lScreenDaoImpl.getScreenForUser(lEntity.getUserId());

		System.out.println("lLisst === " + lList);

		return menuBuilder(lList);

	}

	public static String menuBuilder(List<ScreenEntity> lList) {
		StringBuilder lMenuBuffer = new StringBuilder();
		List<ScreenEntity> lScreensList = lList;
//----------FIRST LEVEL MENU
		lMenuBuffer.append("<ul class=\"nav nav-main\">");
		for (int i = 0; i < lScreensList.size(); i++) {
			if (lScreensList.get(i).getScreenParentId() == 0) {
				if ((lScreensList.get(i).getScreenUrl()).equals("#")) {
					lMenuBuffer.append("<li class=\"nav-parent\">");
					lMenuBuffer.append("<a>");
					lMenuBuffer.append("<i class=\"fa " + lScreensList.get(i).getScreenMenuIcon()
							+ "\" aria-hidden=\"true\"></i>");
					lMenuBuffer.append("<span>" + lScreensList.get(i).getScreenName() + "</span>");
					lMenuBuffer.append("</a>");

					lMenuBuffer.append("<ul class=\"nav nav-children\">");
//------------------------SECOND LEVEL MENU START-----------------------------------------------------------------------------		-				
					for (int j = 0; j < lScreensList.size(); j++) {

						if (lScreensList.get(j).getScreenParentId() == lScreensList.get(i).getScreenId()) {
							if ((lScreensList.get(j).getScreenUrl()).equals("#")) {
								lMenuBuffer.append("<li class=\"nav-parent\">");
								lMenuBuffer.append("<a>");
//										lMenuBuffer.append("<i class=\"fa "+lScreensList.get(j).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
								lMenuBuffer.append("<span>" + lScreensList.get(j).getScreenName() + "</span>");
								lMenuBuffer.append("</a>");

								lMenuBuffer.append("<ul class=\"nav nav-children\">");
//------------------------THIRD LEVEL MENU START-----------------------------------------------------------------------------	
								for (int k = 0; k < lScreensList.size(); k++) {

									if (lScreensList.get(k).getScreenParentId() == lScreensList.get(j).getScreenId()) {
										if ((lScreensList.get(k).getScreenUrl()).equals("#")) {
											lMenuBuffer.append("<li class=\"nav-parent\">");
											lMenuBuffer.append("<a>");
//														lMenuBuffer.append("<i class=\"fa "+lScreensList.get(j).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
											lMenuBuffer
													.append("<span>" + lScreensList.get(k).getScreenName() + "</span>");
											lMenuBuffer.append("</a>");

											lMenuBuffer.append("<ul class=\"nav nav-children\">");
											// ------------------------FOURTH LEVEL MENU
											// START-----------------------------------------------------------------------------

											for (int l = 0; l < lScreensList.size(); l++) {

												if (lScreensList.get(l).getScreenParentId() == lScreensList.get(k)
														.getScreenId()) {
													if ((lScreensList.get(l).getScreenUrl()).equals("#")) {
														lMenuBuffer.append("<li class=\"nav-parent\">");
														lMenuBuffer.append("<a>");
//																		lMenuBuffer.append("<i class=\"fa "+lScreensList.get(j).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
														lMenuBuffer.append("<span>"
																+ lScreensList.get(l).getScreenName() + "</span>");
														lMenuBuffer.append("</a>");

														lMenuBuffer.append("<ul class=\"nav nav-children\">");
														// ------------------------FIFTH LEVEL MENU
														// START-----------------------------------------------------------------------------
														for (int m = 0; m < lScreensList.size(); m++) {

															if (lScreensList.get(m).getScreenParentId() == lScreensList
																	.get(l).getScreenId()) {
																if ((lScreensList.get(m).getScreenUrl()).equals("#")) {
																	lMenuBuffer.append("<li class=\"nav-parent\">");
																	lMenuBuffer.append("<a>");
//																						lMenuBuffer.append("<i class=\"fa "+lScreensList.get(j).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
																	lMenuBuffer.append("<span>"
																			+ lScreensList.get(m).getScreenName()
																			+ "</span>");
																	lMenuBuffer.append("</a>");

																	lMenuBuffer
																			.append("<ul class=\"nav nav-children\">");
																	// ------------------------FIFTH LEVEL MENU
																	// START-----------------------------------------------------------------------------

																	// ------------------------FIFTH LEVEL MENU
																	// START-----------------------------------------------------------------------------
																	lMenuBuffer.append("</ul>");
																	lMenuBuffer.append("</li>");
																} else {
																	lMenuBuffer.append("<li>"
																			+ "<a href=\"#\"   onclick=\"setUpUrl('"
																			+ Base64.getEncoder()
																					.encodeToString(gson
																							.toJson(lScreensList.get(m))
																							.getBytes())
																					.toString()
																			+ "')\">" + "	<span>"
																			+ lScreensList.get(m).getScreenName()
																			+ "</span>" + "</a>" + "</li>");
																}
															}
														}
														// ------------------------FIFTH LEVEL MENU
														// START-----------------------------------------------------------------------------
														lMenuBuffer.append("</ul>");
														lMenuBuffer.append("</li>");
													} else {
														lMenuBuffer.append("<li>"
																+ "<a href=\"#\"   onclick=\"setUpUrl('"
																+ Base64.getEncoder()
																		.encodeToString(gson.toJson(lScreensList.get(l))
																				.getBytes())
																		.toString()
																+ "')\">" + "	<span>"
																+ lScreensList.get(l).getScreenName() + "</span>"
																+ "</a>" + "</li>");
													}
												}
											}

											// ------------------------FOURTH LEVEL MENU
											// START-----------------------------------------------------------------------------
											lMenuBuffer.append("</ul>");
											lMenuBuffer.append("</li>");
										} else {
											lMenuBuffer.append("<li>" + "<a href=\"#\"   onclick=\"setUpUrl('"
													+ Base64.getEncoder()
															.encodeToString(gson.toJson(lScreensList.get(k)).getBytes())
															.toString()
													+ "')\">" + "	<span>" + lScreensList.get(k).getScreenName()
													+ "</span>" + "</a>" + "</li>");
										}
									}
								}
//------------------------THIRD LEVEL MENU START-----------------------------------------------------------------------------	
								lMenuBuffer.append("</ul>");
								lMenuBuffer.append("</li>");
							} else {
								lMenuBuffer.append("<li>" + "<a href=\"#\"  onclick=\"setUpUrl('"
										+ Base64.getEncoder()
												.encodeToString(gson.toJson(lScreensList.get(j)).getBytes()).toString()
										+ "')\">" + "	<span>" + lScreensList.get(j).getScreenName() + "</span>"
										+ "</a>" + "</li>");
							}
						}
					}

//-------------=SECOND LEVEL MENU END-------------------------------------------------------------------------------------						
					lMenuBuffer.append("</ul>");
					lMenuBuffer.append("</li>");
				} else {
					lMenuBuffer
							.append("<li>" + "<a href=\"#\"  onclick=\"setUpUrl('"
									+ Base64.getEncoder().encodeToString(gson.toJson(lScreensList.get(i)).getBytes())
											.toString()
									+ "')\">" + "	<i class=\"fa " + lScreensList.get(i).getScreenMenuIcon()
									+ "\" aria-hidden=\"true\"></i>" + "	<span>"
									+ lScreensList.get(i).getScreenName() + "</span>" + "</a>" + "</li>");
				}
			}
		}
		lMenuBuffer.append("</ul>");

		return lMenuBuffer.toString();
	}

	public static String[] getAuth(String b64String) {
		return new String(Base64.getDecoder().decode(b64String)).split("\\:");
	}

	public static void logout(HttpServletRequest request, String pUserEmail) {
		HttpSession lHttpSession = request.getSession();
		CacheLoader.getInstance().userMap().remove(pUserEmail);
		CacheLoader.getInstance().lastRequest().remove(pUserEmail);
		lHttpSession.invalidate();

		request.getRequestDispatcher("/");
	}

	public static void logout(HttpServletRequest request, HttpServletResponse response, String pUserEmail)
			throws IOException {
		HttpSession lHttpSession = request.getSession();
		CacheLoader.getInstance().userMap().remove(pUserEmail);
		CacheLoader.getInstance().lastRequest().remove(pUserEmail);
		lHttpSession.invalidate();
		response.sendRedirect(request.getContextPath() + "");

//		request.getRequestDispatcher("/");
	}

	public static boolean isNull(String pValue) {
		if (pValue == null)
			return true;
		else if (pValue.equalsIgnoreCase(""))
			return true;
		else
			return false;
	}

	public static String nofity(String pTitle, String pBody, String pType) {
		return new JSONObject().put("title", pTitle).put("text", pBody).put("type", pType).toString();
	}

	public static String nofity(String pBody, String pType) {
		return new JSONObject().put("title", "Response From Server ").put("text", pBody).put("type", pType).toString();
	}

	public static String sqlDate(String pDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy"); // your template here
		java.util.Date dateStr = null;
		try {
			dateStr = formatter.parse(pDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

		return dateDB.toString();
	}

	public static String YmdTodmy(String pDate) {
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-M-d"); // your template here
		Date date = null;
		try {
			date = parser.parse(pDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		return formatter.format(date);
	}

	public String requestBody(HttpServletRequest request) {
		try {
			return request.getReader().lines().collect(Collectors.joining());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String uploadFile(HttpServletRequest request, HttpServletResponse response) {
		String uploadFilePath = Util.getProperty("Config", "fileUploadLocation");
		String pFileName = "BATU_" + System.currentTimeMillis();
		String file = uploadFilePath + pFileName;
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> fileItems = upload.parseRequest(request);

			for (FileItem item : fileItems) {

				System.out.println("item.getName() " + item.getName());
				System.out.println("item.getName() " + item.getFieldName());
				String fileData[] = item.getName().split("\\.");
				file = file + "." + fileData[fileData.length - 1];
				item.write(new File(file));

			}

		} catch (Exception e) {
			e.printStackTrace();
			file = "-1";
		}
		return file;
	}

	public static String uploadFile(List<FileItem> fileItems) {
		String uploadFilePath = Util.getProperty("Config", "fileUploadLocation");
		String pFileName = "BATU_" + System.currentTimeMillis();
//		String file = uploadFilePath + pFileName;

		String pSendName = pFileName;

		try {
			for (FileItem item : fileItems) {
				String fileData[] = item.getName().split("\\.");
				pSendName = pSendName + "." + fileData[fileData.length - 1];
				item.write(new File(uploadFilePath + pSendName));
			}

		} catch (Exception e) {
			e.printStackTrace();
			pSendName = "-1";
		}
		return pSendName;
	}
	
	
	public static String uploadFile(List<FileItem> fileItems, String pUploadLocationProperty) {
		String uploadFilePath = Util.getProperty("Config", pUploadLocationProperty);
		String pSendName ="";
		StringBuilder uploadedDoc = new StringBuilder();
		try {
			for (FileItem item : fileItems) {
				String pFileName = "BATU_" + System.currentTimeMillis();
				pSendName= pFileName;
				String fileData[] = item.getName().split("\\.");
				pSendName = pSendName + "." + fileData[fileData.length - 1];
				item.write(new File(uploadFilePath + pSendName));
				uploadedDoc.append(","+pSendName);
			}

			
			pSendName = uploadedDoc.toString();
		} catch (Exception e) {
			e.printStackTrace();
			pSendName = "-1";
		}
		return pSendName;
	}


	public static MultipartData getMultipartFromParam(HttpServletRequest request, HttpServletResponse response) {
		MultipartData lMultipartData = new MultipartData();
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/plain");
			List<FileItem> fileItems = upload.parseRequest(request);
			Map<String, String> formData = new HashMap<String, String>();
			List<FileItem> fileData = new ArrayList<FileItem>();

			for (FileItem item : fileItems) {
				if (item.isFormField())
					formData.put(item.getFieldName(), item.getString());
				else {
					fileData.add(item);
				}
			}
			lMultipartData.setFormData(formData);
			lMultipartData.setFileData(fileData);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lMultipartData;
	}
	
	
	public static String serverIP() {
		InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
//            System.out.println("Your current IP address : " + ip);
//            System.out.println("Your current Hostname : " + hostname);
            return new String(ip.getAddress());
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
            return "";
        }
	}

	
	public static String getCurrentDate() {
		String pattern = "dd/MM/yyyy";
		return new SimpleDateFormat(pattern).format(new Date());
	}
	
	
	public static long compareDates(String pFormat, String pDate1, String pDate2)
	{
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(pFormat);
		        Date date1 = sdf.parse(pDate1);
		        Date date2 = sdf.parse(pDate2);

		        
		        return date1.compareTo(date2);
			} catch (Exception e) {
				e.printStackTrace();
				return -2;
			}
//	        System.out.println("date1 : " + sdf.format(date1));
//	        System.out.println("date2 : " + sdf.format(date2));

//	        if (date1.compareTo(date2) > 0) {
//	            System.out.println("Date1 is after Date2");
//	        } else if (date1.compareTo(date2) < 0) {
//	            System.out.println("Date1 is before Date2");
//	        } else if (date1.compareTo(date2) == 0) {
//	            System.out.println("Date1 is equal to Date2");
//	        } else {
//	            System.out.println("How to get here?");
//	        }
	}
	
	public static void main(String[] args) {
		
		System.out.println(compareDates("dd/MM/yyyy", "03/03/2020", "03/03/2020"));
//		ScreenDaoImpl lScreenDaoImpl = new ScreenDaoImpl();
//		
//		System.out.println(menuBuilder(lScreenDaoImpl.getScreenForUser(1)));

//		System.err.println(Mailer.sendMail("devendrasuhasjoglekar@gmail.com", "ashishgaikwad1997@gmail.com", "yetoy ka email",
//				"<h1>Hie Devendra, how are you??</h1><br><p>Mail send from my application. By ashish gaikwad</p>"));
	}

	
	
}
