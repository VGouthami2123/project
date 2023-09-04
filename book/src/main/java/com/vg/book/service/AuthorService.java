package com.vg.book.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vg.book.entity.Author;
import com.vg.book.exception.ResourceNotFoundException;
import com.vg.book.exception.ResourceNotModifiedException;
import com.vg.book.repository.AuthorRepository;
@Service
public class AuthorService
{
@Autowired
AuthorRepository AuthorRepository;
@Transactional(readOnly=true)
public List<Author> getAllAuthors()
{
return AuthorRepository.findAll();
}
@Transactional(readOnly=true)
public Author getAuthorByauthorID(int authorID)
{
Optional<Author> ot=AuthorRepository.findById(authorID);
if(ot.isPresent())  return ot.get();
throw new ResourceNotFoundException();
}
@Transactional
public void insertOrModifyAuthor(Author author)
{
	if(AuthorRepository.save(author) == null)
		throw new ResourceNotModifiedException();
}
@Transactional
public boolean deleteAuthorByauthorId(int authorID)
{
	long count = AuthorRepository.count();
	AuthorRepository.deleteById(authorID);
	if(count > AuthorRepository.count())
		return true;
	throw new ResourceNotFoundException();
}
}




