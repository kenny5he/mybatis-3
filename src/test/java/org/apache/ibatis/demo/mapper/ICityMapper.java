package org.apache.ibatis.demo.mapper;

import org.apache.ibatis.demo.pojo.dataobject.CityDO;

import java.util.List;

public interface ICityMapper {

  List<CityDO> findCity();

}
