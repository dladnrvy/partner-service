package com.example.partnerservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class Partner implements Serializable {

    /** 상점 아이디 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 상점명 */
    @Column(nullable = false)
    private String name;

    /** 카테고리 아이디 */
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Builder
    public Partner(Long id, String name, Long categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }
}
