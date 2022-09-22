package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.Entity.Movie;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieRepository movRepo;
	
	@Autowired
	private MovieService movSer;
	
	
	@PostMapping("/add")
	public ResponseEntity<Movie> addAll(@RequestBody Movie mov)
	{
		return ResponseEntity.ok(movRepo.save(mov));
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Movie>> getAll() {
		return ResponseEntity.ok(movRepo.findAll());
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Movie> findById(@PathVariable Long id) {
		return ResponseEntity.ok(movRepo.findById(id).orElse(null));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Movie> update(@RequestBody Movie mov) {
		return ResponseEntity.ok(movRepo.save(mov));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Movie> delete(@PathVariable Long id) {
		movRepo.findById(id).ifPresent(movRepo::delete);
		return ResponseEntity.ok().build();
	}

	@RequestMapping("/{id}")
	public Movie get(@PathVariable("id") Long mId) {
		
		Movie mov=new Movie();
		mov=movSer.getMovie(mId);
		System.out.println(".............."+mov);
		return mov;
		
	}

}
