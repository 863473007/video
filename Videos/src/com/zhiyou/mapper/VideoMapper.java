package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.pojo.DeleteVideoVo;
import com.zhiyou.pojo.QueryVideoVo;
import com.zhiyou.pojo.Video;
import com.zhiyou.pojo.VideoExample;
import com.zhiyou.pojo.VideoSpeaker;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExampleWithBLOBs(VideoExample example);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExampleWithBLOBs(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKeyWithBLOBs(Video record);

    int updateByPrimaryKey(Video record);
    
    List<VideoSpeaker> selectVideoListByQueryVo(QueryVideoVo video);
    
    int countVideoByQueryVo(QueryVideoVo video);
    
    void deleteBatchByIds(DeleteVideoVo vo);
    
    List<Video> selectVideoSpeakerByCourseId(int id);
    
}