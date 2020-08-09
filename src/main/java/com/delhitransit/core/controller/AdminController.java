package com.delhitransit.core.controller;

import com.delhitransit.core.service.RouteService;
import com.delhitransit.core.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("delhitransit-admin/v1")
public class AdminController {

    private RouteService routeService;
    private TripService tripService;
    @Autowired
    public AdminController(RouteService routeService) {
        this.routeService = routeService;
        this.tripService = tripService;
    }

    @PostMapping("init/routes")
    public void initializeRoutesTable() throws IOException {
        routeService.initializeUnlinkedDatabase();
    }
    @PostMapping("init/trips")
    public void initializeTripsTables() throws IOException {
        tripService.initializeUnlinkedDatabase();
    }
}
