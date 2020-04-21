package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Offer")
public class Offer
{
    @Id
    @Column(name = "destination")
    private String destination;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private float price;
    @Column(name = "discount")
    private String discount;

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getDiscount()
    {
        return discount;
    }

    public void setDiscount(String discount)
    {
        this.discount = discount;
    }
}
