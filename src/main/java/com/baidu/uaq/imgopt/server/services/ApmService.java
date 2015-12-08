package com.baidu.uaq.imgopt.server.services;

import com.baidu.uaq.imgopt.server.mapper.ApmMapper;
import com.baidu.uaq.imgopt.server.po.Stat;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by baidu on 15/12/8.
 */
@Service
public class ApmService {

    @Resource
    private ApmMapper apmMapper;

    public Stat getStatById(int id) throws Exception {
        // SqlSession sqlSession = this.getSqlSession();
//        String resource = "sqlconfig/SqlMapConfig.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        ApmMapper apmMapper = sqlSession.getMapper(ApmMapper.class);

        return apmMapper.getStat(id);
    }
}
