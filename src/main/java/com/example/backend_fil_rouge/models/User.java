package com.example.backend_fil_rouge.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_confirmed")
    private Boolean is_confirmed;

    @Column(name = "creation_date")
    private Date creation_date;

    public User() {}

    public User(String name, String email, String password, Boolean is_confirmed, Date creation_date)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.is_confirmed = is_confirmed;
        this.creation_date = creation_date;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIs_confirmed() {
		return is_confirmed;
	}

	public void setIs_confirmed(Boolean is_confirmed) {
		this.is_confirmed = is_confirmed;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}


    
}
