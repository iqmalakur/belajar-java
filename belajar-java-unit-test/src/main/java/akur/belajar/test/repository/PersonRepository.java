package akur.belajar.test.repository;

import akur.belajar.test.data.Person;

public interface PersonRepository {
    Person selectById(String id);
}
