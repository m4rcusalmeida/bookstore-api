package br.com.bookstore.config.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.bookstore.domain.Usuario;
import io.jsonwebtoken.Jwts;

@Service
public class TokenService {
	
	

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		return Jwts.builder()
				.setIssuer("API do bookstore")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(hoje)
	}
	
}
