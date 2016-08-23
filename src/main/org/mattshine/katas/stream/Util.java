package org.mattshine.katas.stream;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

public class Util {

    public static List<String> mapToUppercase(List<String> input) {
        return input.stream().map(String::toUpperCase).collect(toList());
    }

    public static List<String> removeElementsWithMoreThanFourCharacters(List<String> input) {
        return input.stream().filter(i -> i.length() < 4).collect(toList());
    }

    public static List<String> sortStrings(List<String> input) {
        return input.stream().sorted().collect(toList());
    }

    public static List<Integer> sortIntegers(List<String> input) {
        return input.stream().map(Integer::valueOf).sorted().collect(toList());
    }

    public static List<Integer> sortIntegersDescending(List<String> input) {
        return input.stream().map(Integer::valueOf).sorted(reverseOrder()).collect(toList());
    }

    public static Integer sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<String> flattenToSingleCollection(List<List<String>> input) {
        return input.stream().flatMap(Collection::stream).collect(toList());
    }

    public static String separateNamesByComma(List<Person> input) {
        return input.stream().map(Person::getName).collect(joining(", ", "Names: ", "."));
    }

    public static String findNameOfOldestPerson(List<Person> input) {
        return input.stream().max(comparingInt(Person::getAge)).get().getName();
    }

    public static List<String> filterPeopleLessThan18YearsOld(List<Person> input) {
        return input.stream().filter(person -> person.getAge() < 18).map(Person::getName).collect(toList());
    }

    public static IntSummaryStatistics getSummaryStatisticsForAge(List<Person> input) {
        return input.stream().mapToInt(Person::getAge).summaryStatistics();
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> input) {
        return input.stream().collect(partitioningBy(p -> p.getAge() > 18));
    }

    public static Map<String, List<Person>> partitionByNationality(List<Person> input) {
        return input.stream().collect(groupingBy(Person::getCountry));
    }
}
