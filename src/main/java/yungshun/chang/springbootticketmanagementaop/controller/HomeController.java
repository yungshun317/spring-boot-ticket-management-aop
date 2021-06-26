package yungshun.chang.springbootticketmanagementaop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger _logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    SecurityService securityService;

    @ResponseBody
    @RequestMapping("")
    public Map<String, Object> test() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Aloha");

        _logger.trace("{test} trace");
        _logger.debug("{test} debug");
        _logger.info("{test} info");
        _logger.warn("{test} warn");
        _logger.error("{test} error");

        return map;
    }

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

    @ResponseBody
    @RequestMapping("/security/get/subject")
    public Map<String, Object> getSubject(@RequestParam(value="token") String token) {

        String subject = securityService.getSubject(token);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", subject);

        return map;
    }
}
