<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
        <style type="text/css">
        </style>

        <script src="/My97DatePicker/WdatePicker.js"></script>

    </head>
    <body>
        <#include 'top.ftl'>
        <div class="page-body">
            <#include 'leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 搜索会议
                </div>
                <form>
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <!-- value实现查询后回填的功能 -->
                                    <input type="text" value="<#if meeting??>${meeting.meetingname!''}</#if>" id="meetingname" name="meetingname" maxlength="20" />
                                </td>
                                <td>会议室名称：</td>
                                <td>
                                    <input type="text" value="<#if meetingroom??>${meetingroom.roomname!''}</#if>" id="roomname" name="roomname" maxlength="20"/>
                                </td>
                                <td>预定者姓名：</td>
                                <td>
                                    <input type="text" value="<#if employee??>${employee.employeename!''}</#if>" id="employeename" name="employeename" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预定时间：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="text" id="reservationtimefrom" name="reservationtimefrom" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})" value="<#if reservationtimefrom??>${(reservationtimefrom?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>" />
                                    到&nbsp;<input type="text" id="reservationtimeto" name="reservationtimeto" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})"  value="<#if reservationtimeto??>${(reservationtimeto?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>" />前
                                </td>
                            </tr>
                            <tr>
                                <td>会议时间：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="text" id="starttime" name="starttime" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})"  value="<#if meeting??>${(meeting.starttime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>" />
                                    到&nbsp;<input type="text" id="endtime" name="endtime" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})"  value="<#if meeting??>${(meeting.endtime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>" />前
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number">${total}</span>条结果，
                            分成<span class="info-number">${pagenum}</span>页显示，
                            当前第<span class="info-number">${page}</span>页

                            <#-- 隐藏域，分成多少页显示的值，从这里取 -->
                            <input id="pagenum" type="text" hidden value="${pagenum}">
                        </div>

                        <div class="header-nav">
                                <a type="button" class="clickbutton" href="/admin/searchmeetings?page=1&meetingname=<#if meeting??>${meeting.meetingname!''}</#if>&roomname=<#if meetingroom??>${meetingroom.roomname!''}</#if>&employeename=<#if employee??>${employee.employeename!''}</#if>&reservationtimefrom=<#if reservationtimefrom??>${(reservationtimefrom?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&reservationtimeto=<#if reservationtimeto??>${(reservationtimeto?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&starttime=<#if meeting??>${(meeting.starttime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&endtime=<#if meeting??>${(meeting.endtime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>">首页</a>
                            <#if 1<page>
                                <a type="button" class="clickbutton" href="/admin/searchmeetings?page=${page-1}&meetingname=<#if meeting??>${meeting.meetingname!''}</#if>&roomname=<#if meetingroom??>${meetingroom.roomname!''}</#if>&employeename=<#if employee??>${employee.employeename!''}</#if>&reservationtimefrom=<#if reservationtimefrom??>${(reservationtimefrom?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&reservationtimeto=<#if reservationtimeto??>${(reservationtimeto?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&starttime=<#if meeting??>${(meeting.starttime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&endtime=<#if meeting??>${(meeting.endtime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>">上页</a>
                            </#if>
                            <#if page<pagenum>
                                <a type="button" class="clickbutton" href="/admin/searchmeetings?page=${page+1}&meetingname=<#if meeting??>${meeting.meetingname!''}</#if>&roomname=<#if meetingroom??>${meetingroom.roomname!''}</#if>&employeename=<#if employee??>${employee.employeename!''}</#if>&reservationtimefrom=<#if reservationtimefrom??>${(reservationtimefrom?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&reservationtimeto=<#if reservationtimeto??>${(reservationtimeto?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&starttime=<#if meeting??>${(meeting.starttime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&endtime=<#if meeting??>${(meeting.endtime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>">下页</a>
                            </#if>
                            <a type="button" class="clickbutton" href="/admin/searchmeetings?page=${pagenum}&meetingname=<#if meeting??>${meeting.meetingname!''}</#if>&roomname=<#if meetingroom??>${meetingroom.roomname!''}</#if>&employeename=<#if employee??>${employee.employeename!''}</#if>&reservationtimefrom=<#if reservationtimefrom??>${(reservationtimefrom?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&reservationtimeto=<#if reservationtimeto??>${(reservationtimeto?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&starttime=<#if meeting??>${(meeting.starttime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>&endtime=<#if meeting??>${(meeting.endtime?string('yyyy-MM-dd HH:mm:ss'))!''}</#if>">末页</a>

                            跳到第<input type="text" id="pagenumber" name="pagenumber" class="nav-number" />页
                            <a type="submit" id="jumphref" class="clickbutton" onclick="jumphref()">跳转</a>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>会议状态</th>
                        <th>操作</th>
                    </tr>
                    <#--
                        yy 	年
                        M	年中的月份
                        D	年中的天数
                        d	月份中的天数
                        H	一天中的小时数（0-23）
                        h	am/pm 中的小时数（1-12）
                        m	小时中的分钟数
                        s	分钟中的秒数
                        S	毫秒数
                        所以连起来应该是 yy-MM-dd HH:mm:ss
                    -->
                    <#if meetings ??>
                        <#list meetings as meeting>
                            <tr>
                                <td>${meeting.meetingname}</td>
                                <td>${meeting.roomname}</td>
                                <td>${meeting.starttime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${meeting.endtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${meeting.reservationtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${meeting.employeename}</td>
                                <td>${(meeting.status==1)?string('正常','已取消')}</td>
                                <td>
                                    <a class="clickbutton" href="/admin/meetingdetails?meetingid=${meeting.meetingid}">查看详情</a>
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

        <#-- freemarker实现跳转实在困难，毫无头绪，还是用js吧。 -->
        <script src="/styles/jquery.js"></script>
        <script type="text/javascript">
            function jumphref()
            {
                let pagenumber = $("#pagenumber").val();
                let meetingname = $("#meetingname").val();
                let roomname = $("#roomname").val();
                let employeename = $("#employeename").val();
                let pagenum = $("#pagenum").val();
                let error = $("#error")
                let reservationtimefrom = $("#reservationtimefrom").val();
                let reservationtimeto = $("#reservationtimeto").val();
                let starttime = $("#starttime").val();
                let endtime = $("#endtime").val();

                if (pagenumber <= pagenum){
                    $("#jumphref").attr("href","/admin/searchmeetings?page="+pagenumber+"&meetingname="+meetingname+"&roomname="+roomname+"&employeename="+employeename+"&reservationtimefrom="+reservationtimefrom+"&reservationtimeto="+reservationtimeto+"&starttime="+starttime+"&endtime="+endtime);
                }else {
                    $("#jumphref").attr("href","/admin/searchmeetings?page="+pagenum+"&meetingname="+meetingname+"&roomname="+roomname+"&employeename="+employeename+"&reservationtimefrom="+reservationtimefrom+"&reservationtimeto="+reservationtimeto+"&starttime="+starttime+"&endtime="+endtime);
                }
            }
        </script>

    </body>
</html>