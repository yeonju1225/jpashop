package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
// 이론적으로는 둘다 제공하지 않고 꼭 필요한 별도의 메서드를 제공하는게 가장 이상적
// 실무에서는 데이터 조회하는 경우가 많으므로 Getter의 경우엔 열어두는게 좋다
// Setter는 데이터 변경이 가능하므로 왠만하면 닫는 것이 좋음 ( 나중에 데이터 문제로 오류가 발생하면 큰일남 )
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    // 객체는 member.id 라고하면 타입이 있기 때문에 명확함.
    // 컬럼은 id라고 다 하는 경우에는 조인할 때 불편하고, 타입이 명확하지 않아서 테이블명_id 로 사용
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Adrress adrress;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
