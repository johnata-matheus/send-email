package br.com.email.dtos;

import br.com.email.models.EmailModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDto{
  @NotBlank
    private String ownerRef;

    @NotBlank
    @Email
    private String emailFrom;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

    public EmailDto() {
    }

    public EmailDto(String ownerRef, String emailFrom, String subject, String text) {
        this.ownerRef = ownerRef;
        this.emailFrom = emailFrom;
        this.subject = subject;
        this.text = text;
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
}
