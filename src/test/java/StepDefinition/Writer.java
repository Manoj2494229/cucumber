package StepDefinition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Writer {
	public static void main(String[] args) {
		
		try {
			String basePath = "C:\\Temp\\ReverseCouponPT\\";
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDDHHmmss");
			//d.toString()
			String fileName=basePath+"rc_"+sdf.format(d)+".csv";
			  // object of BufferedWriter class
	        BufferedWriter out = new BufferedWriter(
	            new FileWriter(fileName, true));

	        // Writing on output stream
	        out.write("\njeswanth,test");
	        // Closing the connection
	        out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
