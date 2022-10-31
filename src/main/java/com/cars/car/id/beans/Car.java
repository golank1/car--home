package com.cars.car.id.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Car {
    private int id;
    private long mispar_rechev;
    private String tozeret_nm; //שם תוצר
    private String degem_nm; // שם דגם
    private int shnat_yitzur;
    private Date mivchan_acharon_dt;
    private Date tokef_dt;
    private String tzeva_rechev;
    private String sug_delek_nm;
    private String moed_aliya_lakvish;
}
