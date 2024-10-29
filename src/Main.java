import dao.PersonDAO;
import dao.CityDAO;
import entities.Person;
import entities.City;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PersonDAO persondao = new PersonDAO();
            List<Person> persons = persondao.getAll();
            System.out.println("persons:");
            for (Person person : persons) {
                System.out.println(person.getName());
            }

            CityDAO citydao = new CityDAO();
            List<City> citys = citydao.getAll();
            System.out.println("city:");
            for (City city : citys) {
                System.out.println(city.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
