package org.mattshine.katas.refactoring;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    private final List<Person> personList;

    public Finder(List<Person> personList) {
        this.personList = personList;
    }

    public F Find(Option option) {
        List<F> fList = new ArrayList<F>();

        for (int i = 0; i < personList.size() - 1; i++) {
            for (int j = i + 1; j < personList.size(); j++) {
                F f = new F();
                if (personList.get(i).getBirthDate().isBefore(personList.get(j).getBirthDate())) {
                    f.setPerson1(personList.get(i));
                    f.setPerson2(personList.get(j));
                } else {
                    f.setPerson1(personList.get(j));
                    f.setPerson2(personList.get(i));
                }

                ZoneId zoneId = ZoneId.systemDefault();
                f.setD(f.getPerson2().getBirthDate().atZone(zoneId).toEpochSecond() - f.getPerson1().getBirthDate().atZone(zoneId).toEpochSecond());
                fList.add(f);
            }
        }

        if (fList.size() < 1) {
            return new F();
        }

        F answer = fList.get(0);
        for (F result : fList) {
            switch (option) {
                case Closest:
                    if (result.getD() < answer.getD()) {
                        answer = result;
                    }
                    break;

                case Furthest:
                    if (result.getD() > answer.getD()) {
                        answer = result;
                    }
                    break;
            }
        }

        return answer;
    }
}
