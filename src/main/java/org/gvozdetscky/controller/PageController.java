package org.gvozdetscky.controller;

import org.gvozdetscky.servies.VMServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    private VMServies vmServies;

    /**
     * Метод возврашающий список виртуальных машин
     * @return возврашает список виртуальных машин
     */
    @RequestMapping("/getListVM")
    public String getListVM(Model model) {

        model.addAttribute("listVMs", vmServies.listVMs());

        return "ListVM";
    }
}
