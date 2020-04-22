package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
@DiscriminatorValue(value = "GenericUser")
public class Client extends User
{
}
