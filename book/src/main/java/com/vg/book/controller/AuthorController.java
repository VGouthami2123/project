package com.vg.book.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 

import com.vg.book.entity.Author;
import com.vg.book.exception.ResourceNotModifiedException;
import com.vg.book.service.AuthorService;

 

//@Controller
//@ResponseBody
@CrossOrigin(origins= {"http://localhost:8089"})
@RequestMapping("/Author")
@RestController
public class AuthorController 
{
    @Autowired
    AuthorService authorService;
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors()
    {
        List<Author> alist= authorService.getAllAuthors();    
        if(alist.size()!=0)
            return new ResponseEntity<List<Author>>(alist,HttpStatus.OK);
        return new ResponseEntity<List<Author>>(alist,HttpStatus.NOT_FOUND);

    }
    @GetMapping(value="/{authorID}",produces="application/json")
    public ResponseEntity<Author> getAuthorByauthorID(@PathVariable int authorID)
    {
        Author a=authorService.getAuthorByauthorID(authorID);
        if(a!=null)
            return new ResponseEntity<Author>(a,HttpStatus.OK);
        return new ResponseEntity<Author>(a,HttpStatus.NOT_FOUND);

    }
    @PostMapping(consumes="application/json")
    public HttpStatus insertAuthor(@RequestBody Author  author)
    {
        authorService.insertOrModifyAuthor(author);
            return HttpStatus.OK;

    }
    @PutMapping(consumes="application/json")
    public HttpStatus modifyAuthor(@RequestBody Author  author)
    {
        authorService.insertOrModifyAuthor(author);
            return HttpStatus.OK;

    }
    @DeleteMapping("/{authorID}")
    public HttpStatus deleteAuthor(@PathVariable int authorID)
    {
        if(authorService.deleteAuthorByauthorId(authorID))
            return HttpStatus.OK;
        return HttpStatus.NOT_FOUND;
    }
    @ExceptionHandler(ResourceNotModifiedException.class)
    public HttpStatus notModifiedExceptionHandler()
    {
        return HttpStatus.NOT_MODIFIED;
    }
}