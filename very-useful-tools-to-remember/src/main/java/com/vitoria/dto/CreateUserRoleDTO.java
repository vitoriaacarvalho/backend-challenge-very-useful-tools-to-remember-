package com.vitoria.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CreateUserRoleDTO {
	private Integer idUser;
	
	private List<Integer> idsRoles;

	public CreateUserRoleDTO() {
		super();
	}
	
	public CreateUserRoleDTO(Integer idUser, List<Integer> idsRoles) {
		super();
		this.idUser = idUser;
		this.idsRoles = idsRoles;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public List<Integer> getIdsRoles() {
		return idsRoles;
	}

	public void setIdsRoles(List<Integer> idsRoles) {
		this.idsRoles = idsRoles;
	}
	
	
}
