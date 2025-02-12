package com.example.schedule_management_v2.repository;

import com.example.schedule_management_v2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findMemberByUsername(String username);
    Optional<Member> findMemberByEmail(String email);

    default Member findMemberByUsernameOrElseThrow(String username){
        return findMemberByUsername(username)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist username = "+username));
    }

    default Member findByIdOrElseThrow(Long id){
        return findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = "+id));
    }

    default Member findMemberByEmailOrElseThrow(String email) {
        return findMemberByEmail(email).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exits email = " + email));
    }


}
