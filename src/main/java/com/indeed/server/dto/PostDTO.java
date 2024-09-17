package com.indeed.server.dto;

import lombok.Data;

@Data
public class PostDTO {
    private String companyName;
    private String personName;
    private String contact;
    private String jobType;
    private String salary;
    private String interviewExperience;
    private String[] technology;
    private String resourcesLink;
}