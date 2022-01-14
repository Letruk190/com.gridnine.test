package com.gridnine.testing.moduleSearch;

import com.gridnine.testing.testclass.Flight;

import java.util.List;

public interface FlightFilter {
    //выводит отфильтрованный список
    List<Flight> getFilteredFlights(List<Flight> flightList);
}