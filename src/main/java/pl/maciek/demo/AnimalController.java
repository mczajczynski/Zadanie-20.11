package pl.maciek.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Controller
public class AnimalController {

    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) { //ooo właśnie tutaj musi być zwykły
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animal/{id}")
    public String animalDetails(@PathVariable Long id, Model model) {

        Animal animal = animalRepository.findAnimalId(id);
        model.addAttribute("animal", animal);
        return "animal";
    }
}
