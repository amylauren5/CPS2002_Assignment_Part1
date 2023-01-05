package com.demo.advertising.general_management.services.models;

public class AdSpace {

    //required
    private final String spaceId;
    private final String popularity;     //people viewing space per day
    private final String type;        //billboard, buses, benches
    private final String size;           //size of advertising space
    private final String price;          //cost to rent space per week
    private final String minWeeks;
    private final String maxWeeks;
    private final String index;

    //optional
    private final String busRoute;
    private final String location;

    public String getSpaceId() {
        return spaceId;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String getMinWeeks() {
        return minWeeks;
    }

    public String getMaxWeeks() {
        return maxWeeks;
    }

    public String getIndex() {
        return index;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public String getLocation() {
        return location;
    }

    private AdSpace(AdSpaceBuilder builder) {
        this.spaceId = builder.spaceId;
        this.popularity = builder.popularity;
        this.type = builder.type;
        this.size = builder.size;
        this.price = builder.price;
        this.minWeeks = builder.minWeeks;
        this.maxWeeks = builder.maxWeeks;
        this.index = builder.index;
        this.busRoute = builder.busRoute;
        this.location = builder.location;
    }

    //Builder Class
    public static class AdSpaceBuilder {

        // required parameters
        private String spaceId;
        private String popularity;     //people viewing space per day
        private String type;        //billboard, buses, benches
        private String size;           //size of advertising space
        private String price;          //cost to rent space per week
        private String minWeeks;
        private String maxWeeks;
        private String index;

        // optional parameters
        private String busRoute;
        private String location;

        public AdSpaceBuilder(String popularity, String type, String size, String price, String minWeeks, String maxWeeks, String index) {
            this.popularity = popularity;
            this.type = type;
            this.size = size;
            this.price = price;
            this.minWeeks = minWeeks;
            this.maxWeeks = maxWeeks;
            this.index = index;
        }

        public AdSpaceBuilder setBusRoute(String busRoute) {
            this.busRoute = busRoute;
            return this;
        }

        public AdSpaceBuilder setLocation(String location) {
            this.location = location;
            return this;
        }

        public AdSpaceBuilder setSpaceId(String spaceId) {
            this.spaceId = spaceId;
            return this;
        }

        public AdSpace build() {
            return new AdSpace(this);
        }
    }
}

