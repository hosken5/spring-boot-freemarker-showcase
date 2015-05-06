<html><br>
<head><br>
    <title>Welcome!</title><br>
</head><br>
<body>
    <br>
    <br>
    <#-- 下面使用插值 -->
        <h1>Welcome ${user} !</h1><br>
        <p>We have these animals:<br>
           <u1><br/>
               test1:


        <#-- 使用FTL指令 -->
        <#list animals?sort_by("price") as being>
            <br>
            第${being_index+1}个动 物
            <br>
            <li>${being.name} for ${being.price} Euros</li>
            <br>

            <#if !being_has_next>
                <br/><br/><br/><br/>
                共有${animals?size}最后一个动物是:${being.name} <br/>
            </#if>
            <br/>
        </#list>

           <#-- 使用FTL指令 -->
           <#list animals?sort_by("price")?reverse as being>
               <br>
               第${being_index+1}个动 物
               <br>
               <li>${being.name} for ${being.price} Euros</li>
               <br>
           </#list>
                <br>
            第三个列表数据：<br/>
            <li>${animals[3].name} for ${animals[3].price} Euros</li>
        <br/>
                <p>遍历map：</p>
               <br/>
               <select>
                   <#list map?keys as k>
                        <option value="${k}">${map[k]}</option>
                    </#list>
               </select>
               <br/>
               <br/>
               <br/>
               <br/>
               <br/>
               <br/>
               <br/>
               <br/>
               <br/>
               <br/>

</body>
</html> 