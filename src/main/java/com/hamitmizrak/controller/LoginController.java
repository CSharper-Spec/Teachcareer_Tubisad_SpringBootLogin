package com.hamitmizrak.controller;

import com.hamitmizrak.dto.LoginDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class LoginController {


    //http://localhost:8080/login
    @GetMapping("login")
    public String getLogin(Model model){
        model.addAttribute("validation_key",new LoginDto());
        return "login";
    }

    //http://localhost:8080/login
    @PostMapping("login")
    public String PostLogin(@Valid @ModelAttribute("validation_key") LoginDto loginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Giriş yaparken hata meydana geldi!");
            return "login";
        }

        log.info(loginDto);
        //Database
        //loginDto=null;
        return "login";
    }




    }
