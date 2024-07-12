package databinder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindException;
import org.springframework.validation.DataBinder;

import java.util.Map;

public class TestBinder {
    @Test
    public void test_bind() {
        Person person = new Person();
        person.setAge(-1);
        person.setName("");
        PersonValidator personValidator = new PersonValidator();

        DataBinder dataBinder = new DataBinder(person, "--person--");
        dataBinder.setValidator(personValidator);
        dataBinder.validate();

        dataBinder.getBindingResult().getAllErrors().forEach(System.out::println);
    }

    @Test
    public void test_support() {
        PersonValidator personValidator = new PersonValidator();

        DataBinder dataBinder = new DataBinder(new String("abc"));
        dataBinder.setValidator(personValidator);
        dataBinder.validate();

        dataBinder.getBindingResult().getAllErrors().forEach(System.out::println);
    }

    @Test
    public void test_bind_obj() throws BindException {
        Person person = new Person();
        DataBinder dataBinder = new DataBinder(person);

        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("name", "zhangsan");
        pvs.add("age", 20);

        dataBinder.bind(pvs);
        Map<?, ?> ret = dataBinder.close();

        System.out.println(person);
        System.out.println("--------------------");
        System.out.println(ret);
    }
}
