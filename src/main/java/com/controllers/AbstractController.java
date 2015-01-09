package com.controllers;


import com.service.PersistentService;

import javax.annotation.Resource;

public class AbstractController {

    @Resource
    PersistentService persistentService;

}
