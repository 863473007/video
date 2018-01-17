package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.QueryVideoVo;
import com.zhiyou.pojo.Video;
import com.zhiyou.pojo.VideoSpeaker;


public interface VideoService {

	
	public List<Video> selectAll();
	
    public List<VideoSpeaker> selectVideoByQueryVo(QueryVideoVo video);
    
    public int countVideoByQueryVo(QueryVideoVo video);
	
	public void saveOrUpdate(Video video);
	
	public int delById(int id);
	
    public void delBatchByIds(Integer[] ids);
	
	public Video selectById(int id);

	public List<Video> selectVideoByCourseId(int courseId) ;

	public int updateVideoByPrimaryKey(Video video);
	
   
}
