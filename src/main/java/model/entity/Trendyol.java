package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "trendyol")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trendyol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(updatable = false,nullable = false,name = "trendyol_name")
    private String Name;
    @Column(nullable = false,name = "total_amount")
    @Builder.Default
    private BigDecimal accountBalance = BigDecimal.valueOf(90000);
}
