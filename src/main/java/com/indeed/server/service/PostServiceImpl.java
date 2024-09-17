package com.indeed.server.service;

import com.indeed.server.dao.PostDao;
import com.indeed.server.dto.PostDTO;
import com.indeed.server.model.PostModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    public List<PostModal> getAllPosts() {
        return postDao.findAll();
    }

    @Override
    public PostModal savePost(PostDTO postDTO) {
        PostModal postModal = new PostModal();

        postModal.setCompanyName(postDTO.getCompanyName());
        postModal.setPersonName(postDTO.getPersonName());
        postModal.setContact(postDTO.getContact());
        postModal.setJobType(postDTO.getJobType());
        postModal.setSalary(postDTO.getSalary());
        postModal.setInterviewExperience(postDTO.getInterviewExperience());
        postModal.setTechnology(postDTO.getTechnology());
        postModal.setResourcesLink(postDTO.getResourcesLink());

        return postDao.save(postModal);
    }
}