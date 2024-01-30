package akur.belajar.test.service;

import akur.belajar.test.data.Person;
import akur.belajar.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp(){
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.get("not found"));
    }

    @Test
    void testGetPersonSuccess() {
        // menambah behavior ke mock object
        Mockito.when(personRepository.selectById("akur"))
                .thenReturn(new Person("akur", "Akur"));

        var person = personService.get("akur");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("akur", person.getId());
        Assertions.assertEquals("Akur", person.getName());
    }
}
