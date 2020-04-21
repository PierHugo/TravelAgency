package model;

import javax.persistence.*;

@Entity
@Table(name = "Offer")
public class Offer
{

    /*
        @Id
        @Column(name="destination")
        @GeneratedValue(generator="gen")
        @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="offer"))
        private Destination destination;
    */

    @Id
    @OneToOne(mappedBy = "offer")
    private Destination destination;

    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private float price;

    public Offer()
    {
    }

    public Destination getDestination()
    {
        return destination;
    }

    public void setDestination(Destination destination)
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
}
