package yungshun.chang.springbootticketmanagementaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @ResponseBody
    @RequestMapping("/test/aop/with/execution")
    public Map<String, Object> testAOPExecution() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Aloha");

        return map;
    }

    @ResponseBody
    @RequestMapping("/test/aop/with/annotation")
    public Map<String, Object> testAOPAnnotation() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Aloha");

        return map;
    }


}
