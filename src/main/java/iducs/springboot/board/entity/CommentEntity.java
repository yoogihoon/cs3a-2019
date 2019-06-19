package iducs.springboot.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import iducs.springboot.board.domain.Comment;

@Entity
@Table (name="comment")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_comment_writer")
	private UserEntity writer;
	
	@ManyToOne
	@JoinColumn(name="fk_comment_question")
	private QuestionEntity question;

	@Lob
	private String contents;
	private LocalDateTime createTime;
	
	public Comment buildDomain() {
		Comment comment = new Comment();
		comment.setId(id);
		comment.setWriter(writer.buildDomain());
		comment.setQuestion(question.buildDomain());
		comment.setContents(contents);
		comment.setCreateTime(createTime);
		return comment;
	}
	public void buildEntity(Comment comment) {
		id = comment.getId();

		UserEntity userEntity = new UserEntity();
		userEntity.buildEntity(comment.getWriter());
		writer = userEntity;
		
		QuestionEntity quesitonEntity = new QuestionEntity();
		quesitonEntity.buildEntity(comment.getQuestion());
		question = quesitonEntity;
		
		contents = comment.getContents();
		createTime = comment.getCreateTime();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentEntity other = (CommentEntity) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
