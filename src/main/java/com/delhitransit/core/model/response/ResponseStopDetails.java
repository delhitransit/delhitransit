package com.delhitransit.core.model.response;

import lombok.Getter;

public class ResponseStopDetails {

    @Getter
    private String routeLongName;

    @Getter
    private long routeId;

    @Getter
    private String tripId;

    @Getter
    private String lastStopName;

    @Getter
    private long earliestTime;

    public ResponseStopDetails setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
        return this;
    }

    public ResponseStopDetails setRouteId(long routeId) {
        this.routeId = routeId;
        return this;
    }

    public ResponseStopDetails setTripId(String tripId) {
        this.tripId = tripId;
        return this;
    }

    public ResponseStopDetails setLastStopName(String lastStopName) {
        this.lastStopName = lastStopName;
        return this;
    }

    public ResponseStopDetails setEarliestTime(long earliestTime) {
        this.earliestTime = earliestTime;
        return this;
    }
}
