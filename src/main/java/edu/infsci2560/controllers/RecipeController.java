package edu.infsci2560.controllers;

import edu.infsci2560.models.Recipe;
import edu.infsci2560.repositories.RecipeRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author xinyi
 */
@Controller
public class RecipeController {
    @Autowired
    private RecipeRepository repository;
    
    @RequestMapping(value = "recipe", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("recipe", "recipe", repository.findAll());
    }
    
    @RequestMapping(value = "recipe/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Recipe recipe, BindingResult result) {
        repository.save(recipe);
        return new ModelAndView("recipe", "recipe", repository.findAll());
    }
    
}