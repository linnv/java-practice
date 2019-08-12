package hello;

import java.util.Map;

public interface CustomCRMService {
	
	public Object wsbWebService(Map<String, Object> param) throws Exception;
	
	public Object queryForFreemarker(Map<String, Object> param) throws Exception;
	

	public String getInterfaceXML(Map<String, Object> param) throws Exception;
	
	public String getInterfaceResXML(Map<String, Object> param) throws Exception;

}
