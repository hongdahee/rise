package com.example.rise.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {
    @GetMapping("/")
    public String main(){
        return "calendar/calendar";
    }
}
