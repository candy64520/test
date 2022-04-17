package com.test.gaode;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GaoDeEntity {

    private static final long serialVersionUID = -4506875151642772406L;
    private String status;

    private String info;

    private String infocode;

    private String count;


    private List<GeocodesEntity> geocodes;




}
