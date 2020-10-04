package com.przekwas.springbootdocker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    /*it coud be a problem to access to web by localhost:8000, to check is it work go to
     docker toolbox and set "env | grep DOCKER" to check basic information. Check the DOCKER_HOST
      and insert that ip in to web browser with port 8000 and with /docker like near in mapping*/

    @Value("${environment}")
    private String environment;

    @GetMapping("/docker")
    public String docker(){
        return "This is docker " + environment;

    }
}
