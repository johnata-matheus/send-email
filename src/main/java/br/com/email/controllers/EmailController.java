package br.com.email.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.email.dtos.EmailDto;
import br.com.email.models.EmailModel;
import br.com.email.services.EmailService;
import jakarta.validation.Valid;

@RestController
public class EmailController {
  
  @Autowired
  EmailService emailService;

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @PostMapping("/sending-email")
  public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
    EmailModel emailModel = new EmailModel();
    BeanUtils.copyProperties(emailDto, emailModel);
    emailService.sendEmail(emailModel);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(emailModel);
  }

}
