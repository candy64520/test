package com.test.gaode003;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public @Getter
@Setter
class GeocodesEntity {

    private static final long serialVersionUID = 942508470576711519L;


    @ReflectTag
    private String formattedAddress;
    @ReflectTag
    private String country;
    @ReflectTag
    private String province;
    @ReflectTag
    private String citycode;
    @ReflectTag
    private String city;
    @ReflectTag
    private String district;

    private List<String> township;
    @ReflectTag
    private NeighborhoodDomain neighborhood;
    @ReflectTag
    private BuildingDomain building;
    @ReflectTag
    private String adcode;

    private List<String> street;

    private List<String> number;
    @ReflectTag
    private String location;
    @ReflectTag
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
