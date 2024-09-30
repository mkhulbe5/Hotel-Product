package com.mohitblog.microservices.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mohitblog.microservices.Entity.Hotel;
import com.mohitblog.microservices.Entity.Rating;
import com.mohitblog.microservices.Entity.User;
import com.mohitblog.microservices.Repositories.UserRepository;
import com.mohitblog.microservices.Services.UserService;
import com.mohitblog.microservices.exceptions.ResourceNotFoundException;

import external.service.HotelService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private HotelService hotelService;

	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> fetchedUsers = userRepo.findAll();
		return fetchedUsers;
	}

	@Override
	public User getSingleUser(String userId) {

		User savedUserId = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("userid not exists"));
		Rating[] ratingsByUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + savedUserId.getUserId(),
				Rating[].class);
		log.info("{}", ratingsByUser);

		List<Rating> ratings = Arrays.stream(ratingsByUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating -> {
//	            Hotel hotel = hotelService.getHotel(rating.getHotelId());
			ResponseEntity<Hotel> forEntity = restTemplate
					.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			log.info("response status code: {} ", forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		savedUserId.setRatings(ratingList);
		return savedUserId;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

}
