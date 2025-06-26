package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.jar.JarOutputStream;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        System.out.println(journalEntryService.getAllJournalEntries().get(1).getId());
        return journalEntryService.getAllJournalEntries();

    }


    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,
                                                    HttpEntity<Object> httpEntity) {
        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveJournalEntry(myEntry);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getEntry(@PathVariable ObjectId myId) {
        Optional<JournalEntry> journalEntry = journalEntryService.getJournalEntryById(myId);
        if (journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("id/{myId}")
    public boolean updateJournal(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry) {
        return journalEntryService.updateJournalEntryById(myId, myEntry);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournal(@PathVariable ObjectId myId) {
        return journalEntryService.deleteJournalEntryById(myId);
    }

}


