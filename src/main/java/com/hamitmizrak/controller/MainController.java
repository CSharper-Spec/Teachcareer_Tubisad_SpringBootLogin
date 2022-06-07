package com.hamitmizrak.controller;

import com.hamitmizrak.bean.StudentBean;
import com.hamitmizrak.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    StudentBean studentBean;


    //http://localhost:8080/bean
    @GetMapping("/bean")
    @ResponseBody
    public StudentDto getBean() {
        return studentBean.studentDto();
    }

    /////////////////////////////////
    //http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")//url
    public String getTymeleaf1() {
        return "thymeleaf_page1"; //html
    }

    //http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")//url
    public String getTymeleaf2(Model model) {
        model.addAttribute("key_controller", "Ben Javadan geldim");
        return "thymeleaf_page2"; //html
    }

    //http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")//url
    public String getTymeleaf3(Model model) {
        StudentDto studentDto =
                StudentDto
                        .builder()
                        .studentId(0L)
                        .studentName("Adı")
                        .studentSurname("Soyadı")
                        .build();
        model.addAttribute("key_controller", studentDto);
        return "thymeleaf_page3"; //html
    }

    //http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")//url
    public String  getTymeleaf4(Model model) {

        List<StudentDto> list=new ArrayList<>();
        for (int i = 1; i <=5 ; i++) {
            list.add(new StudentDto(i,"name "+i,"surname"+i) );
        }
        model.addAttribute("key_controller", list);
        return "thymeleaf4";
    }

    //http://localhost:8080/thymeleaf5
    //http://localhost:8080/thymeleaf5/0
    //http://localhost:8080/thymeleaf5/44
    @GetMapping({"thymeleaf5","thymeleaf5/{id}"})//url
    public String  getTymeleaf5(Model model, @PathVariable(name="id",required = false) Long id44) {
         if(id44==0){
            model.addAttribute("key_controller", "400 Bad Request");
        }else if(id44!=null){
            StudentDto studentDto =
                    StudentDto
                            .builder()
                            .studentId(id44)
                            .studentName("Adı")
                            .studentSurname("Soyadı")
                            .build();
            model.addAttribute("key_controller", studentDto);
        }else{
            model.addAttribute("key_controller", "404 id bulunamadı");
        }
        return "thymeleaf5";
    }


    //http://localhost:8080/thymeleaf6?adi=Hamit&surname=Mızrak
    @GetMapping("thymeleaf6")
    public String  getTymeleaf6(
            Model model,
            @RequestParam(name="adi") String adi
            ,@RequestParam(name="surname") String surname ) {

            StudentDto studentDto =
                    StudentDto
                            .builder()
                            .studentId(0L)
                            .studentName(adi)
                            .studentSurname(surname)
                            .build();
            model.addAttribute("key_controller", studentDto);

        return "thymeleaf5";
    }


}
