package com.mohitblog.RatingService.service;

import java.util.List;

import com.mohitblog.RatingService.entities.Rating;

public interface RatingService {

	Rating create(Rating rating);

	List<Rating> getRatings();

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);
}
