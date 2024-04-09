package com.mail.send.controller;

import com.mail.send.model.MailModel;
import com.mail.send.services.MailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class MailController {
    @Autowired
    MailService mailService;

    @PostMapping("sendMail")
    @CrossOrigin(allowCredentials = "")
    public ResponseEntity<?> sendEmail(
            @Valid @RequestBody MailModel mailModel, BindingResult result
            ){
        if (result.hasErrors()) {
            List<String> errores = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errores);
        }
        String email = mailService.sendEmail(mailModel);

        return new ResponseEntity<>(email, HttpStatus.OK);
    }
}
