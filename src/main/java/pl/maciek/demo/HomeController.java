package pl.maciek.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private AnimalRepository animalRepository;

    public HomeController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Animal> animals = animalRepository.showShelter();
        model.addAttribute("animals", animals);
        return "home";
    }
}
