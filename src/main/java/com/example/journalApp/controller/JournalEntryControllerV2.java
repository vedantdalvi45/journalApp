package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryService.getAllJournalEntries();
    }


    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());

        journalEntryService.saveJournalEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntry(@PathVariable ObjectId myId) {
        return journalEntryService.getJournalEntryById(myId).orElse(null);
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


