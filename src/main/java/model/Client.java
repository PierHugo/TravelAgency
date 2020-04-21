package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Voter")
@DiscriminatorValue(value = "GenericUser")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client extends User
{

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "birth_date", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "has_voted", nullable = false)
    private boolean vote;

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate birth)
    {
        this.dateOfBirth = birth;
    }

    public boolean hasVoted()
    {
        return vote;
    }

    public void setVote(boolean vote)
    {
        this.vote = vote;
    }
}
