package com.kamil.loginDemo.blog;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kamil.loginDemo.user.User;

@Repository
public interface PostRepo extends CrudRepository<Post, Long>{
	
	public List<Post> findByAuthor_Id(long id);
	
	public List<Post> findByAuthor(User user);
}
