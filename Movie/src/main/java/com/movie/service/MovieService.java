package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.Entity.Movie;
import com.movie.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movRepo;

	public Movie getMovie(Long mId) {
		// TODO Auto-generated method stub
		List<Movie> mov=movRepo.findAll();
		int n=mov.size();
		for(int i=0;i<n;i++) {
			Movie m=mov.get(i);
			if(m.getmId().equals(mId)) {
				
				return m;
			}
		}
		
		return null;
	}
	
	

}
