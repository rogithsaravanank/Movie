package com.project.movieticketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.movieticketing.entity.MovieTicketing;
import com.project.movieticketing.service.MovieTicketingService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/movieTickets")
@Slf4j
public class MovieTicketingController {

	@Autowired
	private MovieTicketingService movieService;
	@PostMapping("/")
	public String createTicket(@RequestBody MovieTicketing movieticket)
	{
		movieticket.setStatus("Booked");
		MovieTicketing movieTicket = movieService.createMovieTicket(movieticket);
		String str = " The ticket is booked and ticket no is " + movieTicket.getId();
		return str;
		
	}
	
	@PostMapping("/cancel/{id}")
	public String getTicketByName(@PathVariable("id") int id )
	{
		MovieTicketing ticketById = movieService.getTicketById(id);
		ticketById.setStatus("Cancelled");
		System.out.println(ticketById);
		movieService.save(ticketById);
		String str = " The ticket is cancelled Successfully " + ticketById.getId();
		return str;

	}

	@GetMapping("/getByName/{name}")
	public List<MovieTicketing> GetByName( @PathVariable("name") String name){
		List<MovieTicketing> ticketByName = movieService.getTicketByName(name);
		return ticketByName;

	}

}
