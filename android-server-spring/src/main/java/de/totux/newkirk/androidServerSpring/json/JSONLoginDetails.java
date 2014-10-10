package de.totux.newkirk.androidServerSpring.json;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class JSONLoginDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String password;
}
