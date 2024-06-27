package com.yasar.utility;

import java.util.UUID;

public class CodeGenerator {
    //random bir activation code oluşturacağız.
    //aksljfas-asf61askf-kqjfw-loqrwq

    public static String generatorCode() {
        String uuid = UUID.randomUUID().toString();
        String[] data = uuid.split("-");
        String code = "";

        for (int i = 0; i < data.length; i++) {
            code += data[i].charAt(0);
        }

        return code;
    }
}
