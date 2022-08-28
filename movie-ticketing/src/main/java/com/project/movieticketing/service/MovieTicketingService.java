package com.project.movieticketing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movieticketing.entity.MovieTicketing;
import com.project.movieticketing.repository.MovieTicketingRepository;

import java.util.List;

@Service

public class MovieTicketingService {
	@Autowired
private MovieTicketingRepository movieRepo;

	public MovieTicketing createMovieTicket(MovieTicketing movieticket) {
		
		return movieRepo.save(movieticket);
	}

	public MovieTicketing getTicketById(int id) {

		
		return movieRepo.findById(id);
	}


	public MovieTicketing save(MovieTicketing ticketById) {
		return movieRepo.save(ticketById);
	}

	public List<MovieTicketing> getTicketByName(String name) {
		List<MovieTicketing> byName =  movieRepo.findAllByName(name);
		return byName;
	}
}
