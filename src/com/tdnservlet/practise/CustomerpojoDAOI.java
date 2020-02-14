package com.tdnservlet.practise;

import java.util.List;

public interface CustomerpojoDAOI {
	public int insertcustomer (Customerpojo customerpojo);
	public int updatecustomer(Customerpojo customerpojo);
	public int customerdelete(Customerpojo customerpojo );
	public int customerexist(int id) ;
	public Customerpojo findById(int id);
	public Customerpojo findByNumber(String number);
	public List<Customerpojo>getallcustomer();

}
