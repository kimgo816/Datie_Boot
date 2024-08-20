package org.zerock.datie_boot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payno; //결제번호

    private int companyno; //업체번호
    private int amount; //금액
    private int peramount; //개인별결제금액
    private int bonus; //금액 - 개인별결제금액*2
    private String content; //결제내용

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime confirmdate; //결제시각
    private int payState; //결제상태

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardno")
    private Card card; // 카드 정보

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyno", insertable = false, updatable = false)
    private Company company; // 회사 정보


    public String getCompanyname() {
        return company != null ? company.getCompanyname() : null;
    }
}
