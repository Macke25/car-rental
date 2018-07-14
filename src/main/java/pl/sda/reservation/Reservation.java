package pl.sda.reservation;

import lombok.Getter;
import lombok.Setter;
import pl.sda.car.Car;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "reservationDate", nullable = false)
    private Date reservationDate;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "department_id", nullable = false)
    private String department_id;

//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client;

//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    private Car car;
//
}