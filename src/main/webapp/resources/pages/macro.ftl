<#macro navigator active>
<ul class="nav nav-tabs">
    <li <#if active== 0>class="active"</#if>>
        <a href="/employee/show">Сотрудники</a>
    </li>
    <li <#if active== 1>class="active"</#if>><a href="/payout/show">Фонд выплат</a></li>
    <li <#if active== 2>class="active"</#if>><a href="/absence/show">Учет отсутствий</a></li>
</ul>
</#macro>

<#macro pageHeader headerText>
<div class="page-header">
    <h1>${headerText}</h1>
</div>
</#macro>

<#macro mainPageLink page>

<ul class="nav nav-tabs">
    <#switch page>
        <#case "epmloyee">
            <li>
                <a href="/employee/show">Сотрудники</a>
            </li>
            <#break>
        <#case "payout">
            <li>
                <a href="/payout/show">Сотрудники</a>
            </li>
            <#break>
        <#case "absence">
            <li>
                <a href="/absence/show">Сотрудники</a>
            </li>
            <#break>
    </#switch>
</ul>

</#macro>