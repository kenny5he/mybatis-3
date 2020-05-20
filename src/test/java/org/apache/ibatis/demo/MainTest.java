package org.apache.ibatis.demo;

import org.apache.ibatis.demo.mapper.ICityMapper;
import org.apache.ibatis.demo.pojo.dataobject.CityDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void main(String[] args)throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    // 获取SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 获取代理类
    ICityMapper cityMapper = sqlSession.getMapper(ICityMapper.class);
    // 通过代理类调用方法
    List<CityDO> cityList = cityMapper.findCity();
    sqlSession.close();
  }
}
