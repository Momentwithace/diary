package com.ace.diary.controller;

import com.ace.diary.dto.EditEntryRequest;
import com.ace.diary.models.Entry;
import com.ace.diary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/diary")
public class EntryController {
    @Autowired
    private EntryService entryService;

    @PostMapping("/addEntry")
    public String addEntry(@RequestBody Entry entry){
        entryService.addEntry(entry);
        return "added successfully";
    }
    @PatchMapping("/editEntry")
    public String editEntry(@RequestParam String entryId, @RequestBody EditEntryRequest request){
        entryService.editEntry(entryId, request);
        return "edited successfully";
    }
}
