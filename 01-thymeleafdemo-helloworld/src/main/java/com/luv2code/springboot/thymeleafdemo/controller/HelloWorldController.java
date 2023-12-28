package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // Need a controller method to read and
    //add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        // Read request parameter from HTML FORM
        String theName = request.getParameter("studentName");

        //Convert the data to all CAPS
        theName = theName.toUpperCase();

        //Create a message
        String result = "Yo! "+ theName;

        //Add message to the model
        model.addAttribute("message",result);
        return "helloworld";
    }


    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){
        // Read request parameter from HTML FORM
//        String theName = request.getParameter("studentName"); no need now

        //Convert the data to all CAPS
        theName = theName.toUpperCase();

        //Create a message
        String result = "Hey My Friend from V3! "+ theName;

        //Add message to the model
        model.addAttribute("message",result);
        return "helloworld";
    }

}
