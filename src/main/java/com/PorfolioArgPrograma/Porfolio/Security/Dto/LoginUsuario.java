package com.PorfolioArgPrograma.Porfolio.Security.Dto;

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
public class LoginUsuario {

	@NotBlank
	private String nombreUsuario;

	@NotBlank
	private String password;
}
