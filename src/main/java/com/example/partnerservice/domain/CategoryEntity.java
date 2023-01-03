package com.example.partnerservice.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "category")
public class CategoryEntity {
    /** 카테고리 아이디 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long categoryId;

    /** 카테고리 명 */
    @Column(nullable = false)
    private String name;

    /** 카테고리 업종 */
    @Column(nullable = false)
    private Character type;

    /** 저장일 */
    @CreatedDate
    @Column(name="category_approved_dt")
    private LocalDateTime categoryApprovedDt;

    /** 수정일 */
    @LastModifiedDate
    @Column(name="category_update_dt")
    private LocalDateTime categoryUpdateDt;

    @Builder
    public CategoryEntity(Long categoryId, String name, Character type) {
        this.categoryId = categoryId;
        this.name = name;
        this.type = type;
    }
}
