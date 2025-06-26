package com.example.journalApp.controller;


import com.example.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
    private Map<String, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> listJournalEntries() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntries.put(String.valueOf(myEntry.getId()), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntry(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    @PutMapping("id/{myId}")
    public boolean updateJournal(@PathVariable String myId, @RequestBody JournalEntry myEntry) {
        journalEntries.put(String.valueOf(myEntry.getId()), myEntry);
        return true;
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournal(@PathVariable Long myId) {
        journalEntries.remove(myId);
        return true;
    }

}


