function readForm() {

	Ext.QuickTips.init();

	var form1 = new Ext.FormPanel(
			{
				layout : 'form',
				collapsible : true,
				autoHeight : true,
				frame : true,
				renderTo : Ext.getBody(),
				title : '<center style="curor:hand" onclick="window.location.reload();">表单控件</center>',
				style : 'margin-left:auto;margin-right:auto;width:500px;margin-top:8px;',
				// 设置标签对齐方式
				labelAlign : 'right',
				// 设置标签宽
				labelWidth : 170,
				// 设置按钮的对齐方式
				buttonAlign : 'center',
				// 默认元素属性设置
				defaults : {
					width : 180
				},
				items : [ {
					fieldLabel : '文本框控件',
					name : 'TextBox',
					xtype : 'textfield'
				// ,readOnly : true //只读
				// ,emptyText :'请输入数据' //为空时显示的文本，注意不是value
				}, {
					fieldLabel : '只允许输入数字',
					name : 'TextBoxNumber',
					xtype : 'numberfield'
				// ,allowDecimals: false // 允许小数点
				// ,allowNegative: false, // 允许负数
				// ,maxValue:1000 //最大值
				// ,minValue:0 //最小值
				}, {
					fieldLabel : '下拉框控件',
					name : 'DropDownList',
					xtype : 'combo',
					// 本地数据源 local/remote
					mode : 'local',
					// 设置为选项的text的字段
					displayField : "Name",
					// 设置为选项的value的字段
					valueField : "Id",
					// 是否可以输入，还是只能选择下拉框中的选项
					editable : false,
					typeAhead : true,
					// 必须选择一项
					// forceSelection: true,
					// 输入部分选项内容匹配的时候显示所有的选项
					triggerAction : 'all',
					// selectOnFocus:true,
					// 数据
					store : new Ext.data.SimpleStore({
						fields : [ 'Id', 'Name' ],
						data : [ [ 1, '男' ], [ 0, '女' ] ]
					})
				}, {
					fieldLabel : '日历控件',
					xtype : 'datefield',
					name : 'DateControl',
					format : "Y-m-d",
					editable : false
				// , 默认当前日期
				// value:new Date().dateFormat('Y-m-d')
				}, {
					fieldLabel : '单选控件',
					xtype : 'radiogroup',
					name : 'Radios',
					items : [ {
						name : 'RadioItems',
						boxLabel : '选我',
						inputValue : '1',
						checked : true
					}, {
						name : 'RadioItems',
						boxLabel : '选我吧',
						inputValue : '0'
					} ]
				}, {
					fieldLabel : '复选控件',
					xtype : 'checkboxgroup',
					name : 'Checkboxs'
					// columns属性表示用2行来显示数据
					,
					columns : 2,
					items : [ {
						name : 'CheckboxItems',
						boxLabel : '香蕉',
						inputValue : 'A'
					}, {
						name : 'CheckboxItems',
						boxLabel : '苹果',
						inputValue : 'B'
					}, {
						name : 'CheckboxItems',
						boxLabel : '橘子',
						inputValue : 'C'
					}, {
						name : 'CheckboxItems',
						boxLabel : '桃子',
						inputValue : 'D'
					} ]
				}, {
					fieldLabel : '文本域控件',
					xtype : 'textarea',
					value : '可以输好多字！',
					height : 50
				}, {
					fieldLabel : '时间控件',
					xtype : 'timefield'
					// 格式化输出 默认为 "g:i A"
					// "g:ia|g:iA|g:i a|g:i A|h:i|g:i|H:i|ga|ha|gA|h a|g
					// a|g A|gi|hi|gia|hia|g|H"
					,
					format : 'H:i'
					// 时间间隔(分钟)
					,
					increment : 60
				}, {
					fieldLabel : '标签页',
					xtype : 'fieldset',
					title : '标签页',
					autoHeight : true,
					items : [ {
						xtype : 'panel',
						title : '标签页中的面板',
						frame : true,
						height : 50
					} ]
				}, {
					fieldLabel : '在线编辑器',
					xtype : 'htmleditor',
					width : 260,
					height : 100
				// 以下为默认选项，其他请参照源代码
				// ,enableColors: false
				// ,enableFormat : true
				// ,enableFontSize : true
				// ,enableAlignments : true
				// ,enableLists : true
				// ,enableSourceEdit : true
				// ,enableLinks : true
				// ,enableFont : true
				} ],
				buttons : [ {
					text : "保 存",
					handler : function() {
						MsgInfo('保存');
					}
				}, {
					text : "取 消",
					handler : function() {
						form1.form.reset();
					}
				} ]
			});

	function MsgInfo(str_msg) {
		Ext.MessageBox.show({
			title : '提示',
			msg : str_msg,
			width : 400,
			icon : Ext.MessageBox.INFO,
			buttons : Ext.MessageBox.OK
		});
	}
}
