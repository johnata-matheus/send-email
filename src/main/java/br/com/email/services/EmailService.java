package br.com.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.email.enums.StatusEmail;
import br.com.email.models.EmailModel;
import br.com.email.repositories.EmailRepository;

@Service
public class EmailService {
  @Autowired
  EmailRepository emailRepository;

  @Autowired
  private JavaMailSender emailSender;

  @Value("${spring.mail.username}")
  private String emailto;

  public EmailModel sendEmail(EmailModel emailModel){

    String emailTo = this.emailto;  
    emailModel.setSendDateEmail(LocalDateTime.now());
    
    try{
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(emailModel.getEmailFrom());
      message.setTo(emailTo);
      message.setSubject(emailModel.getSubject());
      message.setText( 
        "Email: " + emailModel.getEmailFrom() + "\n"
        + "Nome: " + emailModel.getOwnerRef() + "\n"
        + "Data: " + emailModel.getSendDateEmail() + "\n"
        + "Mensagem: " +  emailModel.getText());
        
      emailSender.send(message);
    
      emailModel.setStatusEmail(StatusEmail.SENT);
    } catch(MailException e){
        emailModel.setStatusEmail(StatusEmail.ERROR);
    } finally {
        emailRepository.save(emailModel);
    }

    return emailModel;
  }

}
