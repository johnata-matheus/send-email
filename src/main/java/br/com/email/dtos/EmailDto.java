package br.com.email.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {
  
  @NotBlank
  private String ownerRef;
  @NotBlank
  @Email
  private String emailFrom;
  @NotBlank
  private String subject;
  @NotBlank
  private String text;

}
