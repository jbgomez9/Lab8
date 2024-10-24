package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * check if the city added to the list can be found
     * and if a city not in the list returns false.
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City cityToAdd = new City("Estevan", "SK");
        list.addCity(cityToAdd);
        assertEquals(true, list.hasCity(cityToAdd));
        assertEquals(false, list.hasCity(new City("Unknown", "XX")));
    }

    /**
     * tests the deletion of a city from the list
     * and checks that the count of cities decreases by one
     * after removing a city that was previously added
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City cityToDelete = new City("Estevan", "SK");
        list.addCity(cityToDelete);
        int listSize = list.getCount();
        list.deleteCity(cityToDelete);
        assertEquals(listSize - 1, list.getCount());
        assertEquals(false, list.hasCity(cityToDelete));
    }

    /**
     * checks if the method returns the correct number
     * of cities in the list after adding multiple cities.
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        list.addCity(new City("Moose Jaw", "SK"));
        assertEquals(2, list.countCities());
    }
}
