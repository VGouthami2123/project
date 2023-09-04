package com.vg.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vg.book.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer>
{

}