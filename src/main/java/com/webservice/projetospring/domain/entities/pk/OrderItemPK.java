package com.webservice.projetospring.domain.entities.pk; //pacote para colocar as classes auxiliares para ser uma chave primaria composta

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservice.projetospring.domain.entities.Order;
import com.webservice.projetospring.domain.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Embeddable //
public class OrderItemPK {
    @ManyToOne
    @JoinColumn(name = "order_id")

    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return order.equals(that.order) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
