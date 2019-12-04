package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdncdemo {


	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		int[] countArray = {0,0,0,0,0};
		Class.forName("com.mysql.jdbc.Driver");
	    Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3307/nybike", "root", "123");
	    
	    
	    PreparedStatement ps = conn.prepareStatement("select nba/(nba+nda) as abi from tb_ss");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
	    	double abi = rs.getDouble("abi");//自动处理为0
	    	System.out.println(abi);
	    	if(abi==0) {
	    		countArray[0]++;
	    	}else if(abi<=0.1) {
	    		countArray[1]++;
	    	}else if(abi<=0.5) {
	    		countArray[2]++;
	    	}else if(abi<1) {
	    		countArray[3]++;
	    	}else {
		    	countArray[4]++;
		    	
	    	}
	    	
	    }
	    for(int i:countArray) {
	    	System.out.println(i);
	    }
	    ps.close();
	    conn.close();
	}

}
