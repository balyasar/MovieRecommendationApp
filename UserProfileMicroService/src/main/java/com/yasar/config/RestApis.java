package com.yasar.config;

public class RestApis {
    private static final String VERSION = "/v1";
    private static final String DEVELOPER = "/dev";
    private static final String GROUP = DEVELOPER + VERSION;

    public static final String USER = GROUP + "/user";

    public static final String FIND_ALL = "/find-all";
    public static final String UPDATE = "/update";
    public static final String FIND_BY_ID = "/find-by-id";
    public static final String DELETE_BY_ID = "/delete-by-id";
    public static final String SAVE = "/save";
    public static final String ACTIVATE_STATUS = "/activate_status";


}
