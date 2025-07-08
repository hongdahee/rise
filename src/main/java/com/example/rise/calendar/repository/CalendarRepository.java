package com.example.rise.calendar.repository;

import com.example.rise.calendar.domain.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<CalendarEvent, Long>
{
}
