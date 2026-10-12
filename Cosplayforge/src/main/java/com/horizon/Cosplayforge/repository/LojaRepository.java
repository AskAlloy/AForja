package com.horizon.Cosplayforge.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.horizon.Cosplayforge.model.Loja;
import com.horizon.Cosplayforge.model.StatusLoja;

public interface LojaRepository  extends JpaRepository<Loja, Long>{
	
	Optional<Loja>findByProprietarioID(UUID usuarioId);
	
	boolean existsByCnpj(String cnpj);
	
	List<Loja> finByStatus(StatusLoja status);

}
