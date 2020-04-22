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
    private String price;

    @Column(name = "mustsees")
    private String mustsees;

    @Column(name = "activities")
    private String activities;

    @Column(name = "slots")
    private String slots;

    public Offer()
    {
    }

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

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getMustsees()
    {
        return mustsees;
    }

    public void setMustsees(String mustsees)
    {
        this.mustsees = mustsees;
    }

    public String getActivities()
    {
        return activities;
    }

    public void setActivities(String activities)
    {
        this.activities = activities;
    }

    public String getSlots()
    {
        return slots;
    }

    public void setSlots(String slots)
    {
        this.slots = slots;
    }
}
