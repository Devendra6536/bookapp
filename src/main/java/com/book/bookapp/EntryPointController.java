package com.book.bookapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EntryPointController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hi all! this is devendra kumar(java backend developer)";
    }
}
