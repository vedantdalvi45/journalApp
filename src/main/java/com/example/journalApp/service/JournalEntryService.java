package com.example.journalApp.service;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.repoitories.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveJournalEntry(JournalEntry journalEntry) {
        journalEntryRepo.save(journalEntry);
    }

    //
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getJournalEntryById(ObjectId objectId) {
        return journalEntryRepo.findById(objectId);
    }

    public boolean updateJournalEntryById(ObjectId objectId, JournalEntry journalEntry) {
        journalEntry.setId(objectId);
        journalEntryRepo.save(journalEntry);
        return true;
    }


    public boolean deleteJournalEntryById(ObjectId objectId) {
        journalEntryRepo.deleteById(objectId);
        return true;
    }


}
