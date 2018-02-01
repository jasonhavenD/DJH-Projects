package cn.edu.nwsuaf.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AutoRun implements ServletContextListener{
	
	private Timer timer = null;  
	  
    public void contextInitialized(ServletContextEvent arg0) {  
    	
    	//定时执行
    	Calendar calendar = Calendar.getInstance();  
    	calendar.set(Calendar.HOUR_OF_DAY, 0);  
    	calendar.set(Calendar.MINUTE, 0);  
    	calendar.set(Calendar.SECOND, 0);  
    	Date time = calendar.getTime();  
    	timer = new Timer();  
    	timer.schedule(new DisplayDate(), time); 
        //timer=new Timer(true);  
        //timer.schedule(new DisplayDate(),0,1000*60*60*24);//延迟0秒，每一天执行一次DisplayDate()  
    }  
      
    public void contextDestroyed(ServletContextEvent arg0) {  
        timer.cancel();  
    }  

}
