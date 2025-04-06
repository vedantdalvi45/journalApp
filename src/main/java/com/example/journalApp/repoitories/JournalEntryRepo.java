package com.example.journalApp.repoitories;

import com.example.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {

}
