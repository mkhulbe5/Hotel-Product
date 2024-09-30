package com.mohitblog.HotelService.services;

import java.util.List;

import com.mohitblog.HotelService.entities.Hotel;

public interface HotelService {
	// create

	Hotel create(Hotel hotel);

	// get all
	List<Hotel> getAll();

	// get single
	Hotel getHotel(String id);
}
