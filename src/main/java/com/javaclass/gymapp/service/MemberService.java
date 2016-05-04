package com.javaclass.gymapp.service;

import com.javaclass.gymapp.domain.Member;
import com.javaclass.gymapp.repository.MemberRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepo memberRepo;

    public List<Member> findAll(){
        List<Member> memberList = new ArrayList<>();
        for (Member member : memberRepo.findAll()) {
            memberList.add(member);
        }
        return memberList;
    }

    public Member findOne(Member member){
        return memberRepo.findOne(member.getMemberId());
    }

    public void updateMember(Member member){
        memberRepo.save(member);
    }

    public void createMember(Member member){
        memberRepo.save(member);
    }

    public void deleteMember(Long id){
        memberRepo.delete(id);
    }

    public Member jsonMemberToMember(JSONObject object){
        Member temp = new Member();
        try{
            temp.setMemberId(object.getLong("id"));
        }catch (Exception e){

        }
        temp.setFirstName(object.getString("firstName"));
        temp.setLastName(object.getString("lastName"));
        try{
            temp.setPhoneNumber(object.getString("phoneNumber"));
        }catch (Exception e){

        }
        return temp;
    }
}