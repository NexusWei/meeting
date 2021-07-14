<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
    </head>
    <body>
        <#include 'top.ftl'>
        <div class="page-body">
            <#include 'leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > <a href="/admin/notifications">最新通知</a>
                </div>
                <table class="listtable">
                    <caption>
                        未来7天我要参加的会议:
                    </caption>
                    <tr class="listheader">
                        <th style="width:300px">会议名称</th>
                        <th>会议室</th>
                        <th>起始时间</th>
                        <th>结束时间</th>
                        <th style="width:100px">操作</th>
                    </tr>
                    <#if meetings ??>
                        <#list meetings as meeting>
                            <tr>
                                <td>${meeting.meetingname}</td>
                                <td>${meeting.roomname}</td>
                                <td>${meeting.starttime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${meeting.endtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>
                                    <a class="clickbutton" href="meetingdetails?meetingid=${meeting.meetingid}">查看详情</a>
                                </td>
                            </tr>
                        </#list>
                    </#if>


                </table>
                <table class="listtable">
                    <caption>
                        已取消的会议:
                    </caption>
                    <tr class="listheader">
                        <th style="width:300px">会议名称</th>
                        <th>会议室</th>
                        <th>起始时间</th>
                        <th>结束时间</th>
                        <th>取消原因</th>
                        <th style="width:100px">操作</th>
                    </tr>
                    <#if mts ??>
                        <#list mts as mt>
                            <tr>
                                <td>${mt.meetingname}</td>
                                <td>${mt.roomname}</td>
                                <td>${mt.starttime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${mt.endtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td><#if mt??>${mt.cancelreason!''}</#if></td>
                                <td>
                                    <a class="clickbutton" href="meetingdetails?meetingid=${mt.meetingid}">查看详情</a>
                                </td>
                            </tr>
                        </#list>
                    </#if>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系管理员
            <img src="/images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>