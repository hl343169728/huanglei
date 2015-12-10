package com.bjsxt.test;

import java.util.ArrayList;
import java.util.List;

public class TalkService {
	private static List<String> list = new ArrayList<String>();
	public List<String> sendMsg(String msg){
		if(msg!=null&&!"".equals(msg)){
			list.add(msg);
			return list;
		}else{
			return list;
		}
	}
}
