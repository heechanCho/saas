package saas.tadpolehub.com.saas.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import saas.tadpolehub.com.saas.constant.ItemSellStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 상품코드

    @Column(nullable = false, length = 50)
    private String itemName; // 상품명

    @Column(name = "price", nullable = false)
    private int price; // 가격

//    @Column(nullable = false)
//    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

//    @Enumerated(EnumType.STRING)
//    private ItemSellStatus itemSellStatus;

    private LocalDateTime regTime; // 등록시간

    private LocalDateTime updateTime; // 수정시간

}
