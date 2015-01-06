<#macro navigator active>
<ul class="nav nav-tabs">
    <li <#if active== 0>class="active"</#if>>
        <a href="/employees">Сотрудники</a>
    </li>
    <li <#if active== 1>class="active"</#if>><a href="/payment-fond">Фонд выплат</a></li>
    <li <#if active== 2>class="active"</#if>><a href="/order-absence">Учет отсутствий</a></li>
</ul>
</#macro>

<#macro pageHeader headerText>
<div class="page-header">
    <h1>${headerText}</h1>
</div>
</#macro>