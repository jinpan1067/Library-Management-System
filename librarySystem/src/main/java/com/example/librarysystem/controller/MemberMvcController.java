package com.example.librarysystem.controller;

import com.example.librarysystem.entity.Book;
import com.example.librarysystem.entity.Member;
import com.example.librarysystem.repository.BookRepository;
import com.example.librarysystem.repository.MemberRepository;
import com.example.librarysystem.repository.BookBorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberMvcController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/memberInfo")

    public String welcomePage() {
        return "members";
    }


    @GetMapping("/searchMember")

    public String getSearchMember(ModelMap model, int searchId) {
        Optional<Member> memberToSearch = memberRepository.findById(searchId);
        if (memberToSearch.isPresent()) {

            Member member1 = memberToSearch.get();


            model.addAttribute("members",member1 );

        } return "list_member";
    }




    @GetMapping("/addMember")
    @ResponseBody
    public String addMember (int memberID, String name, String phoneNumber, String email,String password, String RetypePassword ){

        Member member = new Member();
        member.setId(memberID);
        member.setName(name);
        member.setPhoneNumber(phoneNumber);
        member.setEmail(email);
        if(password.equals(RetypePassword))
        {   member.setPassword(password);
            memberRepository.save(member);
        return "Added a new book information to repo";}
        else return "Your entered password aren't the same,please retype your password.";
    }

}
