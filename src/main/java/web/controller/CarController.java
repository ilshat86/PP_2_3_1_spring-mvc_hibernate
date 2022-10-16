package web.controller;

import hiber.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import hiber.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;


    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getCars(ModelMap model, @RequestParam(required = false, defaultValue = "5", name = "count") int count) {
        List<Car> cars= carService.listUsers(count);
        model.addAttribute("cars", cars);
        return "cars";
    }

    @RequestMapping(value = "/setcars", method = RequestMethod.GET)
    public String setCar(){
        carService.add(new Car("ford", "focus", 1));
        carService.add(new Car("ford", "focus", 2));
        carService.add(new Car("ford", "focus", 3));
        carService.add(new Car("toyota", "mark", 1));
        carService.add(new Car("toyota", "mark", 2));
        return "cars";
    }
}
