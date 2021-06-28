package com.example.demo.entity;

public class Task {
    private Integer taskid;

    private Integer achieveid;

    private String info;

    private Integer score;

    private String deadline;

    private String subline;

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Integer getAchieveid() {
        return achieveid;
    }

    public void setAchieveid(Integer achieveid) {
        this.achieveid = achieveid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }

    public String getSubline() {
        return subline;
    }

    public void setSubline(String subline) {
        this.subline = subline == null ? null : subline.trim();
    }
}