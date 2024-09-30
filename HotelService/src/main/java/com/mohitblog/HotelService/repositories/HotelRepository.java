package com.mohitblog.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohitblog.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
