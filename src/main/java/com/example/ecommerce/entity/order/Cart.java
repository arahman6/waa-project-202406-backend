package com.example.ecommerce.entity.order;

import com.example.ecommerce.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.jmx.export.annotation.ManagedNotifications;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonBackReference(value = "user-cart")
    @ToString.Exclude
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<Item> cartItems;

    public void addItem(Item item){
        cartItems.add(item);
    }

    public void removeItem(Item item){
        cartItems.remove(item);
    }

}

