package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.HashMap;

@RestController
public class OwnerController {
	@Autowired
	private OwnerRepository repository;

	@GetMapping("/owners")
	public Iterable<Owner> getOwners() {
		return repository.findAll();
	}

	@PostMapping("/owner")
	public Optional<Owner> getOwnerByFirstName(@RequestBody HashMap<String, String> ownerMap) {
		return repository.findByFirstname(ownerMap.get("firstname"));
	}
}
