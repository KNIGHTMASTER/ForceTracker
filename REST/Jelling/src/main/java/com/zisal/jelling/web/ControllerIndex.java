package com.zisal.jelling.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ladies Man on 11/29/2015.
 */
@RestController
public class ControllerIndex {

    @RequestMapping("/")
    public String gotoIndex(){
        return "<br />" +
                "<h1>Hello, I am Jelling Rest Application</h1>";
    }
}
