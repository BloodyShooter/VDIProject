package org.gvozdetscky.tools;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class OsUtilsTest {

    @Test
    public void getOsName() {

        String osName = OsUtils.getOsName();

        System.out.println(osName);

        assertNotNull("Не получили имя ОС", osName);

    }

    @Ignore
    @Test
    public void isWindows() {
        if (OsUtils.isWindows()) {
            System.out.println("Это винда!!!!");
        }
    }
}