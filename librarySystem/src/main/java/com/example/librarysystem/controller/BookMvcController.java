package com.example.librarysystem.controller;

import com.example.librarysystem.entity.Member;
import com.example.librarysystem.repository.BookRepository;
import com.example.librarysystem.entity.Book;
import com.example.librarysystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookMvcController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;


    @GetMapping("/bookInfo")

    public String welcomePage() {
       return "Book";
    }



   @GetMapping("/addBook")
   @ResponseBody
    public String addBook (String subject,String title, String author,
                           String publisher,int copyright, int edition,
                           int pages,String ISBN,int shelfNo){
       Book book = new Book(subject,title,author,publisher,copyright,edition,pages,ISBN,shelfNo);

       bookRepository.save(book);
       return "Added a new book information to repo";
   }

    @GetMapping("/searchBook")

    public String getSearch(ModelMap model, String search) {
        Iterable<Book> bookToSearch = bookRepository.findAll();
        List<Book> selectedBook = new ArrayList<>();
        bookToSearch.forEach(book -> {
            if (book.getTitle().contains(search))
                selectedBook.add(book);

        });
        model.addAttribute("books", selectedBook);

        return "list_books";

    }

    @GetMapping("/issueBooks")
    @ResponseBody
    public String BorrowBooks (int memberId, int bookID,String returnDate) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        Optional<Book> bookOptional = bookRepository.findById(bookID);
        if (memberOptional.isPresent() && bookOptional.isPresent()) {
            Book book = bookOptional.get();

            book.setReturnDate(returnDate);
            book.setStatus(false);
            Member member = memberOptional.get();
            member.addBook(book);


            bookRepository.save(book);
            memberRepository.save(member);
            return "Successfully issued one book";

        } else {
            return "member id or book id are not valid";
        }

    }

    @GetMapping("/returnBooks")
    @ResponseBody
    public String ReturnBooks (int returnMemberId, int returnBookID) {
        Optional<Member> memberOptional = memberRepository.findById(returnMemberId);
        Optional<Book> bookOptional = bookRepository.findById(returnBookID);
        if (memberOptional.isPresent() && bookOptional.isPresent()) {
            Book book = bookOptional.get();

            book.setStatus(true);
            Member member = memberOptional.get();
            member.removeBook(book);


            bookRepository.save(book);
            memberRepository.save(member);
            return "Successfully returned one book";

        } else {
            return "member id or book id are not valid";
        }

    }

}
