package com.horizon.Cosplayforge.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;

@Entity
@Table(name = "Categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(nullable = false, unique = true,length = 100)
	private String nome;
	
	@Column(length = 255)
	private String descricao;
	
	@Column(name = "data_cadastro", nullable = false, updatable = false)
	private LocalDateTime dataCadastro;
	
	@Column(name = "data_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;
	
	@PrePersist
    protected void aoCriar() {
        LocalDateTime agora = LocalDateTime.now();
        this.dataCadastro = agora;
        this.dataAtualizacao = agora;
    }
 
    @PreUpdate
    protected void aoAtualizar() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
