<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
        <#include 'top.ftl'>
        <div class="page-body">
            <#include 'leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的预定
                </div>
                <table class="listtable">
                    <caption>我预定的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>操作</th>
                    </tr>
                    <#if meetings??>
                        <#list meetings as meeting>
                            <tr>
                                <td>${meeting.roomname}</td>
                                <td>${meeting.meetingname}</td>
                                <td>${meeting.starttime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${meeting.endtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${meeting.reservationtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>
                                    <a class="clickbutton" href="mymeetingdetails?meetingid=${meeting.meetingid}">查看/取消</a>
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