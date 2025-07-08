package br.gov.sp.fatec.itu.agenda_back.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.itu.agenda_back.entities.Friend;
import br.gov.sp.fatec.itu.agenda_back.repositories.FriendRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FriendService {

    @Autowired
    private FriendRepository repository;

    public List<Friend> getAll(){
        return repository.findAll();
    }
    
    public Friend save(Friend friend){
        return repository.save(friend);
    }

        public void update(Friend friend, Long id){
        Friend aux = repository.getReferenceById(id);
        
        aux.setName(friend.getName());
        aux.setAge(friend.getAge());
        aux.setGender(friend.getGender());
        aux.setCity(friend.getCity());
        aux.setSocial(friend.getSocial());
        aux.setOrigin(friend.getOrigin());
        aux.setPhone(friend.getPhone());
        aux.setState(friend.getState());
        aux.setJob(friend.getJob());
        aux.setFavorito(friend.getFavorito());


        repository.save(aux);
    }

        public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);

        }
        else{
            throw new EntityNotFoundException("Contato não cadastrado!");
        }
    }

}
