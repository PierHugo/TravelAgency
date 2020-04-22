package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@DiscriminatorValue(value = "GenericUser")
public class Employee extends User
{

}
