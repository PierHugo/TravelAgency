package model;

import javax.persistence.*;

@Entity
@Table(name = "Destination")
public class Destination
{

    /*
        @Column(name = "offer")
        private Offer offer;
    */

    @Id
    @OneToOne
    @JoinColumn(name = "offer", nullable = false)
    private Offer offer;

    @Column(name = "mustsees")
    private String mustsees;
    @Column(name = "activities")
    private String activities;
}
