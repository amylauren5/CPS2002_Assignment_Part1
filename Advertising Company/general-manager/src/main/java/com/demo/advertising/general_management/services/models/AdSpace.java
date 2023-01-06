package com.demo.advertising.general_management.services.models;

public class AdSpace {

    //required
    private final String spaceId;
    private final String popularity;     //people viewing space per day
    private final String type;        //billboard, buses, benches
    private final String length;           //size of advertising space
    private final String width;
    private final String price;          //cost to rent space per week
    private final String minWeeks;
    private final String maxWeeks;

    //optional
    private final String busRoute;
    private final String location;
    private final String durationInterval;

    public String getSpaceId() {
        return spaceId;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getType() {
        return type;
    }

    public String getLength() {
        return length;
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

    public String getWidth() {
        return width;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public String getLocation() {
        return location;
    }

    public String getDurationInterval() {
        return durationInterval;
    }

    private AdSpace(AdSpaceBuilder builder) {
        this.spaceId = builder.spaceId;
        this.popularity = builder.popularity;
        this.type = builder.type;
        this.length = builder.length;
        this.width = builder.width;
        this.price = builder.price;
        this.minWeeks = builder.minWeeks;
        this.maxWeeks = builder.maxWeeks;
        this.busRoute = builder.busRoute;
        this.location = builder.location;
        this.durationInterval = builder.durationInterval;
    }

    //Builder Class
    public static class AdSpaceBuilder {

        // required parameters
        private String spaceId;
        private String popularity;     //people viewing space per day
        private String type;        //billboard, buses, benches
        private String price;          //cost to rent space per week
        private String length;           //size of advertising space
        private String width;
        private String minWeeks;
        private String maxWeeks;

        // optional parameters
        private String busRoute;
        private String location;
        private String durationInterval;


        public AdSpaceBuilder(String popularity, String type, String length, String width, String price, String minWeeks, String maxWeeks) {
            this.popularity = popularity;
            this.type = type;
            this.length = length;
            this.width = width;
            this.price = price;
            this.minWeeks = minWeeks;
            this.maxWeeks = maxWeeks;
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

        public AdSpaceBuilder setDurationInterval(String durationInterval) {
            this.durationInterval = durationInterval;
            return this;
        }

        public AdSpace build() {
            return new AdSpace(this);
        }
    }
}

