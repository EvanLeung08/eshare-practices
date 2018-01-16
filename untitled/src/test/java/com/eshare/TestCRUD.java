package com.eshare;

import com.eshare.mapper.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by liangyh on 2017/11/18.
 * Email:10856214@163.com
 */
public class TestCRUD {
    @Test
    public void testSave() throws IOException {
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession session = sf.openSession();
        Configuration config  =  session.getConfiguration();
        User user = new User();
        user.setName("haha2222");
        user.setPassword("111");
        session.insert("com.eshare.mapper.UserMapper.save",user);
        session.commit();
        session.close();
    }

}
