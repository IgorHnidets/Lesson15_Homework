package model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@NoArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    private String total;


    @ManyToMany( mappedBy = "items")
    private List<Cart> cartSet = new ArrayList<>();

    public Item(String total) {
        this.total = total;
    }

    public void addCart( Cart cart ){
        cartSet.add(cart);
    }
}
