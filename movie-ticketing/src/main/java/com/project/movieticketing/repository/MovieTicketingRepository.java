package com.project.movieticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.movieticketing.entity.MovieTicketing;

import java.util.List;

@Repository
public interface MovieTicketingRepository extends JpaRepository<MovieTicketing, String> {

	MovieTicketing findByName(String name);


	MovieTicketing findById(int id);

	List<MovieTicketing> findAllByName(String name);
}
