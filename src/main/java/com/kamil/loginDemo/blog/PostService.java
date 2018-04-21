package com.kamil.loginDemo.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamil.loginDemo.user.User;

@Service
public class PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	public void removePost(Post post){
		System.out.println("deletingg post: "+post.id+" - "+post.content);
		postRepo.delete(post);
	}
	
	public void savePost(Post post){
		postRepo.save(post);
	}
	
	public List<Post> getUsersPosts(User user){
		return postRepo.findByAuthor(user);
	}
	
	public List<Post> getAllPosts(){
		return (List<Post>) postRepo.findAll();
	}
	
	public void removeById(Long id){
		postRepo.deleteById(id);
	}
	
}
