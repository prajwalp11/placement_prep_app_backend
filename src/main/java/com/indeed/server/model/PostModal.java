package com.indeed.server.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "posts")
@Data
public class PostModal {

    @NotNull
    @NotEmpty
    private String companyName;

    @NotNull
    @NotEmpty
    private String personName;

    @NotNull
    @NotEmpty
    private String contact;

    @NotNull
    private String jobType;

    @NotNull
    private String salary;

    @NotNull
    private String interviewExperience;

    @NotNull
    private String[] technology;

    @NotNull
    private String resourcesLink;

    @CreatedDate
    private Date createdAt;
}