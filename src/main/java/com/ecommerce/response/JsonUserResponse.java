package com.ecommerce.response;

import java.util.Map;

import com.ecommerce.model.User;

public class JsonUserResponse {
	private User user;
	private boolean validated;
	private Map<String, String> errorMessages;
	
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
}
