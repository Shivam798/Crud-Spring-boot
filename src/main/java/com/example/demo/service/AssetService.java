package com.example.demo.service;

import com.example.demo.binding.Asset;
import com.example.demo.binding.Asset_Info;

import java.util.List;

public interface AssetService {
    public String upsert(Asset asset);
    public List<Asset> getAllAssetCatagory();

}
