package com.mohitblog.HotelService.servicesImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohitblog.HotelService.entities.Hotel;
import com.mohitblog.HotelService.exceptions.ResourceNotFoundException;
import com.mohitblog.HotelService.repositories.HotelRepository;
import com.mohitblog.HotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	   @Autowired
	    private HotelRepository hotelRepository;

	    @Override
	    public Hotel create(Hotel hotel) {
	        String hotelId = UUID.randomUUID().toString();
	        hotel.setId(hotelId);
	        return hotelRepository.save(hotel);
	    }

	    @Override
	    public List<Hotel> getAll() {
	        return hotelRepository.findAll();
	    }

	    @Override
	    public Hotel getHotel(String id) {
	        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	    }
}
