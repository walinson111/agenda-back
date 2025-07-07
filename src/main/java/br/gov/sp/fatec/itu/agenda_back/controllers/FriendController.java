package br.gov.sp.fatec.itu.agenda_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.agenda_back.Service.FriendService;
import br.gov.sp.fatec.itu.agenda_back.entities.Friend;


@RestController
@RequestMapping("friends")
@CrossOrigin(origins = "http://localhost:4200")
public class FriendController {

    @Autowired
    private FriendService service;

    @GetMapping
    ResponseEntity <List<Friend>>getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    
    @PostMapping
    public ResponseEntity<Friend> save(@RequestBody Friend friend){
        return ResponseEntity.created(null).body(service.save(friend));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Friend friend){
        service.update(friend, id);
        return ResponseEntity.noContent().build();

    }
}
