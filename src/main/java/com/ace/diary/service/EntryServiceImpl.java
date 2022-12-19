package com.ace.diary.service;

import com.ace.diary.dto.EditEntryRequest;
import com.ace.diary.models.Entry;
import com.ace.diary.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl implements EntryService{
    @Autowired
    private EntryRepository entryRepository;

    @Override
    public void addEntry(Entry entry) {
        entryRepository.save(entry);
    }

    @Override
    public Entry getEntry(String entryId) {
        var entry = entryRepository.findById(entryId);
        if(entry.isPresent()){
            return entry.get();
        }
        throw new IllegalArgumentException("Entry not found");
    }

    @Override
    public void editEntry(String entryId, EditEntryRequest request) {
        Entry entry = getEntry(entryId);
        if(request.getBody()!= "" && request.getBody()!= null){
            entry.setBody(request.getBody());
        }
        if(request.getTitle()!="" && request.getTitle()!= null){
            entry.setTitle(request.getTitle());
        }
        entryRepository.save(entry);
    }
}
