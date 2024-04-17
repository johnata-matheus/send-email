package br.com.email.models;

import java.time.LocalDateTime;

import br.com.email.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity(name = "tb_email")
public class EmailModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long emailId;
  private String ownerRef;
  private String emailFrom;
  private String emailTo;
  private String subject;

  @Column(columnDefinition = "TEXT")
  private String text;

  private LocalDateTime sendDateEmail;
  private StatusEmail statusEmail;
  
}
