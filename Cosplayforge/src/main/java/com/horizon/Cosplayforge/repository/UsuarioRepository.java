package com.horizon.Cosplayforge.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.horizon.Cosplayforge.model.Usuario;
import com.horizon.Cosplayforge.model.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

	//login por e-mail
    Optional<Usuario> findByEmailIgnoreCase(String email);
 
    
    //Ver se tem antes de cadastrar
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByNomeUsuario(String nomeUsuario);
    boolean existsByCpf(String cpf);
 
    //(admin): listagem por perfil
    List<Usuario> findByPerfil(PerfilUsuario perfil);
 
    //contas inativadas há mais de 7 dias, para remoção definitiva
    List<Usuario> findByDataExclusaoBefore(LocalDateTime limite);
 
}
