package org.gvozdetscky.controller;

import org.gvozdetscky.servies.VMServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контролер для работы с rest-api методами
 */
@RestController
public class VMController {

    @Autowired
    private VMServies vmServies;

    /**
     * Метод возврашающий список виртуальных машин
     * @return возврашает список виртуальных машин
     */
    @RequestMapping("/api/getListVM")
    public String getListVM() {
        List<String> listVMS = vmServies.listAllVMs();

        String response = "";

        for (String nameVM: listVMS) {
            response += nameVM + "\n";
        }

        return response;
    }

    /**
     * Метод возврашающий список работающих виртуальных машин
     * @return возврашает список работающих виртуальных машин
     */
    @RequestMapping("/api/getListRunningVM")
    public String getListRunningVM() {
        List<String> listVMS = vmServies.listRunningVMs();

        String response = "";

        for (String nameVM: listVMS) {
            response += nameVM + "\n";
        }

        return response;
    }

    /**
     * Метод для запуска виртуальных машин
     * @return возврашает сообщение о статусе запуска виртульной машины
     */
    @RequestMapping("/api/run")
    public String runVM() {
        int status = vmServies.startVM("xubuntu");

        if (status == 1) {
            return "Запустили";
        } else {
            return "нет";
        }
    }

    /**
     * Метод для выключения виртуальных машин
     * @return возврашает сообщение о статусе выключения виртульной машины
     */
    @RequestMapping("/api/powerOff")
    public String powerOffVM() {
        int status = vmServies.powerOffVM("xubuntu");

        if (status == 1) {
            return "Вюключили";
        } else {
            return "Нет";
        }
    }
}
