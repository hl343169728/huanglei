package com.bjsxt.test;

import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;

public class TalkService2 {
	private static List<String> list = new ArrayList<String>();
	public void sendMsg(String msg){
		if(msg != null && !"".equals(msg)){
			list.add(msg);
			Browser.withCurrentPage(new Runnable() {
				public void run() {
					ScriptSessions.addFunctionCall("list", list);
				}
			});
		}
	}
}
