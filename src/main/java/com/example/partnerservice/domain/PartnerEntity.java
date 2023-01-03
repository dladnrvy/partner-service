package com.example.partnerservice.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "partner")
public class PartnerEntity implements Serializable {

    /** 상점 아이디 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="partner_id")
    private Long partnerId;

    /** 상점명 */
    @Column(nullable = false)
    private String name;

    /** 카테고리 아이디 */
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    /** 저장일 */
    @CreatedDate
    @Column(name="partner_approved_dt")
    private LocalDateTime partnerApprovedDt;

    /** 수정일 */
    @LastModifiedDate
    @Column(name="partner_update_dt")
    private LocalDateTime partnerUpdateDt;

    @Builder
    public PartnerEntity(Long partnerId, String name, CategoryEntity category) {
        this.partnerId = partnerId;
        this.name = name;
        this.category = category;
    }
}
