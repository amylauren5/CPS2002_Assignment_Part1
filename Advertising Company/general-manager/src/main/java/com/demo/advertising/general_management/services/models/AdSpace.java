package com.demo.advertising.general_management.services.models;

public class AdSpace {

    //required
    private final String price;          //cost to rent space per week
    private final String minWeeks;
    private final String maxWeeks;

    public String getPrice() {
        return price;
    }

    public String getMinWeeks() {
        return minWeeks;
    }

    public String getMaxWeeks() {
        return maxWeeks;
    }


    private AdSpace(AdSpaceBuilder builder) {
        //people viewing space per day
        String popularity = builder.popularity;
        //billboard, buses, benches
        String type = builder.type;
        //size of advertising space
        String size = builder.size;
        this.price = builder.price;
        this.minWeeks = builder.minWeeks;
        this.maxWeeks = builder.maxWeeks;
        String index = builder.index;
        //optional
        String busRoute = builder.busRoute;
        String location = builder.location;
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

