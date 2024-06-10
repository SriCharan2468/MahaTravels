package com.model;

//Represents a booking order with details like order ID, the associated route, journey plan, order amount, and status.
public class Order {
	private int orderId;
	private Route route;
	private Journey requestedJourneyPlan;
	private Double orderAmount;
	private String orderStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Journey getRequestedJourneyPlan() {
		return requestedJourneyPlan;
	}

	public void setRequestedJourneyPlan(Journey requestedJourneyPlan) {
		this.requestedJourneyPlan = requestedJourneyPlan;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		String result = "  \tOrderId: " + orderId + "\n\t" + route + "\n  \tJourney Plan: " + requestedJourneyPlan
				+ "\n  \tOrder Amount: " + orderAmount + "\n  \tOrder Status: " + orderStatus;
		return result;
	}

}
