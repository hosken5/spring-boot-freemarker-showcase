<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 实例 - 进度条</title>
     <link href="/bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bower_components/jquery/dist/jquery.js"></script>
    <script src="/bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <script src="/bower_components/bootstrap-progressbar/bootstrap-progressbar.js"></script>
    <script>
        $(document).ready(function(){
            var per =  10 ;
            $("#button1").bind("click",function(){
                per = (per+10 )%100;
                console.log(per);
                $("#progess-bar").css("width",per+"%");
                $("#progess-bar-number").text(per);
                $('.progress .progress-bar').attr("data-transitiongoal",per);
                $('.progress .progress-bar').progressbar({display_text:"center"});
            });
        });
    </script>
</head>
<body>

<div class="progress">
    <div class="progress-bar" role="progressbar"   data-transitiongoal="75"></div>
</div>

<!--
<div class="progress" style="width: 50%">
    <div id ="progess-bar" class="progress-bar" role="progressbar" aria-valuenow="60"
         aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
    </div>
</div>
 -->
<span id="progess-bar-number">0</span><span>% 完成</span>
<button id="button1"  >按钮</button>
</body>
</html>