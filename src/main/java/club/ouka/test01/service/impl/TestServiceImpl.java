package club.ouka.test01.service.impl;

import club.ouka.test01.mapper.TestMapper;
import club.ouka.test01.service.TestService;
import club.ouka.test02.mapper.TestMapper02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * User: Ouka
 * Date: 2020-02-28
 * Time: 9:28
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;
    @Autowired
    TestMapper02 testMapper02;

    @Override
    @Transactional(transactionManager = "db1TransactionManager")
    public int insert01(String name,int age) {


        int insert = testMapper.insert(name, age);
        int insert1 = testMapper02.insert(name, age);
        int i = 1/age;

        return insert+insert1;
    }

}

