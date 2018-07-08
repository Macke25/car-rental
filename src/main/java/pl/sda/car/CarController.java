package pl.sda.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CarController {

	@Autowired
	private CarDao carDao;


	@RequestMapping("car")
	public String getAllCar(Model model) {

		List<Car> car = carDao.findAll();
		model.addAttribute("car", car);
		return "home/car";
	}

}