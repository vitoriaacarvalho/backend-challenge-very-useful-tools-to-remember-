package com.vitoria.dto;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CreateUserRoleDTO {
	private UUID idUser;
	
	private List<UUID> idsRoles;

	public CreateUserRoleDTO() {
		super();
	}
	
	public CreateUserRoleDTO(UUID idUser, List<UUID> idsRoles) {
		super();
		this.idUser = idUser;
		this.idsRoles = idsRoles;
	}

	public UUID getIdUser() {
		return idUser;
	}

	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}

	public List<UUID> getIdsRoles() {
		return idsRoles;
	}

	public void setIdsRoles(List<UUID> idsRoles) {
		this.idsRoles = idsRoles;
	}
	
	
}
