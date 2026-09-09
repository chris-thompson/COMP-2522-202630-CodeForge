package ca.bcit.comp2522.inheritance.introToInheritance.roads;

import java.util.ArrayList;

/**
 * RoadMaker.
 *
 * @author BCIT
 * @version 2026
 */
public final class RoadMaker {

    private RoadMaker() {
    }

    /**
     * Drives the program.
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        Road firstRoad = new Road("Duffy Lake", Direction.NORTH);
        Road firstBoulevard = new Boulevard("Niagara Boulevard", Direction.SOUTH, true);
        Road motorWay = new Highway("Hwy 1", Direction.EAST, true);

        ArrayList<Road> myFavouriteRoadTrips = new ArrayList<>();
        myFavouriteRoadTrips.add(firstRoad);
        myFavouriteRoadTrips.add(firstBoulevard);
        myFavouriteRoadTrips.add(motorWay);

        for (Road eachRoad : myFavouriteRoadTrips) {
            System.out.println(eachRoad);
        }
    }
}
