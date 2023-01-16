package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    //XToOne 인 경우에 fetch 설정을 LAZY로 해주어야 함.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") //맵핑할 컬럼
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 자바8에서는 하이버네이트 자동 지원

    @Enumerated(EnumType.STRING)
    private OderStatus status; // order, cancel 두가지 상태
}
