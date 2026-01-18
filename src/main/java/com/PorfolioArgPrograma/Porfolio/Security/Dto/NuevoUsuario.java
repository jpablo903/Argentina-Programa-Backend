package com.PorfolioArgPrograma.Porfolio.Security.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */

@Getter
@Setter
@NoArgsConstructor
public class NuevoUsuario {
	@NotBlank
	private String nombre;
	@NotBlank
	private String nombreUsuario;
	@Email
	private String email;
	@NotBlank
	private String password;
}
