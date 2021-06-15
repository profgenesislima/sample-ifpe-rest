package br.edu.ifpe.gus.ads4arq.security.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.ifpe.gus.ads4arq.security.entity.Usuario;
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	UserDetails findByNome(String nome);
	UserDetails findByEmail(String email);
	UserDetails findBySenha(String token);


}
