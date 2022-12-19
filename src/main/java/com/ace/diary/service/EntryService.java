package com.ace.diary.service;

import com.ace.diary.dto.EditEntryRequest;
import com.ace.diary.models.Entry;

public interface EntryService {
    void addEntry(Entry entry);
    Entry getEntry(String entryId);

    void editEntry(String entryId, EditEntryRequest request);
}
