import dao.PersonDAO;
import dao.CityDAO;
import entities.Person;
import entities.City;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PersonDAO persondao = new PersonDAO();
            List<Person> people = persondao.getAll();
            System.out.println("people:");
            for (Person person : people) {
                System.out.println(String.valueOf(person.getId()).concat("-").concat(person.getName()));
            }

            CityDAO citydao = new CityDAO();
            List<City> cities = citydao.getAll();
            System.out.println("cities:");
            for (City city : cities) {
                System.out.println(String.valueOf(city.getId()).concat("-").concat(city.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
