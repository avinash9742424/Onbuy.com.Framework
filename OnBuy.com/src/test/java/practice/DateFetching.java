package practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mysql.cj.jdbc.Driver;

public class DateFetching {
   public static void main(String[] args) throws SQLException {
	
	   
	   Date date = new Date();
	   System.out.println(date.toString());
	   SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
	   String parse = sim.format(date);
	   System.out.println(parse);
	   
	   /*fetch the date after/before days in a calendar*/
	   
	   Calendar cal = Calendar.getInstance();
	   cal.add(Calendar.DATE, 30);
	   Date date1 = cal.getTime();
	   
	   SimpleDateFormat si = new SimpleDateFormat("dd-MM-yyyy");
	   System.out.println(si.format(date1));
	   
	   
}
}
