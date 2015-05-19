<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>上传文件</title>
    <link id="easyuiTheme" rel="stylesheet"
          href="resource/js/jquery-easyui-1.3.5/themes/default/easyui.css"
          type="text/css" />
    <link type="text/css" rel="stylesheet" href="resource/css/icon.css" />
    <link rel="stylesheet" type="text/css" href="resource/css/basic.css" />
    <script src="resource/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="resource/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resource/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="resource/js/ajaxfileupload.js"></script>
</head>
<body class="easyui-layout">
<div align="left" data-options="region:'center',border:false"
     style="padding-left: 20px; padding-right: 20px;">
    <form id="fileForm" action="file/uploadFile.htm?fileType=2"
          method="post" enctype="multipart/form-data">
        <div>
            <input id="img" name="file" type="file" onchange="doSubmit(this)">
            <input id="fileUrl" type="text">
        </div>
    </form>
</div>

<!-- 进度条框框 -->
<div id="progressBar_dialog" class="easyui-dialog" title="上传进度">
    <table style="padding: 5px; padding-top: 10px;" cellspacing="0" cellpadding="0" border="0">
        <tr>
            <td>
                <div id="progressNumber" class="easyui-progressbar" style="width: 400px;"></div>
            </td>
        </tr>
    </table>
</div>

<script type="text/javascript">
    var fileId;
    function doSubmit(target){
        fileId = $(target).attr("id");
        $("#fileForm").submit();
    }
    $(function() {
        //进度条对话框初始化
        $('#progressBar_dialog').dialog({
            title : '上传进度',
            width : 460,
            height : 80,
            closed : true,
            cache : false,
            modal : true,
            closable : false,
            resizable : false
        });

        $("#fileForm").ajaxForm({
            dataType : "json",
            beforeSend : function() {//上传之前设置，在这里可以写验证
                $('#progressBar_dialog').dialog({
                    closed : false
                });
            },
            uploadProgress : function(event, position, total,
                                      percentComplete) {//进度条
                $('#progressNumber').progressbar('setValue',
                        percentComplete);
            },
            success : function(data) {//成功之后执行
                var fileInput = $("#" + fileId);
                fileInput.after(fileInput.clone().val(""));
                fileInput.remove();
                $("#fileUrl").val(data.data);
            },
            complete : function(data) {
                $('#progressBar_dialog').dialog({
                    closed : true
                });
            }
        });
    });
</script>
</body>
</html>