package com.mukscode.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO { 
	
	private String name;
	private String serviceCode;
	
	/**
	 * @return the name
	 */
	public String getName() {
		System.out.println(getClass()+": in getName()");
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		System.out.println(getClass()+": in setName()");
		this.name = name;
	}

	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode()");
		return serviceCode;
	}

	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean testFlag) {
		System.out.println(getClass() + ": Doing My DB Work: Adding an Account");
	}

	public boolean doWork() {
		System.out.println("Do WORK");
		return true;
	}
}
