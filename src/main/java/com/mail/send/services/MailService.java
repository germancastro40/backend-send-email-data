package com.mail.send.services;

import com.mail.send.model.MailModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailService {
    private JavaMailSender mail;

    public MailService(JavaMailSender mail) {
        this.mail = mail;
    }

    SimpleMailMessage email = new SimpleMailMessage();

    public String sendEmail(MailModel mailModel){
        email.setTo("germancastro40@hotmail.com");
        email.setFrom("germancastro40@hotmail.com");
        email.setSubject("Datos del cliente para ser contactado");
        email.setText(
                "nombre del cliente: " +mailModel.getNombre()+ "\n"+
                "Correo del cliente: " +mailModel.getEmail() + "\n"+
                "Numero del cliente: " +mailModel.getTelefono()+  "\n"
                //" - Mensaje por parte del cliente: " +mailModel.getMessage()
        );
        mail.send(email);

        //System.out.println(email.getText());

        return "Enviado" ;
    }
}
