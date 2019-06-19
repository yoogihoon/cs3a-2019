package iducs.springboot.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iducs.springboot.board.domain.Comment;
import iducs.springboot.board.entity.CommentEntity;
import iducs.springboot.board.repository.CommentRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired 
	private CommentRepository repository;
	
	@Override
	public Comment getCommentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveComment(Comment comment) {
		CommentEntity entity = new CommentEntity();
		entity.buildEntity(comment);
		repository.save(entity);
	}

	@Override
	public void updateComment(Comment question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteComment(Comment question) {
		// TODO Auto-generated method stub

	}

}
