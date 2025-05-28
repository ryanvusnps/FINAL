package com.example.afinal;

import java.io.Serializable;

public class Student implements Serializable {
    private String mssv_mssv_0372;
    private String name_mssv_0372;
    private String groupName_mssv_0372;
    private String topic_mssv_0372;
    private String description_mssv_0372;

    public Student(String mssv_mssv_0372, String name_mssv_0372, String groupName_mssv_0372, String topic_mssv_0372, String description_mssv_0372) {
        this.mssv_mssv_0372 = mssv_mssv_0372;
        this.name_mssv_0372 = name_mssv_0372;
        this.groupName_mssv_0372 = groupName_mssv_0372;
        this.topic_mssv_0372 = topic_mssv_0372;
        this.description_mssv_0372 = description_mssv_0372;
    }

    public String getMssv() {
        return mssv_mssv_0372;
    }

    public String getName() {
        return name_mssv_0372;
    }

    public String getGroupName() {
        return groupName_mssv_0372;
    }

    public String getTopic() {
        return topic_mssv_0372;
    }

    public String getDescription() {
        return description_mssv_0372;
    }
}