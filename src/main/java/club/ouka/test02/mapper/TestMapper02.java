package club.ouka.test02.mapper;

import club.ouka.entitry.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * User: Ouka
 * Date: 2020-02-28
 * Time: 10:00
 */
@Mapper
public interface TestMapper02 {


    int insert(@Param("name") String name, @Param("age") int age);


    Test selectByPrimaryKey(Long id);
}
