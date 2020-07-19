package com.delhitransit.core.model;

import lombok.Getter;
import lombok.Setter;

/**
 * For more information see https://developers.google.com/transit/gtfs/reference/#shapestxt
 */
public class Shape {

    /**
     * Identifies a shape.
     */
    @Getter
    @Setter
    private long id;

    /**
     * Latitude of a shape point. Each record in shapes.txt represents a shape point used to define the shape.
     */
    @Getter
    @Setter
    private double latitude;

    /**
     * Longitude of a shape point.
     */
    @Getter
    @Setter
    private double longitude;

    /**
     * Sequence in which the shape points connect to form the shape. Values must increase along the trip but do not
     * need to be consecutive.Example: If the shape "A_shp" has three points in its definition, the shapes.txt file
     * might contain these records to define the shape:
     * shape_id,shape_pt_lat,shape_pt_lon,shape_pt_sequence
     * A_shp,37.61956,-122.48161,0
     * A_shp,37.64430,-122.41070,6
     * A_shp,37.65863,-122.30839,11
     */
    @Getter
    @Setter
    private long sequence;

}