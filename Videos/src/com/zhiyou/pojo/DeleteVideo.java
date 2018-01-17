package com.zhiyou.pojo;

import java.util.List;

public class DeleteVideo {
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "DeleteVideo [ids=" + ids + "]";
	}
   
}
