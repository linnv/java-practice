package hello;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//import org.apache.tomcat.util.json.JSONParser;

//import org.json.simple.*;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
// 
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

//import org.json.*;
import java.io.FileWriter;
import java.io.IOException;

import java.io.FileReader; 
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class Config {
	public static  String addr;
	private static final Config INSTANCE = new Config();
	  
    private Config(){
    	 Object obj;
 		try {
 			obj = new JSONParser().parse(new FileReader("/data/javaconfig/config.json"));
 			  // typecasting obj to JSONObject 
 	         JSONObject jo = (JSONObject) obj; 
 	           
 	         // getting firstName and lastName 
 	       this.addr = (String) jo.get("name"); 
 	        System.out.println(this.addr);
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} 
    }

    public static Config getInstance(){
        return INSTANCE;
    }
    
    public void show(){
        System.out.println("Config Singleon using static initialization in Java addr ="+this.addr);
    }
    
	private static void WriteJson(){
		 // creating JSONObject 
        JSONObject jo = new JSONObject(); 
          
        // putting data to JSONObject 
        jo.put("firstName", "John"); 
        jo.put("lastName", "Smith"); 
        jo.put("age", 25); 
          
        // for address data, first create LinkedHashMap 
        Map m = new LinkedHashMap(4); 
        m.put("streetAddress", "21 2nd Street"); 
        m.put("city", "New York"); 
        m.put("state", "NY"); 
        m.put("postalCode", 10021); 
          
        // putting address to JSONObject 
        jo.put("address", m); 
          
        // for phone numbers, first create JSONArray  
        JSONArray ja = new JSONArray(); 
          
        m = new LinkedHashMap(2); 
        m.put("type", "home"); 
        m.put("number", "212 555-1234"); 
          
        // adding map to list 
        ja.add(m); 
          
        m = new LinkedHashMap(2); 
        m.put("type", "fax"); 
        m.put("number", "212 555-1234"); 
          
        // adding map to list 
        ja.add(m); 
          
        // putting phoneNumbers to JSONObject 
        jo.put("phoneNumbers", ja); 
          
        // writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw;
		try {
			pw = new PrintWriter("JSONExample.json");

        pw.write(jo.toJSONString()); 
          
        pw.flush(); 
        pw.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
//   	 JSONObject obj = new JSONObject();
//        try {
//			obj.put("name", "mkyong.com");
//
//        obj.put("age", 100);
//
//        JSONArray list = new JSONArray();
// 
//        list.put("msg 1");
//        list.put("msg 2");
//        list.put("msg 3");
//
//        obj.put("messages", list);
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        
//        try (FileWriter file = new FileWriter("/data/javaconfig/config.json")) {
//            file.write(obj.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.print(obj);
	}
	
	
   // @SuppressWarnings("unchecked")
    public static void main(String[] args) {
    	WriteJson();
  
//        FileReader reader = new FileReader("/data/javaconfig/config.json");
//       JSONParser jsonParser = new JSONParser();
//       jsonParser.parse(reader);
//       JSONObject jo = (JSONObject) jsonParser; 
//       String firstName = (String) jsonParser.get("name"); 
    	 Object obj;
		try {
			obj = new JSONParser().parse(new FileReader("/data/javaconfig/config.json"));
			  // typecasting obj to JSONObject 
	         JSONObject jo = (JSONObject) obj; 
	           
	         // getting firstName and lastName 
	        String firstName = (String) jo.get("name"); 
	        System.out.println(firstName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


    }

}

