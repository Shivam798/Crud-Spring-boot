package com.example.demo.binding;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="assets_info")
public class Asset_Info {
    @Id
    private String  name;
    private String date;
    private String conditional_note;
    private Integer asset_catagory_cid;
    private String status;
}
