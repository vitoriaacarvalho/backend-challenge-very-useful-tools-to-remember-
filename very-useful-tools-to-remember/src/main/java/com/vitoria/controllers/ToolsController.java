package com.vitoria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitoria.models.Tools;
import com.vitoria.repositories.ToolsRepository;

@RestController
@RequestMapping("tools")
public class ToolsController {
	@Autowired
	private ToolsRepository repo;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping
	public ResponseEntity<List<Tools>> getAll(){
		List<Tools> tools=repo.findAll();
		return ResponseEntity.ok().body(tools);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Tools>> findById(@PathVariable Integer id){
		Optional<Tools> tool=repo.findById(id);
		return ResponseEntity.ok().body(tool);
	}
	
	@PostMapping
	public ResponseEntity<Tools> insert(@RequestBody Tools tool){
		Tools entity=tool;
		repo.save(entity);
		return ResponseEntity.ok().body(entity);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Tools> update(@PathVariable Integer id, @RequestBody Tools tool){
		Tools updatedTool=repo.findById(id).get();
		updatedTool.setTitle(tool.getTitle());
		updatedTool.setDescription(tool.getDescription());
		updatedTool.setLink(tool.getLink());
		updatedTool.setTags(tool.getTags());
		
		repo.save(updatedTool);
		return ResponseEntity.ok().body(updatedTool);
	}
	
	@GetMapping("/testando")
	public ResponseEntity<List<Tools>> findByTag(@RequestParam("tags") String tag){
		 List<Tools> allTools=repo.findByTag(tag);
		 return ResponseEntity.ok().body(allTools);	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
