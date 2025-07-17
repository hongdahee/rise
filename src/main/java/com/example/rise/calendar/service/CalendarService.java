package com.example.rise.calendar.service;

import com.example.rise.calendar.domain.CalendarEvent;
import com.example.rise.calendar.repository.CalendarRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CalendarService {
    private final CalendarRepository calendarRepository;

    public List<CalendarEvent> getAllEvents() {
        return calendarRepository.findAll();
    }

    public CalendarEvent getEventById(Long id) {
        return calendarRepository.findById(id).orElseThrow(()->new EntityNotFoundException("존재하지 않는 이벤트입니다."));
    }

    public CalendarEvent createEvent(CalendarEvent eventContent) {
        CalendarEvent calendarEvent = new CalendarEvent();
        calendarEvent.setTitle(eventContent.getTitle());
        calendarEvent.setTeam(eventContent.getTeam());
        calendarEvent.setContent(eventContent.getContent());
        calendarEvent.setStart(eventContent.getStart());
        calendarEvent.setEnd(eventContent.getEnd());
//        calendarEvent.setIsAllDay(eventContent.getIsAllDay());
        return calendarRepository.save(calendarEvent);
    }

    public CalendarEvent updateEvent(Long id, CalendarEvent eventContent) {
        CalendarEvent event = getEventById(id);
        event.setTitle(eventContent.getTitle());
        event.setTeam(eventContent.getTeam());
        event.setContent(eventContent.getContent());
        event.setStart(eventContent.getStart());
        event.setEnd(eventContent.getEnd());
//        event.setIsAllDay(eventContent.getIsAllDay());
        return calendarRepository.save(event);
    }

    public void deleteEvent(Long id) {
        calendarRepository.deleteById(id);
    }
}
