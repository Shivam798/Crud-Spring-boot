package com.example.demo.service;

import com.example.demo.binding.Asset_Info;

import java.util.List;

public interface Asset_infoService {
    public String upsert(Asset_Info assetInfo);

//    public Course getByID(Integer cid);


    public List<Asset_Info> getAllCourses();
    public String deleteById(String name);
    public Asset_Info getByName(String name);
    public String assign(String name);
    public String recovered(String name);




}
