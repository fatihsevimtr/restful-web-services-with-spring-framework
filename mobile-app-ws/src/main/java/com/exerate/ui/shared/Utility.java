package com.exerate.ui.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utility {
	
	public String generateId() {
		return UUID.randomUUID().toString();
	}

}
