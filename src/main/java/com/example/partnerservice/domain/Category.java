package com.example.partnerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    /** 카테고리 아이디 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 카테고리 명 */
    @Column(nullable = false)
    private String name;

    /** 카테고리 업종 */
    @Column(nullable = false)
    private Character type;
}
