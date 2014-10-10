package de.totux.newkirk.androidServerSpring.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class JSONUserDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private List<String> usernames = new ArrayList<String>();
}
