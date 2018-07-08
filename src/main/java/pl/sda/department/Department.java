package pl.sda.department;

import lombok.Getter;
import lombok.Setter;
import pl.sda.car.Car;
import pl.sda.worker.Worker;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name="department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "car_id", nullable = false)
    private int car_id;
//    @OneToMany(mappedBy="department")
//    private List<Worker> worker;

//    @ManyToOne
//    private Car car;

}