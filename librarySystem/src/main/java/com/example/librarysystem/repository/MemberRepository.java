package com.example.librarysystem.repository;

import com.example.librarysystem.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
