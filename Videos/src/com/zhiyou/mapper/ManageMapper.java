package com.zhiyou.mapper;

import com.zhiyou.pojo.Manage;
import com.zhiyou.pojo.ManageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManageMapper {
    int countByExample(ManageExample example);

    int deleteByExample(ManageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Manage record);

    int insertSelective(Manage record);

    List<Manage> selectByExample(ManageExample example);

    Manage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Manage record, @Param("example") ManageExample example);

    int updateByExample(@Param("record") Manage record, @Param("example") ManageExample example);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
}