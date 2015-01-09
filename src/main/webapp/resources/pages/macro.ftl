<#macro navigator active>
<ul class="nav nav-tabs">
    <li <#if active== 0>class="active"</#if>>
        <a href="/employee/show">Сотрудники</a>
    </li>
    <li <#if active== 1>class="active"</#if>><a href="/payment/show">Фонд выплат</a></li>
    <li <#if active== 2>class="active"</#if>><a href="/absence/show">Учет отсутствий</a></li>
</ul>
</#macro>

<#macro pageHeader headerText>
<div class="page-header">
    <h1>${headerText}</h1>
</div>
</#macro>