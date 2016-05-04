package com.javaclass.gymapp.repository;

import com.javaclass.gymapp.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepo extends CrudRepository<Member, Long> {

}