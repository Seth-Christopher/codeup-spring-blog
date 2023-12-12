package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class HelloController {

    @GetMapping("/hello/{personName}")
    @ResponseBody
    public String hello(@PathVariable String personName) {
        return "Hello " + personName;
    }

    @GetMapping(path = "/hello-msg/{personName}", produces = "application/json")
    @ResponseBody
    public String helloMessage(@PathVariable String personName) {
        return String.format ("Hello from JSON! %s %s",personName, LocalDateTime.now());
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @Controller
    public class HelloCounter {
        private int counter = 0;

        @GetMapping("/counter/{counterInit}")
        @ResponseBody
        public String initCounter(@PathVariable int counterInit) {
            counter = counterInit;
            return "counter reset to " + counter;
        }

        @GetMapping("/increment")
        @ResponseBody
        public String incrementCounter() {
            counter++;
                    return "counter is now " + counter;
        }
    }

//    @RequestMapping(method = RequestMethod.GET, name = "/hello")
    @GetMapping(path = "/hello/{personName}")
    public String hello(@PathVariable String personName,
                        Model model) {
        model.addAttribute("name", personName);
        return "hello";
    }

    @GetMapping(path = "/hello-msg/{personName}", produces = "application/json")
    @ResponseBody
    public String secondHelloMessage(@PathVariable String personName) {
        return String.format("Hello from JSON! %s %s", personName, LocalDateTime.now());
    }




}
