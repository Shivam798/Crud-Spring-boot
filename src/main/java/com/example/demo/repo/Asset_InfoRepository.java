package com.example.demo.repo;

import com.example.demo.binding.Asset_Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface Asset_InfoRepository extends JpaRepository<Asset_Info, Serializable> {
    Asset_Info findByName(String name);

}
