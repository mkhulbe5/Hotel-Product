package com.mohitblog.RatingService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohitblog.RatingService.entities.Rating;
import com.mohitblog.RatingService.repository.RatingRepository;
import com.mohitblog.RatingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepository repository;

	@Override
	public Rating create(Rating rating) {
		 String ratingId = UUID.randomUUID().toString();
		 rating.setRatingId(ratingId);
		return repository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return repository.findByHotelId(hotelId);
	}
}
