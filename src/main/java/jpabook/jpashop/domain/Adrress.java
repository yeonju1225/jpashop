package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
//값 타입은 변경되면 안됨. Setter제공 X
public class Adrress {
    private String city;
    private String street;
    private String zipcode;

    //생성자에서 값을 모두 초기화해서 변경 불가능한 클래스 생성
    //public 보다 protected가 좀 더 안전
    protected Adrress() {

    }

    public Adrress(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
