package com.javaclass.gymapp.controller;

import com.javaclass.gymapp.domain.Member;
import com.javaclass.gymapp.service.MemberService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> findAllMembers(){
        return memberService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity updateMember(@RequestBody String jsonMember){

        JSONObject object = new JSONObject(jsonMember);

        Member member = new Member();
        member.setMemberId(object.getLong("memberId"));
        member.setFirstName(object.getString("firstName"));
        member.setLastName(object.getString("lastName"));
        try{
            member.setPhoneNumber(object.getString("phoneNumber"));
        }catch (Exception e){

        }

        try {
            memberService.updateMember(member);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createMember(@RequestBody String jsonMember){

        JSONObject object = new JSONObject(jsonMember);

        Member member = new Member();
        member.setFirstName(object.getString("firstName"));
        member.setLastName(object.getString("lastName"));
        try{
            member.setPhoneNumber(object.getString("phoneNumber"));
        }catch (Exception e){

        }

        try {
            memberService.createMember(member);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMember(@PathVariable("id") Long id){
        try {
            memberService.deleteMember(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}