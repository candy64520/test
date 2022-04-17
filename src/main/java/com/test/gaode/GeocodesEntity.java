package com.test.gaode;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public @Getter
@Setter
class GeocodesEntity {

    private static final long serialVersionUID = 942508470576711519L;


    private String formattedAddress;

    private String country;

    private String province;

    private String citycode;

    private String city;

    private String district;

    private List<String> township;

    private NeighborhoodDomain neighborhood;

    private BuildingDomain building;

    private String adcode;

    private List<String> street;

    private List<String> number;

    private String location;

    private String level;

    @Getter
    @Setter
    class NeighborhoodDomain {

        private static final long serialVersionUID = 7216259952414552319L;
        private List<String> name;

        private List<String> type;
    }

    @Getter
    @Setter
    class BuildingDomain {

        private static final long serialVersionUID = -4653848900240913579L;
        private List<String> name;

        private List<String> type;
    }
}
