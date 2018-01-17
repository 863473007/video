package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Subject;

/**
 * @author 闫振伟   
 * @version 创建时间：2017年6月26日 上午9:57:09
 * 类说明
 */
public interface SubjectService {

	Subject selectSubjectByPrimaryKey(int subjectId);
	List<Subject> selectAll();

	
}
