package com.nexus.meeting.model;

import java.util.Date;

public class Meeting {
    private Integer meetingid;
    private String meetingname;
    private Integer roomid;
    private Integer reservationistid;
    private Integer numberofparticipants;
    private Date starttime;
    private Date endtime;
    private Date reservationtime;
    private Date canceledtime;
    private String description;
    private Integer status;

    private String roomname;
    private String employeename;

    private String cancelreason;

    public String getCancelreason() {
        return cancelreason;
    }

    public void setCancelreason(String cancelreason) {
        this.cancelreason = cancelreason;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingid=" + meetingid +
                ", meetingname='" + meetingname + '\'' +
                ", roomid=" + roomid +
                ", reservationistid=" + reservationistid +
                ", numberofparticipants=" + numberofparticipants +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", reservationtime=" + reservationtime +
                ", canceledtime=" + canceledtime +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", roomname='" + roomname + '\'' +
                ", employeename='" + employeename + '\'' +
                ", cancelreason='" + cancelreason + '\'' +
                '}';
    }

    public Integer getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(Integer meetingid) {
        this.meetingid = meetingid;
    }

    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getReservationistid() {
        return reservationistid;
    }

    public void setReservationistid(Integer reservationistid) {
        this.reservationistid = reservationistid;
    }

    public Integer getNumberofparticipants() {
        return numberofparticipants;
    }

    public void setNumberofparticipants(Integer numberofparticipants) {
        this.numberofparticipants = numberofparticipants;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getReservationtime() {
        return reservationtime;
    }

    public void setReservationtime(Date reservationtime) {
        this.reservationtime = reservationtime;
    }

    public Date getCanceledtime() {
        return canceledtime;
    }

    public void setCanceledtime(Date canceledtime) {
        this.canceledtime = canceledtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
