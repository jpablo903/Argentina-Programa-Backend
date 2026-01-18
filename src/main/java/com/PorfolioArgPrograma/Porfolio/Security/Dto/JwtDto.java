package com.PorfolioArgPrograma.Porfolio.Security.Dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */
@Getter
@Setter
@AllArgsConstructor
public class JwtDto {

	private String token;
	private String bearer = "Bearer";
	private String nombreUsuario;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.nombreUsuario = nombreUsuario;
		this.authorities = authorities;
	}
}
