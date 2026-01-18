package com.PorfolioArgPrograma.Porfolio.Security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.PorfolioArgPrograma.Porfolio.Security.Enums.RolNombre;

/**
 *
 * @author Juan Pablo
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private RolNombre rolNombre;

	public Rol(@NotNull RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}
}
