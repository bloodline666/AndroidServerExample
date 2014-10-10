package de.totux.newkirk.androidServerSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USERS")
public class User {
	
	@Getter @Setter
	@Id
	@GeneratedValue
	private int id;
	
	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String password;
}
