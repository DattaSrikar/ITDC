package com.dxc;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dxc.pojos.Hotel;

@Repository
public interface Mongohotel extends MongoRepository<Hotel,Integer>
{
	public List<Hotel> findHotelById(int i);

}

