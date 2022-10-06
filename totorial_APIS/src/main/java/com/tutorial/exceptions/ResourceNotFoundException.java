package com.tutorial.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

	Integer bId;

	public ResourceNotFoundException(Integer bId) {
		super(String.format("tutorial not found with id : " + bId));
		this.bId = bId;
	}

}
