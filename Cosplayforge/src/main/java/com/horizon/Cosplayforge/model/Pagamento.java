package com.horizon.Cosplayforge.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
 
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamento status;

    @Column(name = "mp_payment_id", unique = true)
    private String mercadoPagoPaymentId;

    @Column(name = "mp_preference_id")
    private String mercadoPagoPreferenceId;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

}
