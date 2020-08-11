package com.dxc;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;

@Repository
public interface MongoCustomer extends MongoRepository<Customer,String>
{
	public List<Customer> findCustomerByMobile(Long m);
}

