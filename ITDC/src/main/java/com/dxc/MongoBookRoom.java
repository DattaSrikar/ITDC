package com.dxc;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dxc.pojos.BookRoom;

@Repository
public interface MongoBookRoom extends MongoRepository<BookRoom,Integer>
{
	public List<BookRoom> findBookRoomBycustomermobile(long m);
	public List<BookRoom> findBookRoomBybookingid(int i);
}
