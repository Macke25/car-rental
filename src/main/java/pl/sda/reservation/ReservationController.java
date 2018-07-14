package pl.sda.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    ReservationDao reservationDao;


    @RequestMapping("reservation")
    public String getAllReservation(Model model) {

        List<Reservation> reservation = reservationDao.findAll();
        model.addAttribute("reservation", reservation);
        return "home/reservation";
    }

    @RequestMapping("reservationId")
    public String getReservationById(@RequestParam(name = "id") int id, Model model) {

        Reservation reservation = reservationDao.getById(id);
        model.addAttribute("reservation", reservation);
        return "home/reservation";
    }


    @PostMapping
    @RequestMapping(value = "reservationPut")
    public String updateReservation(Reservation reservation, Model model, BindingResult bindingResult) {

        reservationDao.saveOrUpdate(reservation);

        return "admin/adminPanel";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public String addReservation(Reservation reservation, Model model, BindingResult bindingResult) {

        reservationDao.save(reservation);

        return "admin/adminPanel";
    }


}
