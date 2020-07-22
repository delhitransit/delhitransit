/*
 * @author Tanmay Singal
 */

package com.delhitransit.core.model;

import lombok.Getter;

/**
 * For more information see https://developers.google.com/transit/gtfs/reference/#stopstxt
 */
public class Stop {

    /**
     * Identifies a stop, station, or station entrance.
     *
     * The term "station entrance" refers to both station entrances and station exits. Stops, stations or station
     * entrances are collectively referred to as locations. Multiple routes may use the same stop.
     */
    @Getter
    private long stopId;

    /**
     * Name of the location. Use a name that people will understand in the local and tourist vernacular.
     *
     * When the location is a boarding area (location_type=4), the stop_name should contains the name of the boarding
     * area as displayed by the agency. It could be just one letter (like on some European intercity railway
     * stations), or text like “Wheelchair boarding area” (NYC’s Subway) or “Head of short trains” (Paris’ RER).
     */
    @Getter
    private String name;

    /**
     * Latitude of the location.
     */
    @Getter
    private double latitude;

    /**
     * Longitude of the location.
     */
    @Getter
    private double longitude;

    public Stop setStopId(long stopId) {
        this.stopId = stopId;
        return this;
    }

    public Stop setName(String name) {
        this.name = name;
        return this;
    }

    public Stop setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Stop setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
}
