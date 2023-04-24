package com.dcankayrak.blogapp.business.abstracts;

import java.util.List;

import com.dcankayrak.blogapp.entities.Comment;
import com.dcankayrak.blogapp.requests.CommentCreateRequest;

public interface CommentService {
	List<Comment> getComments();
	List<Comment> getCommentsWithPostId(int postId);
	Comment getComment(int id);
	Comment createComment(CommentCreateRequest createComment);
	void deleteComment(int id);
}
