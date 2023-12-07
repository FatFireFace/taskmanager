package com.fat_fire_face.taskmanager;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Operation(summary = "Получить список всех комментариев")
    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @Operation(summary = "Получить комментарий по его id")
    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.getCommentById(commentId);
    }

    @Operation(summary = "Изменить комментарий под заданным ID")
    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment comment){
        return commentService.updateComment(commentId, comment);
    }

    @Operation(summary = "Удаляет комментарий под заданным ID")
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

    @Operation(summary = "Удаляет все комментарии")
    @DeleteMapping
    public void deleteAllComments(){commentService.deleteAllComments();}

}
