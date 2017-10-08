package com.hmh.controller;

import com.hmh.common.Logger;

public class BaseController {
    public static final String FAILD = "faild";
    public static final String SUCCESS = "success";
    protected static final String MAX_LONG_AS_STRING = "9223372036854775807";

    protected Logger logger = Logger.getLogger(this.getClass());
}
