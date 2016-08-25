package org.mattshine.katas.test.refactoring;


import org.junit.Before;
import org.junit.Test;
import org.mattshine.katas.refactoring.F;
import org.mattshine.katas.refactoring.Finder;
import org.mattshine.katas.refactoring.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mattshine.katas.refactoring.Option.Closest;
import static org.mattshine.katas.refactoring.Option.Furthest;


public class FinderTests {

    private Person sue;
    private Person greg;
    private Person sarah;
    private Person mike;

    @Before
    public void setup() {
        sue = new Person();
        sue.setName("Sue");
        sue.setBirthDate(LocalDateTime.of(50, 1, 1, 10, 30));

        greg = new Person();
        greg.setName("Greg");
        greg.setBirthDate(LocalDateTime.of(52, 5, 1, 10, 45));

        sarah = new Person();
        sarah.setName("Sarah");
        sarah.setBirthDate(LocalDateTime.of(82, 2, 1, 11, 0));

        mike = new Person();
        mike.setName("Mike");
        mike.setBirthDate(LocalDateTime.of(79, 3, 1, 11, 30));
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<Person>();
        Finder finder = new Finder(list);

        F result = finder.Find(Closest);
        assertEquals(null, result.getPerson1());

        assertEquals(null, result.getPerson2());
    }

    @Test
    public void Returns_Empty_Results_When_Given_Closest_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        Finder finder = new Finder(list);

        F result = finder.Find(Closest);

        assertEquals(null, result.getPerson1());
        assertEquals(null, result.getPerson2());
    }

    @Test
    public void Returns_Closest_Furthest_For_Furthest_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        F result = finder.Find(Closest);

        System.out.println(result.getD());

        assertEquals(sue, result.getPerson1());
        assertEquals(greg, result.getPerson2());
    }

    @Test
    public void Returns_Furthest_Furthest_For_Furthest_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        F result = finder.Find(Furthest);

        assertEquals(greg, result.getPerson1());
        assertEquals(mike, result.getPerson2());
    }

    @Test
    public void Returns_Furthest_Furthest_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        F result = finder.Find(Furthest);

        assertEquals(sue, result.getPerson1());
        assertEquals(sarah, result.getPerson2());
    }

    @Test
    public void Returns_Closest_Furthest_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        F result = finder.Find(Closest);

        assertEquals(sue, result.getPerson1());
        assertEquals(greg, result.getPerson2());
    }

}
