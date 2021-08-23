package com.example.bookstorespring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "user")
@Getter
@Setter
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	@Column
	private String name;
	@Column
	private String mobile;

//	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.ALL,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
//	@JoinColumn(name = "address_id", referencedColumnName = "id")
//	private Address address;

	private String city;
	private String landmark;
	private String pincode;
	private String locality;
	private String address;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}