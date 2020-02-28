package club.ouka.api;

import club.ouka.test01.service.TestService;
import club.ouka.test02.service.TestService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 * User: Ouka
 * Date: 2020-02-27
 * Time: 22:59
 */
@RestController
public class TestApi {

    @Autowired
    private TestService testService;
    @Autowired
    TestService02 testService02;

    @GetMapping("/test1")
    public int test1(String name,int age){
        return testService.insert01(name,age);
    }



    @GetMapping("/test2")
    public int test2(String name,int age){
        return testService02.insert02(name,age);
    }
}
