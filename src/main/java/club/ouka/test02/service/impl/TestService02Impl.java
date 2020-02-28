package club.ouka.test02.service.impl;

import club.ouka.test02.mapper.TestMapper02;
import club.ouka.test02.service.TestService02;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * User: Ouka
 * Date: 2020-02-28
 * Time: 9:28
 */
@Service("testService02")
public class TestService02Impl implements TestService02 {

    @Autowired
    TestMapper02 testMapper02;

    @Override
    @Transactional(transactionManager = "db2TransactionManager")
    public int insert02(String name,int age) {
        int insert = testMapper02.insert(name, age);
        int a = 1/age;
        return insert;
    }
}
