package com.MyProject.JournalApplication.Service;

import com.MyProject.JournalApplication.Entity.JournalEntry;
import com.MyProject.JournalApplication.Entity.User;
import com.MyProject.JournalApplication.Repository.JournalRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserService userService;



    @Transactional
    public void saveNewEntry(JournalEntry journalEntry, String username){
        try {

            User user  = userService.findByUserName(username);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);

        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the entry", e);
        }

    }



    public void saveEntry(JournalEntry journalEntry){
        journalRepository.save(journalEntry);

    }


    public List<JournalEntry> getALL(){
        return journalRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalRepository.findById(id);

    }

    @Transactional
    public boolean DeleteById(ObjectId id, String username){
        boolean removed = false;
        try {
            User user = userService.findByUserName(username);
            removed =  user.getJournalEntries().removeIf(x-> x.getId().equals(id));
            if (removed){
                userService.saveUser(user);
                journalRepository.deleteById(id);

            }

        }catch (Exception e){
            log.error("error",e);
            throw new RuntimeException("An error occurred while deleting the entry ",e);
        }
        return removed;


    }
}
