package com.example.spring.user.user_spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private LocalDate dt_Nasc;
	private String genre;
	
	
	public User() {
		
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public LocalDate getDt_Nasc() {
		return dt_Nasc;
	}


	public void setDt_Nasc(LocalDate dt_Nasc) {
		this.dt_Nasc = dt_Nasc;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, dt_Nasc, genre, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dt_Nasc, other.dt_Nasc)
				&& Objects.equals(genre, other.genre) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
	
}
