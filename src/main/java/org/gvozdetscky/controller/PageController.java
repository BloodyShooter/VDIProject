package org.gvozdetscky.controller;

import org.gvozdetscky.model.VM;
import org.gvozdetscky.servies.LogService;
import org.gvozdetscky.servies.VMServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private VMServies vmServies;

    @Autowired
    private LogService logService;

    /**
     * Метод возврашающий страницу где все функции его виртуальных машин
     * @return возврашает страницу
     */
    @RequestMapping("/getListVM")
    public String getListVM(Model model) {

        model.addAttribute("listVMs", vmServies.listVMs());
        model.addAttribute("logs", logService.getLogs());

        return "ListVM";
    }

    @RequestMapping("/runningVM")
    public String runningVM(@RequestParam(name = "nameVM") String nameVM) {

        int status = vmServies.startVM(nameVM);

        if (status == 1) {
            logService.addLog("Запустили ВМ " + nameVM);
        } else {
            logService.addLog("Не получилось запустить ВМ " + nameVM);
        }

        return "redirect:/getListVM";
    }

    @RequestMapping("/powerOffVM")
    public String powerOffVM(@RequestParam(name = "nameVM") String nameVM) {

        int status = vmServies.powerOffVM(nameVM);

        if (status == 1) {
            logService.addLog("Выключили ВМ " + nameVM);
        } else {
            logService.addLog("Не получилось выключить ВМ " + nameVM);
        }

        return "redirect:/getListVM";
    }

    @RequestMapping("/connectVM")
    public String connectVM(@RequestParam(name = "nameVM") String nameVM) {

        vmServies.connectVM(nameVM);

        return "redirect:/getListVM";
    }

    @RequestMapping("/createVMPage")
    public String createVMPage() {

        return "createVMPage";
    }

    @PostMapping(value = "/createVM")
    public String connectVM(@ModelAttribute VM vm) {

        vmServies.createVM(vm);

        logService.addLog("Создали машину " + vm.getName());

        return "redirect:/getListVM";
    }
}
