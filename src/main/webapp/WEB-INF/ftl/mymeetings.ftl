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
                    个人中心 > 我的会议
                </div>
                <div class="pager-header">
                    <div class="header-info">
                        共<span class="info-number">${total}</span>条结果，
                        分成<span class="info-number">${pagenum}</span>页显示，
                        当前第<span class="info-number">${page}</span>页
                    </div>
                    <div class="header-nav">
                        <a type="button" class="clickbutton" href="/admin/mymeetings?page=1" >首页</a>
                        <!-- 第一页时，上页按钮隐藏-->
                        <#if 1 < page>
                            <a type="button" class="clickbutton" href="/admin/mymeetings?page=${page-1}" >上页</a>
                        </#if>
                        <!-- 最后一页时，下页按钮隐藏-->
                        <#if page<pagenum>
                            <a type="button" class="clickbutton" href="/admin/mymeetings?page=${page+1}" >下页</a>
                        </#if>
                        <a type="button" class="clickbutton" href="/admin/mymeetings?page=${pagenum}" >末页</a>
                    </div>
                </div>
                <table class="listtable">
                    <caption>我将参加的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
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
                                <td>${meeting.employeename}</td>
                                <td>
                                    <a class="clickbutton" href="meetingdetails?meetingid=${meeting.meetingid}">查看详情</a>
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