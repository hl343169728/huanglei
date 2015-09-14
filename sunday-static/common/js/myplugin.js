(function($){   
$.fn.extend({   
    myplugin:function(opt,callback){   
               var ops=$.extend({},$.fn.myplugin.default,opt);
                ops.table = (typeof ops.table == 'string' ? $(ops.table) : ops.table);
               $this = $(this); 
               var domId=$this.attr("id");
               var $domId='#'+domId;
               var header= "<div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button> "+
               "<h4 class='modal-title' id='#{domId}-Label'>#{title}</h4></div><div class='modal-body ' id='#{domId}-modalbody'> ";
              var footer="</div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal' >关闭</button>"+
              "<button type='button' class='btn btn-primary' id='#{domId}-searchbtn'>搜索</button>  "+
              "<button type='button' class='btn btn-primary' id='#{domId}-refreshbtn'>重置</button></div>  ";
              var domstr=header.replace( /#\{title\}/g,ops.title)+footer;
         			$this.append(domstr.replace( /#\{domId\}/g,domId));

              var str = "<div class='row' style='padding-top:15px;'>"+
                    "<div class='col-xs-12'>#{filterparamName}：<input class='input-medium dawfilter' name='#{filterparam}'></div>"+
                    "</div>";
              var selstr = "<div class='row' style='padding-top:15px;'>"+
                    "<div class='col-xs-12'>#{filterparamName}：<select class='input-medium dawfilter' name='#{filterparam}'>#{options}<select></div>"+
                    "</div>";
              var params=ops.filterparams;
               for (var i=0;i<params.length;i++)
                {
                  switch(params[i].type)
                  {
                  case 'select':
                    var options=""
                    var option="<option value='#{value}'>#{text}</option>"
                    var seloptoions=params[i].options
                     jQuery.map(seloptoions, function(value, key){
                        options+=option.replace( /#\{value\}/g,key).replace( /#\{text\}/g,value);
                      });
                     $($domId+'-modalbody').append(selstr.replace( /#\{filterparamName\}/g,params[i].filterparamName).replace( /#\{filterparam\}/g,params[i].filterparam).replace( /#\{options\}/g,options))
                    break;
                  default:
                      $($domId+'-modalbody').append(str.replace( /#\{filterparamName\}/g,params[i].filterparamName).replace( /#\{filterparam\}/g,params[i].filterparam));
                  } 
                
                }
              
              var btnId=$domId+'-searchbtn';
              $(btnId).click(function(){
                  var filterInputs=$($domId).find('.dawfilter');
                  var data={};
                   for (var i=0;i<filterInputs.length;i++)
                   {
                    var filter=$(filterInputs[i]);
                    var key=filter.attr('name');
                    var val=filter.val();
                    data[key]=val;
                  }
                  ops.table.jqGrid('setGridParam', {postData:data}).trigger('reloadGrid');
                              
              })

              var rebtnId=$domId+'-refreshbtn';
              $(rebtnId).click(function(){
                 var filterInputs=$($domId).find('.dawfilter');
                  var data={};
                   for (var i=0;i<filterInputs.length;i++)
                   {
                    var filter=$(filterInputs[i]);
                    var key=filter.attr('name');
                    var val='';
                    data[key]=val;
                  }
                  ops.table.jqGrid('setGridParam', {postData:data}).trigger('reloadGrid');
                              
              })

    }   
    })     

	$.fn.myplugin.default ={
              title:"搜索"
	 };       
})(jQuery); 