package com.example.spring.user.userspring.vo.v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id","name","cpf","genre","dt_Nasc"})
public class UserVO extends RepresentationModel<UserVO> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	private String name;
	private String cpf;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dt_Nasc;
	private String genre;
	
	
	public UserVO() {
		
	}


	public Long getKey() {
		return key;
	}


	public void setKey(Long key) {
		this.key = key;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, dt_Nasc, genre, key, name);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dt_Nasc, other.dt_Nasc)
				&& Objects.equals(genre, other.genre) && Objects.equals(key, other.key)
				&& Objects.equals(name, other.name);
	}

	
}
