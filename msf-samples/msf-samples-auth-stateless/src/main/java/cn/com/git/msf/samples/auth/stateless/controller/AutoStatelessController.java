package cn.com.git.msf.samples.auth.stateless.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by serj on 2016/1/20.
 */
@RestController
public class AutoStatelessController {


    @RequestMapping("/index")
    public String index() throws Exception {
        return "index page";
    }


}
