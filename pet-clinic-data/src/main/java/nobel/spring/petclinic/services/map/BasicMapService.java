package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.BaseEntity;
import nobel.spring.petclinic.services.BasicCrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BasicMapService<T extends BaseEntity, ID> implements BasicCrudService<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if(object != null) {
            if(object.getId() == null)
                object.setId(getNextId());
            map.put((ID) object.getId(), object);
        } else {
            throw new RuntimeException("Entities Can't Be Null");
        }
        return object;
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        return (long) (map.keySet().size() + 1);
    }
}