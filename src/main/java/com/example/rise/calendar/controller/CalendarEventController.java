package com.example.rise.calendar.controller;

import com.example.rise.calendar.domain.CalendarEvent;
import com.example.rise.calendar.repository.CalendarRepository;
import com.example.rise.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class CalendarEventController {

    private final CalendarService calendarService;

    @GetMapping
    public List<CalendarEvent> getAllEvents(){
       return calendarService.getAllEvents();
    }

    @PostMapping
    public CalendarEvent createEvent(@RequestBody CalendarEvent event) {
        return calendarService.createEvent(event);
    }

    @PutMapping("/{id}")
    public CalendarEvent updateEvent(@PathVariable Long id, @RequestBody CalendarEvent event) {
        return calendarService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        calendarService.deleteEvent(id);
    }
}
