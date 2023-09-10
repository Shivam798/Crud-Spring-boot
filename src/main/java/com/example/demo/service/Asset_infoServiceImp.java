package com.example.demo.service;

import com.example.demo.binding.Asset_Info;
import com.example.demo.repo.Asset_InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Asset_infoServiceImp implements Asset_infoService {
    @Autowired
    private Asset_InfoRepository assetInfoRepo;
    @Override
    public String upsert(Asset_Info course) {
        assetInfoRepo.save(course);//insert or updates the
        return "success";
    }
    @Override
    public Asset_Info getByName(String name){
        return assetInfoRepo.findByName(name);
    }
    @Override
    public String assign(String name){
        Asset_Info asset = assetInfoRepo.findByName(name);
        String status=asset.getStatus();
        String res = null;
        if(status.equals("Assigned")){
            res="Asset is assigned to someone else";
        } else if (status.equals("Recovered") || status.equals("Available")) {
            res="Asset is assigned";
            asset.setStatus("Assigned");
        }
        assetInfoRepo.save(asset);
        return res;
    }
    @Override
    public String  recovered(String name){
        Asset_Info asset = assetInfoRepo.findByName(name);
        String status = asset.getStatus();
        String res = null;
        if(status.equals("Recovered") || status.equals("Available")){
            res="Asset is already recovered.";
        } else if (status.equals("Assigned")) {
            res="Asset is recovered";
            asset.setStatus("Recovered");
        }
        assetInfoRepo.save(asset);
        return res;
    }

//    @Override
//    public Course getByID(Integer cid) {
//        Optional<Course> findById = assetInfoRepo.findById(cid);
//        if(findById.isPresent()){
//            return findById.get();
//        }
//        return null;
//    }

    @Override
    public List<Asset_Info> getAllCourses() {
        return assetInfoRepo.findAll();

    }

    @Override
    public String deleteById(String name) {
        if(assetInfoRepo.existsById(name)){
            assetInfoRepo.deleteById(name);
            return "Delete success";
        }else{
            return "No such record found";
        }
    }
}
