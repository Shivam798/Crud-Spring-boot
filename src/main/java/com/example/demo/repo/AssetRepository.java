package com.example.demo.repo;

import com.example.demo.binding.Asset;
import com.example.demo.binding.Asset_Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AssetRepository extends JpaRepository<Asset, Serializable> {
}
