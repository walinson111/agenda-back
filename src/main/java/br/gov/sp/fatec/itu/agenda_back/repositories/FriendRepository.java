package br.gov.sp.fatec.itu.agenda_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.itu.agenda_back.entities.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    
}
