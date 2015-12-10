/**
 *  ueditor完整配置项
 *  可以在这里配置整个编辑器的特性
 */

/**************************提示********************************
 * 所有被注释的配置项的默认值就是注释项后边给的值或者是有提示默认值是多少，如果你想改，就去掉注释，修改默认值，或者在实例化编辑器时传入相应的值，就会覆盖默认的配置值
 * 每次升级编辑器时，可以直接用你改的editor_config.js直接覆盖新版本的editor_config.js,而不用担心会出现错误提示
 **************************提示********************************/


(function () {
    /**
     * 编辑器资源文件根路径。它所表示的含义是：以编辑器实例化页面为当前路径，指向编辑器资源文件（即dialog等文件夹）的路径。
     * 鉴于很多同学在使用编辑器的时候出现的种种路径问题，此处强烈建议大家使用"相对于网站根目录的相对路径"进行配置。
     * "相对于网站根目录的相对路径"也就是以斜杠开头的形如"/myProject/ueditor/"这样的路径。
     * 如果站点中有多个不在同一层级的页面需要实例化编辑器，且引用了同一UEditor的时候，此处的URL可能不适用于每个页面的编辑器。
     * 因此，UEditor提供了针对不同页面的编辑器可单独配置的根路径，具体来说，在需要实例化编辑器的页面最顶部写上如下代码即可。当然，需要令此处的URL等于对应的配置。
     * window.UEDITOR_HOME_URL = "/xxxx/xxxx/";SXTManager
     */
    var URL;

    /**
     * 此处配置写法适用于UEditor小组成员开发使用，外部部署用户请按照上述说明方式配置即可，建议保留下面两行，以兼容可在具体每个页面配置window.UEDITOR_HOME_URL的功能。
     */
    var tmp = window.location.pathname;
          //URL = window.UEDITOR_HOME_URL||tmp.substr(0,tmp.lastIndexOf("\/")+1).replace("_examples/","").replace("website/","");//这里你可以配置成ueditor目录在您网站的相对路径或者绝对路径（指以http开头的绝对路径）
			// edit oiyc
			URL =  '/Manager/js/ueditor/'; 
    /**
     * 配置项主体。注意，此处所有涉及到路径的配置别遗漏URL变量。
     */
    window.UEDITOR_CONFIG = {

        //为编辑器实例添加一个路径，这个不能被注释
        UEDITOR_HOME_URL : URL

        //工具栏上的所有的功能按钮和下拉框，可以在new编辑器的实例时选择自己需要的从新定义
        ,toolbars:[
            ['Bold', 'Italic', 'Underline', 'StrikeThrough', 'Superscript', 'Subscript', 'RemoveFormat', 'FormatMatch', 'AutoTypeSet', 'BackColor', 'ForeColor', 'FontFamily', 'FontSize', 'Paragraph', 'CustomStyle', 'RowSpacingTop', 'RowSpacingBottom', 'LineHeight', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyJustify', 'Indent', 'InsertImage', 'Emotion', 'Horizontal', 'Date', 'Time', 'Spechars', 'Attachment', 'InsertOrderedList', 'InsertUnorderedList', 'SnapScreen', 'ImageNone', 'ImageLeft', 'ImageCenter', 'ImageRight', 'InsertTable', 'DeleteTable', 'InsertRow', 'DeleteRow', 'InsertCol', 'DeleteCol', 'MergeCells', 'MergeRight', 'MergeDown', 'SplittoCells', 'SplittoRows', 'SplittoCols', 'SelectAll', 'ClearDoc', 'SearchReplace', 'Undo', 'Redo', 'Preview', 'PastePlain', 'Print', 'FullScreen', 'wordimage', 'Help']
        ]
        //当鼠标放在工具栏上时显示的tooltip提示
        ,labelMap:{
            'bold':'加粗','italic':'斜体','underline':'下划线','strikethrough':'删除线','superscript':'上标','subscript':'下标','removeformat':'清除格式','formatmatch':'格式刷','autotypeset':'自动排版','backcolor':'背景颜色','forecolor':'文字颜色','fontfamily':'字体','fontsize':'字号','paragraph':'段落格式','customstyle':'自定义样式','rowspacingtop':'段前间距','rowspacingbottom':'段后间距','lineheight':'行间距','justifyleft':'居左对齐','justifycenter':'居中对齐','justifyright':'居右对齐','justifyjustify':'两端对齐','indent':'首行缩进','insertimage':'插入图片','emotion':'插入表情','horizontal':'插入分割线','date':'插入日期','time':'插入时间','spechars':'插入特殊字符','attachment':'插入附件','insertorderedlist':'插入有序列表','insertunorderedlist':'插入无序列表','snapscreen':'截屏','imagenone':'默认','imageleft':'图片居左','imagecenter':'图片居中','imageright':'图片居右','inserttable':'插入表格','deletetable':'删除表格','insertrow':'插入行','deleterow':'删除行','insertcol':'插入列','deletecol':'删除列','mergecells':'合并单元格','mergeright':'向右合并单元格','mergedown':'向下合并单元格','splittocells':'完全拆分单元格','splittorows':'拆分成行','splittocols':'拆分成列','selectall':'全选','cleardoc':'清空文档','searchreplace':'查找替换','undo':'撤销','redo':'重做','preview':'预览','pasteplain':'纯文本粘贴','print':'打印','fullscreen':'全屏','wordimage':'图片转存','help':'帮助'
        }

        //常用配置项目
        //,isShow : true    //默认显示编辑器

        ,initialContent:''    //初始化编辑器的内容,也可以通过textarea/script给值，看官网例子

        //,autoClearinitialContent:false //是否自动清除编辑器初始内容，注意：如果focus属性设置为true,这个也为真，那么编辑器一上来就会触发导致初始化的内容看不到了

        //,iframeCssUrl: URL + '/themes/default/iframe.css' //给编辑器内部引入一个css文件

        //,textarea:'editorValue' // 提交表单时，服务器获取编辑器提交内容的所用的参数，多实例时可以给容器name属性，会将name给定的值最为每个实例的键值，不用每次实例化的时候都设置这个值

        //,focus:true //初始化时，是否让编辑器获得焦点true或false

        ,minFrameHeight:200  // 最小高度,默认320

        //,autoClearEmptyNode : true //getContent时，是否删除空的inlineElement节点（包括嵌套的情况）

        //,fullscreen : false //编辑器初始化结束后,编辑区域是否是只读的，默认是false

        //,readonly : false //编辑器层级的基数,默认是999

        //,zIndex : 999 //图片操作的浮层开关，默认打开

        //,imagePopup:true

        //,initialStyle:'body{font-size:18px}'   //编辑器内部样式,可以用来改变字体等

        //,emotionLocalization:false //是否开启表情本地化，默认关闭。若要开启请确保emotion文件夹下包含官网提供的images表情文件夹

        //,enterTag:'p' //编辑器回车标签。p或br

        //,pasteplain:false  //是否纯文本粘贴。false为不使用纯文本粘贴，true为使用纯文本粘贴

        //iframeUrlMap
        //dialog内容的路径 ～会被替换成URL,垓属性一旦打开，将覆盖所有的dialog的默认路径
        //,iframeUrlMap:{
        // 'anchor':'~/dialogs/anchor/anchor.html',
        // }

		//tab
        //点击tab键时移动的距离,tabSize倍数，tabNode什么字符做为单位
        //,tabSize:4
        //,tabNode:'&nbsp;'

		//removeFormat
        //清除格式时可以删除的标签和属性
        //removeForamtTags标签
        //,removeFormatTags:'b,big,code,del,dfn,em,font,i,ins,kbd,q,samp,small,span,strike,strong,sub,sup,tt,u,var'
        //removeFormatAttributes属性
        //,removeFormatAttributes:'class,style,lang,width,height,align,hspace,valign'
        
		//autotypeset
        //  //自动排版参数
        //  ,autotypeset:{
        //      mergeEmptyline : true,         //合并空行
        //      removeClass : true,           //去掉冗余的class
        //      removeEmptyline : false,      //去掉空行
        //      textAlign : "left" ,           //段落的排版方式，可以是 left,right,center,justify 去掉这个属性表示不执行排版
        //      imageBlockLine : 'center',      //图片的浮动方式，独占一行剧中,左右浮动，默认: center,left,right,none 去掉这个属性表示不执行排版
        //      pasteFilter : false,            //根据规则过滤没事粘贴进来的内容
        //      clearFontSize : false,          //去掉所有的内嵌字号，使用编辑器默认的字号
        //      clearFontFamily : false,        //去掉所有的内嵌字体，使用编辑器默认的字体
        //      removeEmptyNode : false ,       // 去掉空节点
        //      //可以去掉的标签
        //      removeTagNames : {标签名字:1},
        //      indent : false,                 // 行首缩进
        //      indentValue : '2em'             //行首缩进的大小
        //  }
        
		//indent
        //首行缩进距离,默认是2em
        //,indentValue:'2em'
        
		//insertimage
		//图片上传配置区	//http://localhost:8080/Manager/
        ,imageUrl:URL+"jsp/imageUp.jsp"              //图片上传提交地址
        
        // edit oiyc
        ,imagePath: "http://localhost:8080/Manager/" //图片修正地址，引用了fixedImagePath,如有特殊需求，可自行配置
        //,imageFieldName:"upfile"                   //图片描述的key,若此处修改，需要在后台对应文件修改对应参数
        //,compressSide:0                            //等比压缩的基准，确定maxImageSideLength参数的参照对象。0为按照最长边，1为按照宽度，2为按照高度
        //,maxImageSideLength:900                    //上传图片最大允许的边长，超过会自动等比缩放,不缩放就设置一个比较大的值，更多设置在image.html中

        //图片在线管理配置区
        ,imageManagerUrl:URL + "jsp/imageManager.jsp"       //图片在线管理的处理地址
        ,imageManagerPath:URL + "jsp/"                                    //图片修正地址，同imagePath
		
		//attachment
		//附件上传配置区
        
        // edit oiyc
        ,fileUrl:URL+"jsp/fileUp.jsp"                //附件上传提交地址
        ,filePath:"http://localhost:8080/Manager/"   //附件修正地址，同imagePath   
        //,fileFieldName:"upfile"                    //附件提交的表单名，若此处修改，需要在后台对应文件修改对应参数
		
		//insertorderedlist
        //有序列表的下拉配置
        //,insertorderedlist : [
        //['1,2,3...','decimal'],
        //['a,b,c...','lower-alpha'],
        //['i,ii,iii...','lower-roman'],
        //['A,B,C','upper-alpha'],
        //['I,II,III...','upper-roman']
        // ]
        
		//insertunorderedlist
        //无序列表的下拉配置
        //,insertunorderedlist : [
        //['○ 小圆圈','circle'],
        //['● 小圆点','disc'],
        //['■ 小方块','square']
        //]
        
		//snapscreen
        //屏幕截图配置区
        ,snapscreenHost: location.host                                  //屏幕截图的server端文件所在的网站地址或者ip，请不要加http://
        ,snapscreenServerUrl: URL +"jsp/imageUp.jsp" //屏幕截图的server端保存程序，UEditor的范例代码为“URL +"server/upload/jsp/snapImgUp.jsp"”
        ,snapscreenPath:""
        //,snapscreenServerPort: 80                                    //屏幕截图的server端端口
        //,snapscreenImgAlign: 'center'                                //截图的图片默认的排版方式
		
		//undo
         //可以最多回退的次数,默认20
         //,maxUndoCount:20
         //当输入的字符数超过该值时，保存一次现场
         //,maxInputCount:20
        
		//wordimage
        //word转存配置区
        ,wordImageUrl:URL + "jsp/imageUp.jsp"             //word转存提交地址
        ,wordImagePath:URL + "jsp/"                       //
        //,wordImageFieldName:"upfile"                                   //word转存表单名若此处修改，需要在后台对应文件修改对应参数
		
		//autoHeight
        // 是否自动长高,默认true
        ,autoHeightEnabled:true
        
		//wordCount
        ,wordCount:true          //是否开启字数统计
        //,maximumWords:10000       //允许的最大字符数
        //,wordCountMsg:'当前已输入 {#count} 个字符，您还可以输入{#leave} 个字符 '   //字数统计提示，{#count}代表当前字数，{#leave}代表还可以输入多少字符数
        //,wordOverFlowMsg:'<span style="color:red;">你输入的字符个数已经超出最大允许值，服务器可能会拒绝保存！</span>'    //超出字数限制提示
        
		//fontfamily
        //字体
        ,'fontfamily': [['宋体',["宋体", "SimSun"]]]
        
		//fontsize
        //字号
        ,'fontsize': ['10']
        
		//paragraph
        //段落格式 值:显示的名字
        ,'paragraph': ['p:段落']
        
		//customstyle
        //自定义样式
        //block的元素是依据设置段落的逻辑设置的，inline的元素依据BIU的逻辑设置
        //尽量使用一些常用的标签
        //参数说明
        //tag 使用的标签名字
        //label 显示的名字也是用来标识不同类型的标识符，注意这个值每个要不同，
        //style 添加的样式
        //每一个对象就是一个自定义的样式
        ,'customstyle': [{tag:'h1', label:'居中标题', style:'border-bottom:#ccc 2px solid;padding:0 4px 0 0;text-align:center;margin:0 0 20px 0;'}]
        
		//rowspacingtop
        //段间距 值和显示的名字相同
        ,'rowspacingtop':['5']
        
		//rowspacingBottom
        //段间距 值和显示的名字相同
        ,'rowspacingbottom':['5']
        
		//lineheight
        //行内间距 值和显示的名字相同
        ,'lineheight': ['1']
        
    };
})();
