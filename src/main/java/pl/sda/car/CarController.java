package pl.sda.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping("carId")
    public String getCarById(@RequestParam(name = "id") int id, Model model) {

        Car car = carDao.getById(id);
        model.addAttribute("car", car);
        return "home/car";
    }

    @GetMapping
    @RequestMapping(value = "carDel")
    public String deleteCar(HttpServletRequest request , @RequestParam(name = "id") int id, Model model) {

        carDao.delete(id);

        return getPreviousPageByRequest(request).orElse("/");
    }

    @PostMapping
    @RequestMapping(value = "carPut")
    public String updateCar(Car car, Model model, BindingResult bindingResult) {

	    carDao.saveOrUpdate(car);

        return "admin/adminPanel";
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public String addCar(Car car, Model model, BindingResult bindingResult) {

        carDao.save(car);

        return "admin/adminPanel";
    }












/*  Problem with returning to previous page from either adminPanel or customer view using the same function with redirect
    https://stackoverflow.com/questions/804581/spring-mvc-controller-redirect-to-previous-page
    ("may be not reliable: en.wikipedia.org/wiki/HTTP_referrer#Referrer_hiding")
    ("This will not work if there was a validation error while editing the pony and the user is returned to the edit pony page. Because now the referer will point to the edit pony page")
    ("My answer is alike to Sam Brodkins´s (i recomended it also). But having in count that the "Referer" value may not be available i made this function to use it in my controllers")
*/
    /**
     * Returns the viewName to return for coming back to the sender url
     *
     * @param request Instance of {@link HttpServletRequest} or use an injected instance
     * @return Optional with the view name. Recomended to use an alternativa url with
     * {@link Optional#orElse(java.lang.Object)}
     */
    protected Optional<String> getPreviousPageByRequest(HttpServletRequest request)
    {
        return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl);
    }

}