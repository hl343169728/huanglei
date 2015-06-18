//数据准备Grid
var _rzdatas = [
		{
			id : '12',
			name : 'zhangsan',
			username : '张三',
			organization : '河北省',
			status : '生效',
			handle : '<a href="yhgl_bj.jsp"><span class="sd" style="text-decoration:none">用户编辑</span></a>|<a href="#"><span  style="text-decoration:none">重置密码</span></a>|<a href="#"><span  style="text-decoration:none">解锁</span></a>',
			contact : '222',
			time : new Date(1979, 09, 13)
		},
		{
			id : '13',
			name : 'lisi',
			username : '李四',
			organization : '北京市',
			status : '失效',
			handle : '<a href="#"><span class="sd" style="text-decoration:none">用户编辑</span></a>|<a href="#"><span  style="text-decoration:none">重置密码</span></a>|<a href="#"><span  style="text-decoration:none">解锁</span></a>',
			contact : '333',
			time : 'new Date(1978,10,01)'
		},
		{
			id : '14',
			name : 'wangwu',
			username : '王五',
			organization : '天津市',
			status : '生效',
			handle : '<a href="#"><span class="sd" style="text-decoration:none">用户编辑</span></a>|<a href="#"><span  style="text-decoration:none">重置密码</span></a>|<a href="#"><span  style="text-decoration:none">解锁</span></a>',
			contact : '444',
			time : 'new Date(1981,01,01)'
		},
		{
			id : '15',
			name : 'shiqian',
			username : '时迁',
			organization : '海南省',
			status : '生效',
			handle : '<a href="#"><span class="sd" style="text-decoration:none">用户编辑</span></a>|<a href="#"><span  style="text-decoration:none">重置密码</span></a>|<a href="#"><span  style="text-decoration:none">解锁</span></a>',
			contact : '444',
			time : 'new Date(1981,01,01)'
		} ];

// 注册数据模型Grid
Ext.regModel("rzmodel", {
	fields : [ 'name', 'username', 'organization', 'status', 'handle',
			'contact', 'time:' ],
	proxy : {
		// type:"ajax",
		// url:"t/jccxQuery.do?type=1",
		// reader:{type:"json",root:"ds",totalProperty: "total"}
		type : 'memory',
		// data:_xxdatas,
		reader : 'json'
	}
});


// 准备数据集Grid
var _rzStore = new Ext.data.Store({
	autoLoad : true,
	data : _rzdatas,
	model : 'rzmodel',
	pageSize : 2
});

// store
var store = Ext.create('Ext.data.TreeStore', {
	root : {
		expanded : true, // true展开
		id : '-1',
		children : [ {
			'text' : "系统",
			expanded : true,
			children : [ {
				'text' : '北京市',
				'leaf' : false,
				'id' : '1',
				children : [ {
					'text' : '海淀区',
					'leaf' : true,
					'id' : '12'
				}, {
					'text' : '朝阳区',
					'leaf' : true,
					'id' : '13'
				} ]
			}, {
				'text' : '河北省',
				'leaf' : false,
				children : [ {
					'text' : '石家庄',
					'leaf' : true,
					'id' : '14'
				}, {
					'text' : '唐山市',
					'leaf' : true,
					'id' : '15'
				} ]
			}, {
				'text' : '海南省',
				'leaf' : false,
				children : [ {
					'text' : '海口市',
					'leaf' : true,
					'id' : '16'
				} ]
			} ]
		} ]
	}
});

Ext
		.define(
				'MyApp.view.ui.zPanel',
				{
					extend : 'Ext.panel.Panel',
					title : '布局示例',
					layout : {
						type : 'table', // table布局
						columns : 2
					},

					frame : true,
					height : 700,
					width : 1600,

					renderTo : Ext.getBody(),
					defaults : {
						bodyStyle : 'background-color:#FFFFFF;',
						height : 500,
						frame : true
					},

					items : [
							{
								xtype : 'treepanel',
								id : 't_id',
								title : '基础查询',
								width : 150,
								colspan : 1, // 占一列
								split : true,
								collapsible : true,
								store : store,
								rootVisible : false,// 隐藏根节点
								// useArrows: true,//在树节点中使用箭头
								renderTo : Ext.getBody(),

								listeners : {
									itemclick : function(m, r, d, e, t) {
										var ids = r.store.getAt(e).get("id");
										// 创建Ajax代理
										var ajaxProxy = new Ext.data.proxy.Ajax(
												{
													url : '../../page/xt_yhgl/yhgl_lbServer.jsp',
													model : 'rzmodel',
													reader : 'json'
												});
										// 创建请求参数对象
										var operation = new Ext.data.Operation(
												{
													action : 'read',// 设置请求动作为read,
													id : ids
												});
										// 读取数据
										ajaxProxy
												.doRequest(operation, callBack);
										// doRequest方法的回调函数
										function callBack(operation) {
											// 获取原始响应数据
											var responseText = operation.response.responseText;

											_rzStore.removeAll();
											_rzStore.add(Ext
													.decode(responseText));

										}
										;
									}
								}

							},
							{
								xtype : 'gridpanel',
								title : '列表',
								width : 900,
								colspan : 1,
								autoScroll : true,
								// 表格上方部分
								bodyCls : "gridheader",

								tbar : [
										{
											text : '显示全部',
											handler : function() {
												var msg = '';
												var rows = me
														.getSelectionModel()
														.getSelection();
												for (var i = 0; i < rows.length; i++) {
													msg = msg
															+ rows[i]
																	.get('number')
															+ '\n';
												}
												alert(msg);
											}
										},
										{
											text : '添加新用户',
											// 触发按钮事件，弹出窗口
											listeners : {
												click : function() {
													var tjwindow = new (MyApp.view.ui.yhgl_tj);
													tjwindow.show();

												}
											}
										} ],

								renderTo : Ext.getBody(),
								store : _rzStore,
								// 定义表格前面空格
								columnLines : true,
								columns : [
										// 设置行号
										Ext.create('Ext.grid.RowNumberer', {
											text : '',
											width : 35
										}),
										{
											xtype : 'numbercolumn',
											dataIndex : 'id',
											width : 40,
											style : 'text-align:center',
											text : '序号'
										},
										{
											xtype : 'gridcolumn',
											dataIndex : 'name',
											style : 'text-align:center',
											text : '用户名'
										},
										{
											xtype : 'gridcolumn',
											dataIndex : 'username',
											width : 65,
											style : 'text-align:center',
											text : '用户姓名'
										},
										{
											xtype : 'gridcolumn',
											dataIndex : 'organization',
											width : 65,
											style : 'text-align:center',
											text : '所属组织'
										},
										{
											xtype : 'gridcolumn',
											dataIndex : 'status',
											width : 65,
											style : 'text-align:center',
											text : '用户状态'
										},
										{
											xtype : 'gridcolumn',
											dataIndex : 'handle',
											width : 140,
											style : 'text-align:center',// 居中
											text : '操作/状态'
										},
										{
											xtype : 'gridcolumn',
											dataIndex : 'contact',
											style : 'text-align:center',
											text : '联系方式'
										},
										{
											xtype : 'datecolumn',
											dataIndex : 'time',
											style : 'text-align:center',

											text : '创建时间',
											// 格式化时间显示
											renderer : Ext.util.Format
													.dateRenderer('Y-M-D h:m:d')
										} ],
								bbar : {
									xtype : "pagingtoolbar",
									pageSize : 2,
									id : "MyApp.view.ui.zPanel",
									store : _rzStore,
									beforePageText : "第 ",
									afterPageText : "页，共 {0} 页",
									firstText : "第一页",
									prevText : "前一页",
									lastText : "末页",
									nextText : "下一页",
									refreshText : "刷新",
									emptyMsg : "没有要显示的数据",
									displayInfo : true,
									displayMsg : "<span style='font-size:13px;'>显示第{0}到{1}条,共{2}条</span>",
									plugins : [ Ext.create(
											"Ext.ux.ProgressBarPager", {}) ],
									listeners : {
										change : function(pagebar, pageData,
												eOpts) {
											// alert(pageData);
										}
									}
								},
								viewConfig : {
									forcceFit : true,
									stripeRows : true
								}
							} ]

				});
