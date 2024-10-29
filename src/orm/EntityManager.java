package orm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityManager<T> {

    private final Class<T> entityType;
    private final String csvFilePath;

    public EntityManager(Class<T> entityType, String csvFilePath) {
        this.entityType = entityType;
        this.csvFilePath = csvFilePath;
    }

    public List<T> getAll() {
        List<T> resultList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String[] headers = br.readLine().split(",");

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                T entity = entityType.getDeclaredConstructor().newInstance();

                for (int i = 0; i < headers.length; i++) {
                    Field field = entityType.getDeclaredField(headers[i].trim());
                    field.setAccessible(true);

                    if (field.getType() == int.class) {
                        field.setInt(entity, Integer.parseInt(values[i].trim()));
                    } else if (field.getType() == String.class) {
                        field.set(entity, values[i].trim());
                    }
                }
                resultList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

}
