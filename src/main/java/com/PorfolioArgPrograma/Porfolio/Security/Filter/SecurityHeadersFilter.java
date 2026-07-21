package com.PorfolioArgPrograma.Porfolio.Security.Filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filtro para agregar headers de seguridad HTTP
 * 
 * @author Juan Pablo
 */
@Component
public class SecurityHeadersFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// X-Content-Type-Options: previene MIME-sniffing
		response.setHeader("X-Content-Type-Options", "nosniff");
		
		// X-Frame-Options: previene clickjacking
		response.setHeader("X-Frame-Options", "DENY");
		
		// X-XSS-Protection: activa protección XSS del navegador
		response.setHeader("X-XSS-Protection", "1; mode=block");
		
		// Content-Security-Policy: restringe fuentes de contenido
		response.setHeader("Content-Security-Policy", 
			"default-src 'self'; " +
			"script-src 'self' 'unsafe-inline' 'unsafe-eval'; " +
			"style-src 'self' 'unsafe-inline'; " +
			"img-src 'self' data: https:; " +
			"font-src 'self' data:; " +
			"connect-src 'self'; " +
			"frame-ancestors 'none';");
		
		// Referrer-Policy: controla información de referer
		response.setHeader("Referrer-Policy", "strict-origin-when-cross-origin");
		
		// Permissions-Policy: controla features del navegador
		response.setHeader("Permissions-Policy", 
			"geolocation=(), " +
			"microphone=(), " +
			"camera=(), " +
			"payment=(), " +
			"usb=()");
		
		// Strict-Transport-Security: fuerza HTTPS (solo en producción)
		// response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
		
		filterChain.doFilter(request, response);
	}
}
