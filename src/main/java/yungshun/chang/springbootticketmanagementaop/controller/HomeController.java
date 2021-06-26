package yungshun.chang.springbootticketmanagementaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import yungshun.chang.springbootticketmanagementaop.service.SecurityService;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    SecurityService securityService;

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

    @ResponseBody
    @RequestMapping("/security/generate/token")
    public Map<String, Object> generateToken(@RequestParam(value="subject") String subject) {

        String token = securityService.createToken(subject, (15 * 1000 * 60));

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", token);

        return map;
    }
}
