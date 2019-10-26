package org.launchcode.cheesemvc.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.launchcode.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;


@Controller
@RequestMapping("cheese")
public class CheeseController {

//    static ArrayList<HashMap<String, String>> cheesesMapList = new ArrayList<HashMap<String, String>>();
//    static HashMap<String, String> cheesesMap = new HashMap<String, String>();

    //  Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");

//        for (Map.Entry<String, String> cheese : cheesesMap.entrySet()) {
//            System.out.println(cheese.getKey() + ": " + cheese.getValue());
//        }

//        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method= RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
//        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/add";
    }

    @RequestMapping(value = "add", method= RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {
//        @RequestParam String name, @RequestParam String description)

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }
        CheeseData.add(newCheese);
        return "redirect:";
    }
}
