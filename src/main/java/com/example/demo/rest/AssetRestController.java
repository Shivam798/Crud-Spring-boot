package com.example.demo.rest;

import com.example.demo.binding.Asset;
import com.example.demo.binding.Asset_Info;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetRestController {
    @Autowired
    private AssetService assetService;
    @PostMapping("/assetcatagory")
    public ResponseEntity<String> createAssetCatagory(@RequestBody Asset catagory_asset){
        String status = assetService.upsert(catagory_asset);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @PutMapping("/assetcatagory")
    public ResponseEntity<String> updateAssetCatagory(@RequestBody Asset catagory_asset){
        String status = assetService.upsert(catagory_asset);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/assetcatagories")
    public ResponseEntity<List<Asset>> getAllCatagory(){
        List<Asset> list = assetService.getAllAssetCatagory();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
