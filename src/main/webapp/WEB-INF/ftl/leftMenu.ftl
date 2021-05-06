<div class="page-sidebar">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">个人中心</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="notifications.ftl">最新通知</a></li>
            <li class="sidebar-menuitem active"><a href="mybookings.ftl">我的预定</a></li>
            <li class="sidebar-menuitem"><a href="mymeetings.ftl">我的会议</a></li>
        </ul>
    </div>
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">人员管理</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="/register">员工注册</a></li>
            <#-- 只有管理员能看到的菜单 -->
            <#if currentuser?? && (currentuser.role==2)>
                <li class="sidebar-menuitem"><a href="/admin/departments">部门管理</></li>
                <li class="sidebar-menuitem"><a href="/admin/approveaccount">注册审批</a></li>
                <li class="sidebar-menuitem"><a href="/admin/searchemployees.ftl">搜索员工</a></li>
            </#if>
        </ul>
    </div>
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">会议预定</div>
        <ul class="sidebar-menu">
            <#-- 只有管理员能看到的菜单 -->
            <#if currentuser ?? &&(currentuser.role==2)>
                <li class="sidebar-menuitem"><a href="/admin/addmeetingroom.ftl">添加会议室</a></li>
            </#if>
            <li class="sidebar-menuitem"><a href="meetingrooms.ftl">查看会议室</a></li>
            <li class="sidebar-menuitem"><a href="bookmeeting.ftl">预定会议</a></li>
            <li class="sidebar-menuitem"><a href="searchmeetings.ftl">搜索会议</a></li>
        </ul>
    </div>
</div>