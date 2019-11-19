package com.ovs.fingerPrint;

import java.sql.*;  
import java.io.*;  
public class InsertImage {  
public static boolean imageFunction(String voterId, String path) {  
	int i=0;
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
              
PreparedStatement ps=con.prepareStatement("insert into FINGERPRINT values(?,?)");  
ps.setString(1,voterId);  
  System.out.println("path"+path);
FileInputStream fin=new FileInputStream(path);  
ps.setBinaryStream(2,fin,fin.available());  
 i=ps.executeUpdate();  
System.out.println(i+" records affected");  
          
con.close();  
}catch (Exception e) {e.printStackTrace();}  
if(i>0){
return true;
}else 
return false;
}  
}  