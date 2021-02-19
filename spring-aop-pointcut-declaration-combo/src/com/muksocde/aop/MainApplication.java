package com.muksocde.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mukscode.aop.dao.Account;
import com.mukscode.aop.dao.AccountDAO;
import com.mukscode.aop.dao.MembershipDAO;

public class MainApplication {

	public static void main(String[] args) {
		
		//read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		
		//get the bean from spring container
		AccountDAO theAcctDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		Account myAccount = new Account();
		theAcctDAO.addAccount(myAccount, true);
		theAcctDAO.doWork();
		
		//call the accountdao getter/setter methods
		theAcctDAO.setName("mukku");
		theAcctDAO.setServiceCode("blah");
		
		String name = theAcctDAO.getName();
		String code = theAcctDAO.getServiceCode();
		//call the membership business method
		membershipDAO.addMember();
		
		membershipDAO.goToSleep();
		
		
		//close the context
		context.close();

	}

}
