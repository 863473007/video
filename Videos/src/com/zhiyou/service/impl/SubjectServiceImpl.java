package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.SubjectMapper;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.SubjectExample;
import com.zhiyou.service.SubjectService;

/**
 * @author ����ΰ   
 * @version ����ʱ�䣺2017��6��26�� ����9:57:42
 * ��˵��
 */
@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;
	
	public Subject selectSubjectByPrimaryKey(int subjectId) {
		return subjectMapper.selectByPrimaryKey(subjectId);
	}

	public List<Subject> selectAll() {
		List<Subject> selectByExample = subjectMapper.selectByExample(new SubjectExample());
		return selectByExample;
	}

}
