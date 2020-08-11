package com.dxc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dxc.pojos.CancelBooking;

@Repository
public interface MongoCancel extends MongoRepository<CancelBooking,Integer>
{

}
