package model;

import javax.persistence.*;

@Entity
@Table(name = "Client")
@DiscriminatorValue(value = "GenericUser")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client extends User
{
}
