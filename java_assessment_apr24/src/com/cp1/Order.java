package com.cp1;

public class Order {

	private Integer orderNumberInteger;
	private String stateString = "NEW";
	
	Order() {}
	
	Order(Integer orderNumberInteger) {
		setOrderNumberInteger(orderNumberInteger);
		System.out.println("Order " 
		+ Integer.toString(getOrderNumberInteger())
		+ " to be FULFILLED");
	}
	
	public Integer getOrderNumberInteger() {
		return orderNumberInteger;
	}
	
	public void setOrderNumberInteger(Integer orderNumberInteger) {
		this.orderNumberInteger = orderNumberInteger;
	}

	public String getStateString() {
		return stateString;
	}

	public void setStateString(String stateString) {
		this.stateString = stateString;
		System.out.println(Integer.toString(this.orderNumberInteger) + ':' + this.stateString);
	}
	
	
}
