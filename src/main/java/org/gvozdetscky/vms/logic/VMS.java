package org.gvozdetscky.vms.logic;

import org.gvozdetscky.cmd.CmdClass;
import org.gvozdetscky.model.VM;
import org.gvozdetscky.tools.OsUtils;

import java.util.ArrayList;
import java.util.List;

public class VMS {

    private static final String COMMAND_GET_LIST_VMS = "VBoxManage list vms";
    private static final String COMMAND_GET_RUNNING_LIST_VMS = "VBoxManage list runningvms";

    /**
     * Режим получения всех виртуальных машин из списка
     */
    public static final int ALL = 0;
    /**
     * Режим получения работающих виртуальных машин из списка
     */
    public static final int RUNNING = 1;

    public List<String> getListVMS(int mode) {
        CmdClass cmdClass = new CmdClass();
        List<String> respounse = null;
        if (mode == ALL)
            respounse = cmdClass.run(COMMAND_GET_LIST_VMS);
        else if (mode == RUNNING) {
            respounse = cmdClass.run(COMMAND_GET_RUNNING_LIST_VMS);
        }

        if (respounse == null) return null;

        List<String> vms = new ArrayList<>();

        for (String line: respounse) {
            vms.add(line.split("\"")[1]);
        }

        return vms;
    }

    /**
     * Метод для запуска виртуальной машины
     * @param name имя ВМ которую запускаем
     * @return возврашает статус
     * 1 - Все хорошо
     * 2,3 ошибка
     */
    public int startVM(String name) {
        CmdClass cmdClass = new CmdClass();

        String command = "VBoxManage startvm \"" + name + "\" --type headless";

        List<String> respounse = cmdClass.run(command);

        for (String line: respounse) {
            System.out.println(line);
        }

        if (respounse.size() == 0) return 3;

        if (respounse.get(respounse.size() - 1).contains("has been successfully started.")) return 1;

        return 2;
    }

    /**
     * Метод отключает питание на виртуальной машине
     * @param name виртуальная машина которою отрубаем
     * @return 1 в случае успеха(пока еще ничего другого не придумал)
     */
    public int powerOffVM(String name) {
        CmdClass cmdClass = new CmdClass();

        String command = "vboxmanage controlvm \"" + name + "\" poweroff";

        List<String> respounse = cmdClass.run(command);

        for (String line: respounse) {
            System.out.println(line);
        }

        return 1;
    }

    /**
     * Запускаем подключение к машине через rdp протокол
     * @param vm Виртуальная машина, откуда будет браться ip и port
     */
    public void connectVM(VM vm) {

        CmdClass cmdClass = new CmdClass();

        String command = "mstsc.exe /v:192.168.91.143 /f";

        if (OsUtils.isWindows()) {
            cmdClass.run(command);
        }
    }

    /**
     * Метод который создает ВМ и изменяет некоторые её парметры
     * Задает имя и тип ОС ВМ.
     * После изменяет параметры, такие как оператива, и проброс порта(особо с портами пока не заморачивался, проброс на
     * 22 порт гостевой машины)
     * @param vm собственно сама машина, которая будет создаватся
     * @return Возврашает статус выполнения запросов.
     */
    public int createAndConfigVM(VM vm) {
        CmdClass cmdClass = new CmdClass();
        CommandVB commandVB = new CommandVB();

        String commadCreate = commandVB.registrVM(vm.getName(), vm.getType());

        String commadCreateHdd = commandVB.createHDD(vm.getName());

        String coommandCreateSataController = commandVB.createSataController(vm.getName());

        String coommandCreateIdeController = commandVB.createIdeController(vm.getName());

        String commandModifyVM =  commandVB.modifyMemoryAndPortAndVRam(
                vm.getName(),
                Integer.toString(vm.getMemory()),
                vm.getPort()
        );

        String commandTakeHDD = commandVB.takeHDD(vm.getName(),  vm.getName() + ".vdi");

        String commandTakeDVD = commandVB.takeDVD(vm.getName(), vm.getType());



        System.out.println(commadCreate);
        System.out.println(commadCreateHdd);
        System.out.println(coommandCreateSataController);
        System.out.println(coommandCreateIdeController);
        System.out.println(commandModifyVM);
        System.out.println(commandTakeHDD);
        System.out.println(commandTakeDVD);


        List<String> respounceCreate = cmdClass.run(commadCreate);
        List<String> respounceCreateHDD = cmdClass.run(commadCreateHdd);
        List<String> respounceCreateSataController = cmdClass.run(coommandCreateSataController);
        List<String> respounceCreateIdeController = cmdClass.run(coommandCreateIdeController);
        List<String> respounceModify = cmdClass.run(commandModifyVM);
        List<String> respounceTakeHDD = cmdClass.run(commandTakeHDD);
        List<String> respounceTakeDVD = cmdClass.run(commandTakeDVD);

        System.out.println("Размеры " + respounceCreate + ", " + respounceCreateHDD.size() + ", " + respounceCreateSataController.size() + ", " + respounceCreateIdeController.size() + ", " + respounceModify.size() + ", ");

        respounceCreate.forEach(System.out::println);
        respounceCreateHDD.forEach(System.out::println);
        respounceCreateSataController.forEach(System.out::println);
        respounceCreateIdeController.forEach(System.out::println);
        respounceModify.forEach(System.out::println);
        respounceTakeHDD.forEach(System.out::println);
        respounceTakeDVD.forEach(System.out::println);


        return 1;
    }

}
