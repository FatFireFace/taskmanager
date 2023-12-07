package com.fat_fire_face.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;


    public Comment updateComment(Long commentId, Comment updatedComment) {
        Optional<Comment> currentCommentOptional = commentRepository.findById(commentId);
            if (currentCommentOptional.isPresent()){
                Comment currentComment = currentCommentOptional.get();
                    currentComment.setTask(updatedComment.getTask());
                    currentComment.setText(updatedComment.getText());
                    return commentRepository.save(currentComment);
            }
            else return null;
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).
                orElseThrow(() -> new NoSuchElementException("нет комментариев по ID " + commentId));
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void deleteAllComments() {
        commentRepository.deleteAll();
    }
}
