<!DOCTYPE html>
<#include "displaySize.ftl">
<html>
<head>
    <title>Hello Spring Boot!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
Date: ${time?date}
<br>
Time: ${time?time}
<br>
Message: ${message}
<br/>

<#assign x = "something">
测试自定义方法：
indexof met:${indexOf("met", x)}
<br/>
indexof foo : ${indexOf("foo", x)}
<br/>
测试默认值：
${user!"Anonymous"}
<br/>

staticMethod:
${static("/sdfsd/sdfsd/sdfs")}
<br/>

url方法：
url("/sdfsd/sdfsd/sdfs",{"a":"1","b":"天"})
${url("/sdfsd/sdfsd/sdfs",{"a":"1","b":"天"})}

<br/>
<br/>
演示自定义指令：
<@upper>
<br/>
bar
<#-- All kind of FTL is allowed here -->
    <#list ["red", "green", "blue"] as color>
    <br/>
    ${color}
    </#list>
    baaz
</@upper>

<#assign x = 1>

一个参数：
<@repeat count=4>
Test ${x}
    <#assign x = x + 1>
</@repeat>

二个参数：
<@repeat count=3 hr=true>
Test
</@repeat>

循环变量：
<@repeat count=3; cnt>
${cnt}. Test
</@repeat>

displaySize:
<div>${displaySize(1024*1024*1024*2+100)}
</div>
<div>${displaySize(1024*1024*3+100)}
</div>
<div>${displaySize(1024*5+100)}
</div>
<div>${displaySize(400)}
</div>

</body>
</html>