package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Subject;

/**
 * @author ����ΰ   
 * @version ����ʱ�䣺2017��6��26�� ����9:57:09
 * ��˵��
 */
public interface SubjectService {

	Subject selectSubjectByPrimaryKey(int subjectId);
	List<Subject> selectAll();

	
}
