package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.authorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {


    private final authorRepository AuthorRepository;

    public AuthorController(authorRepository authorRepository) {
        AuthorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getModels(Model model){

        model.addAttribute("authors",AuthorRepository.findAll());

        return "authors/list";
    }

}
