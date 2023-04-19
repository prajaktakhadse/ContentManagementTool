package com.Intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Intern.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}

