package com.horizon.Cosplayforge.model;

import jakarta.persistence.Entity;

import java.util.UUID;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
	 @Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    @Column(name = "id", updatable = false, nullable = false)
	    private UUID id;

	    @Column(name = "nome_cliente", nullable = false, length = 100)
	    private String nome;
	    
	    @Column(name = "nome_usuario", nullable = false, unique = true, length = 50)
	    private String nomeUsuario;

	    @Column(nullable = false, unique = true, length = 180)
	    private String email;

	    @Column(name = "senha_hash", nullable = false, length = 255)
	    private String senhaHash;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false, length = 20)
	    private PerfilUsuario perfil;


}
