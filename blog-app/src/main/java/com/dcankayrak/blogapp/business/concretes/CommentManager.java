package com.dcankayrak.blogapp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcankayrak.blogapp.business.abstracts.CommentService;
import com.dcankayrak.blogapp.entities.Comment;
import com.dcankayrak.blogapp.entities.Post;
import com.dcankayrak.blogapp.repositories.CommentRepository;
import com.dcankayrak.blogapp.repositories.PostRepository;
import com.dcankayrak.blogapp.requests.CommentCreateRequest;

@Service
public class CommentManager implements CommentService{

	private CommentRepository theCommentRepository;
	private PostRepository thePostRepository;
	
	@Autowired
	public CommentManager(CommentRepository theCommentRepository,
			PostRepository thePostRepository) {
		this.theCommentRepository = theCommentRepository;
		this.thePostRepository = thePostRepository;
	}

	@Override
	public List<Comment> getComments() {
		return this.theCommentRepository.findAll();
	}

	@Override
	public Comment getComment(int id) {
		Optional<Comment> foundComment = this.theCommentRepository.findById(id);
		if(foundComment.isPresent()) {
			return foundComment.get();
		}
		return null;
	}

	@Override
	public Comment createComment(CommentCreateRequest createComment) {
		System.out.println(createComment);
		Optional<Post> foundPost = this.thePostRepository.findById(createComment.getPostId());
		if(foundPost.isPresent()) {
			Comment newComment = new Comment();
			newComment.setPost(foundPost.get());
			newComment.setFirstName(createComment.getFirstName());
			newComment.setLastName(createComment.getLastName());
			newComment.setEmail(createComment.getEmail());
			newComment.setComment(createComment.getComment());
			return this.theCommentRepository.save(newComment);
		}
		return null;
	}


	@Override
	public void deleteComment(int id) {
		if(this.theCommentRepository.findById(id).isPresent()) {
			this.theCommentRepository.deleteById(id);
		}
	}

	@Override
	public List<Comment> getCommentsWithPostId(int postId) {
		return null;
	}

}
