package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.CarDao;
import web.model.Car;

@Controller
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private final CarDao carDAO;

	public CarController(CarDao carDao){
		this.carDAO = carDao;
	}

	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("cars",carDAO.index());
		return "cars/index";
	}

	@GetMapping("/{id}")
	public String indexCount(@PathVariable ("id") int id,Model model) {
		model.addAttribute("car",carDAO.indexCount(id));
		return "cars/indexCount";
	}

	@GetMapping("/new")
	public String newCar(Model model){
		model.addAttribute("car",new Car());
		return "cars/NewCar";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute("car")Car car){
		carDAO.save(car);
		return "redirect:/cars/index";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") int id){
		model.addAttribute("car", carDAO.indexCount(id));
		return "cars/edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("car") Car car,@PathVariable("id") int id){
		carDAO.update(id,car);
		return "redirect:/cars/index";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id){
		carDAO.delete(id);
		return "redirect:/cars/index";
	}

}