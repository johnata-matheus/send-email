package br.com.email.models;

import java.time.LocalDateTime;

import br.com.email.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_email")
public class EmailModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Long emailId;
  @Column
  private String ownerRef;
  @Column
  private String emailFrom;
  @Column
  private String emailTo;
  @Column
  private String subject;

  @Column(columnDefinition = "TEXT")
  private String text;

  @Column
  private LocalDateTime sendDateEmail;
  private StatusEmail statusEmail;
  
  public Long getEmailId() {
    return emailId;
}

public void setEmailId(Long emailId) {
    this.emailId = emailId;
}

public String getOwnerRef() {
    return ownerRef;
}

public void setOwnerRef(String ownerRef) {
    this.ownerRef = ownerRef;
}

public String getEmailFrom() {
    return emailFrom;
}

public void setEmailFrom(String emailFrom) {
    this.emailFrom = emailFrom;
}

public String getEmailTo() {
    return emailTo;
}

public void setEmailTo(String emailTo) {
    this.emailTo = emailTo;
}

public String getSubject() {
    return subject;
}

public void setSubject(String subject) {
    this.subject = subject;
}

public String getText() {
    return text;
}

public void setText(String text) {
    this.text = text;
}

public LocalDateTime getSendDateEmail() {
    return sendDateEmail;
}

public void setSendDateEmail(LocalDateTime sendDateEmail) {
    this.sendDateEmail = sendDateEmail;
}

public StatusEmail getStatusEmail() {
    return statusEmail;
}

public void setStatusEmail(StatusEmail statusEmail) {
    this.statusEmail = statusEmail;
}
}
