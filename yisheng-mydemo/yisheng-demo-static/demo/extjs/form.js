var cityProxy = new Ext.data.MemoryProxy([
    [1, '福州市'],
    [2, '厦门市'],
    [3, '泉州市'],
    [4, '漳州市'],
    [5, '三明市']
]);

var cityReader = new Ext.data.ArrayReader({},[
	{name: 'cid', type:'int', mapping:0},
	{name: 'cname', type:'string', mapping:1}
]);

var cityStore = new Ext.data.Store({
    proxy: cityProxy,
    reader:cityReader,
    autoLoad:true //开启自动加载，一般情况下没有开启，属于延迟加载，也可以采用 cityStore.load()方法
});

function formRead1() {
	Ext.QuickTips.init();
	var MyForm = new Ext.form.FormPanel({
		title : '表单应用',
		width : 300,
		height : 200,
		x : 300,
		y : 50,
		floating : true,
		tools : [ {
			id : 'close'
		} ],
		draggable : {
			insertProxy : false,// 拖动时不虚线显示原始位置
			onDrag : function(e) {
				var pel = this.proxy.getEl();
				this.x = pel.getLeft(true);
				this.y = pel.getTop(true);// 获取拖动时panel的坐标
				var s = this.panel.getEl().shadow;
				if (s) {
					s.realign(this.x, this.y, pel.getWidth(), pel.getHeight());
				}
			},
			endDrag : function(e) {
				this.panel.setPosition(this.x, this.y);// 移动到最终位置
			}
		},
		frame : true,
		labelSeparator : ':',
		labelAlign : 'right',
		renderTo : Ext.getBody(),// 为什么这里不可以用'id1'
		items : [ new Ext.form.TextField({
			fieldLabel : '用户名称',
			allowBlank : false,
			blankText : '请输入用户名',
			msgTarget : 'side'
		}), new Ext.form.TextField({
			fieldLabel : '用户密码',
			allowBlank : false,
			inputType : 'password',
			blankText : '请输入密码',
			msgTarget : 'side'

		}) ]
	});
}
function formRead2() {
	Ext.QuickTips.init();
	var MyForm = new Ext.form.FormPanel({
		title : '表单应用',
		width : 300,
		x : 300,
		y : 50,
		floating : true,
		tools : [ {
			id : 'close'
		} ],
		frame : true,
		bodyStyle : 'padding:10px 0px 1px 1px',
		labelSeparator : ':',
		labelAlign : 'right',
		draggable : {
			insertProxy : false,// 拖动时不虚线显示原始位置
			onDrag : function(e) {
				var pel = this.proxy.getEl();
				this.x = pel.getLeft(true);
				this.y = pel.getTop(true);// 获取拖动时panel的坐标
				var s = this.panel.getEl().shadow;
				if (s) {
					s.realign(this.x, this.y, pel.getWidth(), pel.getHeight());
				}
			},
			endDrag : function(e) {
				this.panel.setPosition(this.x, this.y);// 移动到最终位置
			}
		},
		renderTo : Ext.getBody(),// 为什么这里不可以用'id1'
		defaults : {
			xtype : 'textfield',
			width : 150,
			allowBlank : false,
			msgTarget : 'side'
		},// 提取共同属性
		items : [ {
			fieldLabel : '用户名称',
			name : 'username',
			id : 'user',
			emptyText : '请输入用户名',
			blankText : '请输入用户名'
		}, {
			fieldLabel : '用户密码',
			name : 'userpassword',
			id : 'password',
			inputType : 'password',
			blankText : '请输入密码'
		} ],
		buttons : [ {
			text : "确定"
		}, {
			text : "取消",
			handler : function() {
				alert("事件！");
			}
		} ],
		buttonAlign : 'center'

	});
}

function formRead3() {
	Ext.QuickTips.init();// 初始化tips
	Ext.apply(Ext.form.VTypes, {
		password : function(val, field) {// val指这里的文本框值，field指这个文本框组件，大家要明白这个意思
			if (field.confirmTo) {// confirmTo是我们自定义的配置参数，一般用来保存另外的组件的id值
				var pwd = Ext.get(field.confirmTo);// 取得confirmTo的那个id的值
				return (val == pwd.getValue());
			}
			return true;
		}
	});
	var MyformPanel = new Ext.form.FormPanel(
			{
				title : 'fieldset的应用',
				renderTo : Ext.getBody(),
				frame : true,
				width : 550,
				x : 400,
				y : 50,
				draggable : {
					insertProxy : false,// 拖动时不虚线显示原始位置
					onDrag : function(e) {
						var pel = this.proxy.getEl();
						this.x = pel.getLeft(true);
						this.y = pel.getTop(true);// 获取拖动时panel的坐标
						var s = this.panel.getEl().shadow;
						if (s) {
							s.realign(this.x, this.y, pel.getWidth(), pel.getHeight());
						}
					},
					endDrag : function(e) {
						this.panel.setPosition(this.x, this.y);// 移动到最终位置
					}
				},
				submit : function() {
					this.getEl().dom.action = 'MyPages/GetForm.aspx', this.getEl().dom.method = 'POST', this.getEl().dom.submit();
				},
				plain : true,
				floating : true,
				items : [ {
					xtype : 'fieldset',
					checkboxToggle : true,
					checkboxName : 'user',
					title : '用户信息',
					collapsible : true,
					autoHeight : true,
					autoWidth : true,
					labelSeparator : ':',
					labelAlign : 'right',
					labelWidth : 70,
					defaults : {
						width : 150,
						allowBlank : false,
						xtype : 'textfield'
					},
					items : [ {
						fieldLabel : '用户名称',
						// emptyText:'陈建强',
						id : 'user',
						name : 'userName',
						blankText : '请输入用户名称',
						anchor : '95%'

					}, {
						fieldLabel : '用户密码',
						inputType : 'password',// password text checkbox
						// rodio
						id : 'password',
						name : 'userpassword',
						value : '0717',
						blankText : '请输入用户密码',
						anchor : '95%'
					}, {
						fieldLabel : '确认密码',
						id : 'password2',
						name : 'userpassword2',
						inputType : 'password',
						vtype : 'password',
						vtypeText : '两次输入的密码不一致',
						confirmTo : 'userpassword',
						anchor : '95%'
					}, {
						xtype : "datefield",
						fieldLabel : "出生日期",

						anchor : "95%"
					}, {
						fieldLabel : '我的博客',
						value : 'http://www.cnblogs.com/chenjq0717',
						vtype : 'url',
						vtypeText : '不是有效的url',
						id1 : 'myblog',
						name : 'myblog',
						anchor : '95%'
					}, {
						// alpha 只能输入字母，无法输入其他（如数字，特殊符号等）
						// 2.alphanum//只能输入字母和数字，无法输入其他
						// 3.email//email验证，要求的格式是"langsin@gmail.com"
						// 4.url//url格式验证，要求的格式是http://***
						fieldLabel : '电子邮箱',
						vtype : 'email',
						vtypeText : '不是有效的邮箱',
						name : 'email',
						anchor : '95%'
					}, {
						xtype : "panel",
						layout : "column",
						fieldLabel : '性别',
						isFormField : true,
						items : [ {
							columnWidth : .5,
							xtype : "radio",
							boxLabel : "男",
							name : "sex"
						// inputValue
						}, {
							columnWidth : .5,
							checked : true,
							xtype : "radio",
							boxLabel : "女",
							name : "sex"
						} ]
					}, {
						xtype : "panel",
						layout : "column",// 也可以是table,实现多列布局
						fieldLabel : '爱好',
						isFormField : true,// 非常重要,否则panel默认不显示fieldLabel
						items : [ {
							columnWidth : .5,// 宽度为50%
							xtype : "checkbox",
							boxLabel : "足球",// 显示在复选框右边的文字
							name : ""
						}, {
							columnWidth : .5,
							xtype : "checkbox",
							boxLabel : "篮球",
							name : ""
						} ]

					}, {
						xtype : 'combo',
						fieldLabel : '用户家乡',
						name : 'family',
						mode :'local',   //默认是remote远程获取模式
					    triggerAction:'all',
						store : cityStore,// 
						displayField: 'cname',  //显示的字段
					    valueField  : 'cid',    //真实的字段
						emptyText : '请选择家乡'
					}, {
						xtype : "htmleditor",
						id : "myinfo",
						fieldLabel : "个人说明",
						anchor : "99%"
					} ]
				} ],
				buttons : [ {
					text : "确定",
					handler : login,
					formBind : true
				}, {
					text : "取消",
					handler : reset
				}]
			});
	
	function login() {
		MyformPanel.form.submit();// 提交
	}
	function reset() {
		MyformPanel.form.reset();// 取消
	}
}
