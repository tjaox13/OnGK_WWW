package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Product")
@NamedQueries({
        @NamedQuery(name = "Product.findAll",query = "from Product")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(nullable = true,unique = true,length =20 )
    private String productName;
    @Column(nullable = true,unique = true,length = 150)
    private String description;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Product(int productId, String productName, String description) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;

    }

    public Product(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +

                '}';
    }
}