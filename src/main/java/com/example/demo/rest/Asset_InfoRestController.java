package com.example.demo.rest;

import com.example.demo.binding.Asset_Info;
import com.example.demo.service.Asset_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Asset_InfoRestController {
    @Autowired
    private Asset_infoService assetInfoService;
    @PostMapping("/asset")
    public ResponseEntity<String> createCourse(@RequestBody Asset_Info course){
        String status = assetInfoService.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

//    @GetMapping("/course/{cid}")
//    public ResponseEntity<Course> getCourse(@PathVariable Integer cid){
//        Course course =assetInfoService.getByID(cid);
//        return  new ResponseEntity<>(course,HttpStatus.OK);
//
//    }

    @GetMapping("/asset/{asset}")
    public  ResponseEntity<Asset_Info> getAsset(@PathVariable("asset") String name){
        Asset_Info asset=assetInfoService.getByName(name);
        return new ResponseEntity<>(asset,HttpStatus.OK);
    }

    @GetMapping("/assets")
    public ResponseEntity<List<Asset_Info>> getAllCourses(){
        List<Asset_Info> list = assetInfoService.getAllCourses();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PutMapping("/asset")
    public ResponseEntity<String> updateCourse(@RequestBody Asset_Info course){
        String status = assetInfoService.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @DeleteMapping("/asset/{asset}")
    public ResponseEntity<String> deleteCourse(@PathVariable("asset") String name){
        String status =assetInfoService.deleteById(name);
        return  new ResponseEntity<>(status,HttpStatus.OK);

    }

    @PutMapping("/asset/assign/{asset}")
    public ResponseEntity<String> assignAsset(@PathVariable("asset") String name){
        String status = assetInfoService.assign(name);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
    @PutMapping("/asset/recover/{asset}")
    public ResponseEntity<String> recoverAsset(@PathVariable("asset")  String name){
        String status = assetInfoService.recovered(name);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }




}
