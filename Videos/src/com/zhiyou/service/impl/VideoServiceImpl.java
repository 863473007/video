package com.zhiyou.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.VideoMapper;
import com.zhiyou.pojo.DeleteVideoVo;
import com.zhiyou.pojo.QueryVideoVo;
import com.zhiyou.pojo.Video;
import com.zhiyou.pojo.VideoExample;
import com.zhiyou.pojo.VideoExample.Criteria;
import com.zhiyou.pojo.VideoSpeaker;
import com.zhiyou.service.VideoService;


@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoMapper videoMapper;
	
	public List<Video> selectAll(){
		
		return videoMapper.selectByExampleWithBLOBs(new VideoExample());
	}
	
    public List<VideoSpeaker> selectVideoByQueryVo(QueryVideoVo video){
		
		return videoMapper.selectVideoListByQueryVo(video);
	}
    
    public int countVideoByQueryVo(QueryVideoVo video){
    	
    	return videoMapper.countVideoByQueryVo(video);
    	
    	
    }
	
	public void saveOrUpdate(Video video){
		
		if(null!=video.getId() && video.getId()!=0){
			videoMapper.updateByPrimaryKeyWithBLOBs(video);
		}else{
			video.setPlayNum(0);
			videoMapper.insert(video);
		}
	}
	
	public int delById(int id){
		return videoMapper.deleteByPrimaryKey(id);
	}
	
   public void delBatchByIds(Integer[] ids){
		
		VideoExample example = new VideoExample();
		// ctrl + 1  �Զ������ֶ�
		 Criteria createCriteria = example.createCriteria();
		 //delete from video where id in(1,2,3,5);
		 
		 //����ת��Ϊһ������
		 List<Integer> list = new ArrayList<Integer>();
		 Collections.addAll(list, ids);
		 // createCriteria.andIdIn(list);
		 DeleteVideoVo vo = new DeleteVideoVo();
		 vo.setIds(list);
		 videoMapper.deleteBatchByIds(vo);
	}
	
	public Video selectById(int id){
		
		return videoMapper.selectByPrimaryKey(id);
	}

	public List<Video> selectVideoByCourseId(int courseId) {
		
		/*VideoExample example = new VideoExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCourseIdEqualTo(courseId);*/
		//д  д д
		
		return videoMapper.selectVideoSpeakerByCourseId(courseId);
	}

	public int updateVideoByPrimaryKey(Video video) {
		// TODO Auto-generated method stub
		return videoMapper.updateByPrimaryKeySelective(video);
	}
	
   
}
