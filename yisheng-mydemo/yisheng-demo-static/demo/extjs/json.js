Ext.MessageBox.buttonText.yes = "是";
Ext.MessageBox.buttonText.no = "否";

var json = {
	Name : "陈建强",
	Sex : "男",
	Age : 26,
	Married : false,
	Marks : [ {
		name : "语文",
		Mark : 90
	}, {
		name : "数学",
		Mark : 98
	} ],
	Address : {
		City : "武汉",
		Street : "光谷大道"
	}
}

function readJson() {
	var ShowMsg = {
		title : "Json应用",
		msg : "<font color='red'>用户名：" + json.Name + "</font>" + '\n' + "年龄：" + json.Age + "数学成绩：" + json.Marks[1].Mark + "所在地址：" + json.Address.City + json.Address.Street,
		buttons : Ext.Msg.YESNO,
		icon : Ext.Msg.INFO,
		width : 300,
		// animEl : id1,
		closable : true
	}
	Ext.Msg.show(ShowMsg);
}