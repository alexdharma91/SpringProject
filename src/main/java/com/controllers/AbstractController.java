package com.controllers;


import com.service.PersistentService;
import com.service.Reflector;

import javax.annotation.Resource;

public class AbstractController {

    @Resource
    PersistentService persistentService;

    @Resource
    Reflector reflector;

}
