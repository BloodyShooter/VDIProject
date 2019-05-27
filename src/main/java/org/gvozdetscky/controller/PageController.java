package org.gvozdetscky.controller;

import org.gvozdetscky.servies.VMServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private VMServies vmServies;

    /**
     * Метод возврашающий страницу где все функции его виртуальных машин
     * @return возврашает страницу
     */
    @RequestMapping("/getListVM")
    public String getListVM(Model model) {

        model.addAttribute("listVMs", vmServies.listVMs());

        return "ListVM";
    }

    @RequestMapping("/runningVM")
    public String runningVM(@RequestParam(name = "nameVM") String nameVM) {

        vmServies.startVM(nameVM);

        return "redirect:/getListVM";
    }

    @RequestMapping("/powerOffVM")
    public String powerOffVM(@RequestParam(name = "nameVM") String nameVM) {

        vmServies.powerOffVM(nameVM);

        return "redirect:/getListVM";
    }
}
