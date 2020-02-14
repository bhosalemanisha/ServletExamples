package com.tdnservlet.practise;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerpojoDAOImpl implements CustomerpojoDAOI {
	DatabaseUtility db=new DatabaseUtility();
	 
public int insertcustomer(Customerpojo customerpojo) {
		int flag =0;
		try {
				System.out.println(customerpojo.getName());
				
				Connection con=db.getconnection();
				System.out.println(con);
				PreparedStatement ps= con.prepareStatement("INSERT INTO `customertbl`( `custname`, `address`, `moblienumber`) VALUES (?,?,?) ");
				ps.setString(1,customerpojo.getName());
				ps.setString(2,customerpojo.getAddress());
				ps.setString(3, customerpojo.getNumber());
				int s=ps.executeUpdate();
				//System.out.println(s);
				if (s==1){
					flag=1;
					
				} else {

					flag=0;
				}

				con.close();
				
	} catch (ClassNotFoundException e) {
		
		// TODO: handle exception
	}catch (SQLException e) {
		// TODO: handle exception
	}
		return flag;
	
	}	
public int updatecustomer(Customerpojo customerpojo)  {
			int flag =0;
	
	try {	
		
			
			Connection con =db.getconnection();
			PreparedStatement ps= con.prepareStatement("UPDATE `customertbl` SET `custname`=?,`address`=?,'mobilenumber'=? WHERE custid=?; ");
			ps.setString(1,customerpojo.getName());
			ps.setString(2,customerpojo.getAddress());
			ps.setString(3, customerpojo.getNumber());
			ps.setInt(4, customerpojo.getId());
			int s= ps.executeUpdate();
			System.out.println(s);
			if (s==1) {
				flag=1;
			
			}else {
				flag=0;
			}
			//System.out.println(s);
			
			con.close();

		} catch (ClassNotFoundException e) {
			
			// TODO: handle exception
		}catch (SQLException e) {
			// TODO: handle exception
		}
	return flag;
	
	
}
public int customerdelete(Customerpojo customerpojo ) {
		int flag=0;
	try {	
		Connection con = db.getconnection();
		PreparedStatement ps= con.prepareStatement("DELETE FROM `customertbl` WHERE custid=?");
		ps.setInt(1,customerpojo.getId());
		int s= ps.executeUpdate();
		System.out.println(s);
		if (s==1) {
			flag=1;
			}else {
				flag=0;
			}
		con.close();

	} catch (ClassNotFoundException e) {
		
		// TODO: handle exception
	}catch (SQLException e) {
		// TODO: handle exception
	}
return flag;

	

}

public int customerexist(int id) {
	int flag=0;	
	try {
	
    		Connection con = db.getconnection();			
			Statement st = con.createStatement();
			String query="select *	from customertbl where custid="+id;
			ResultSet rs= st.executeQuery(query);
	
			
			if (rs.next()) {
				flag=1;
				
			} else {
				flag=0;

			}
			con.close();
		} catch (ClassNotFoundException e) {
		
			// TODO: handle exception
		}catch (SQLException e) {
			// TODO: handle exception
		}	
		return flag;
	
}



	public Customerpojo findById(int id) {
			Customerpojo  customerpojo= new Customerpojo();
		try {
		
	    		Connection con = db.getconnection();
				String query="select *	from customertbl where custid=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, id);
						ResultSet rs=(ps.executeQuery());
				if (rs.next()) {
					customerpojo.setId(rs.getInt(1));
					customerpojo.setName(rs.getString(2));
					customerpojo.setAddress(rs.getString(3));		
					
				} else {
					customerpojo=null;
	
				}
				con.close();
			} catch (ClassNotFoundException e) {
			
				// TODO: handle exception
			}catch (SQLException e) {
				// TODO: handle exception
			}	
			return customerpojo;
		
	}


	public Customerpojo findByNumber(String number) {
		Customerpojo  customerpojo= new Customerpojo();
	try {
	
    		Connection con = db.getconnection();
			String query="select *	from customertbl where moblienumber=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, number);
	//		System.out.println("query inside rs");
			ResultSet rs=(ps.executeQuery());
			if (rs.next()) {
				customerpojo.setId(rs.getInt(1));
				customerpojo.setName(rs.getString(2));
				customerpojo.setAddress(rs.getString(3));	
				customerpojo.setNumber(rs.getString(4));
				
			} else {
				customerpojo=null;

			}
			con.close();
		} catch (ClassNotFoundException e) {
		
			// TODO: handle exception
		}catch (SQLException e) {
			// TODO: handle exception
		}	
		return customerpojo;
	
}

	public List<Customerpojo>getallcustomer(){
		
		List<Customerpojo> customerlist = new ArrayList<>();
		try {
    		
            
			Connection con =db.getconnection();			
		    Statement st = con.createStatement();
			String query="select * from customertbl";
			ResultSet rs= st.executeQuery(query);
			ResultSetMetaData rsmd= rs.getMetaData();		
			//System.out.println(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2));
			while (rs.next()) {
				Customerpojo cp = new Customerpojo();
				cp.setId(rs.getInt(1));
				cp.setName(rs.getString(2));
				cp.setAddress(rs.getString(3));
				cp.setNumber(rs.getString(4));
		
				customerlist.add(cp);
							}
			
		
			 	con.close();
		} catch (ClassNotFoundException e) {
						// TODO: handle exception
		}catch (SQLException e) {
			// TODO: handle exception
	}
		
		
		return customerlist;
		
		
	}
	
}