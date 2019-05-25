package org.gvozdetscky.controller;

import org.gvozdetscky.lodic.vms.VMS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контролер для работы с rest-api методами
 */
@RestController
public class VMController {

    /**
     * Метод возврашающий список виртуальных машин
     * @return возврашает список виртуальных машин
     */
    @RequestMapping("/api/getListVM")
    public String getListVM() {
        VMS vms = new VMS();
        List<String> listVMS = vms.getListVMS(VMS.ALL);

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
        VMS vms = new VMS();
        List<String> listVMS = vms.getListVMS(VMS.RUNNING);

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
        VMS vms = new VMS();
        int status = vms.startVM("xubuntu");

        if (status == 1) {
            return "Запустили";
        } else {
            return "нет";
        }
    }
}
