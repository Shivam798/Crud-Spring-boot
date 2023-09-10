package com.example.demo.service;

import com.example.demo.binding.Asset;
import com.example.demo.binding.Asset_Info;
import com.example.demo.repo.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssetServiceImp implements AssetService {
    @Autowired
    private AssetRepository assetRepo;
    @Override
    public String upsert(Asset catagory_asset){
        assetRepo.save(catagory_asset);
        return "Successfully add the asset catagory";
    }
    @Override
    public List<Asset> getAllAssetCatagory() {
        return assetRepo.findAll();
    }
}
