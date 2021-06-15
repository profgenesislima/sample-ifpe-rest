package br.edu.ifpe.gus.ads4arq.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpe.gus.ads4arq.security.repository.UsuarioRepository;

@Service
public class AutorizacaoService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		var userDetail  = usuarioRepository.findByEmail(email);
		if(userDetail !=null) {
		return userDetail;
		}
		throw new UsernameNotFoundException("Usuário não encontrado!");
	}

}
