<#function displaySize size>
    <#assign sizeview="">
    <#if (size?string)!="">
        <#assign sizeview="<1M">
        <#if (size >= 1024*1024*1024)>
            <#assign sizeview=(size/1024/1024/1024)?string("#0")+"G">
        <#elseif (size >= 1024*1024)>
            <#assign sizeview=(size/1024/1024)?string("#0")+"M">
        <#elseif (size >= 1024)>
            <#assign sizeview=(size/1024)?string("#0") + "K">
        </#if>
    </#if>
    <#return sizeview>
</#function>