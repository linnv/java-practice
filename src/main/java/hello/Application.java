package hello;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caucho.hessian.io.HessianRemoteObject;
import com.ideal.ext.config.header.IDEALHeader;
import com.ideal.ext.config.proxy.RMIProxy;
import com.ideal.ext.utils.RMIUtils;

@SpringBootApplication
@RestController
public class Application {
	 public static Object SendMsg(String serviceId) throws Exception{
			URL url = new URL("http://10.144.64.50/server/rmiService/CustomCRMService");
			RMIProxy rp = RMIUtils.getInstance()._RMI(url);	
			IDEALHeader header = new IDEALHeader();
			header.setConsumer("sdn_app");
			SimpleDateFormat st = new SimpleDateFormat("yyyyMMddHHMMssSSS");
			String seq_num = "dq" + st.format(new Date());
			System.out.println("流水号seq_num -->" + seq_num);
			header.setSeqNum(seq_num); 
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss.SSS");
			header.setRequestTime(sim.format(new Date())); 
			header.setServiceVer("v1");
			header.setServiceName(serviceId);// 接口编号
			rp.setIdealHeader(header);
			CustomCRMService  rs =  (CustomCRMService) 
	Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] {CustomCRMService.class, HessianRemoteObject.class }, rp);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("destTermID","17321351279");
		    params.put("srcTermID","10001");
		    params.put("msgContent","测试测试测试");
		    params.put("disturbType","0");
		    params.put("needReport","0");
		    params.put("serviceName","xxxxx");
		    params.put("serialID","20171102141041003000213");
		    params.put("serviceProvider","xxxx");
		    params.put("pwd","xxxx");
	        params.put("serviceId",serviceId);
	        Object returnMsg= rs.queryForFreemarker(params);
			return returnMsg;
		}
	 
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping(value = "/hey")
	public String getFoosBySimplePath() {
    	try {
			Application.SendMsg("one msg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "Hey Docker";
	}
   
    public static void main(String[] args) {
    	System.out.println("sss");
    	Config.getInstance().show();
        SpringApplication.run(Application.class, args);
    }

}

