package com.hamitmizrak.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {

    private int loginId;

    @NotEmpty(message = "İsim boş bırakılamaz.")
    private String loginName;
    @NotEmpty(message = "Soyisim boş bırakılamaz.")
    private String loginSurname;
    @Email(message = "Doğru formatta girdiğinizden emin olun, xyz@mail.com")
    @NotEmpty(message = "E-mail boş bırakılamaz.")
    private String loginEmail;

    public String Date(){
        Locale locale = new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",locale);
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));

    }
    private String loginDate = Date();


}
