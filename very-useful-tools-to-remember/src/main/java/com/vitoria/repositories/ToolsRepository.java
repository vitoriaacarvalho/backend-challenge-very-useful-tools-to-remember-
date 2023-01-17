package com.vitoria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vitoria.models.Tools;

public interface ToolsRepository extends JpaRepository<Tools, Integer>{
	@Query(value="SELECT t FROM Tools t WHERE :tag MEMBER OF t.tags")
	public List<Tools> findByTag(String tag);
}
