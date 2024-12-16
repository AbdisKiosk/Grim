package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.api.AbstractCheck;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

import java.util.Collection;

public interface CheckSet<T extends AbstractCheck> {

    Collection<T> getAll();

    @SuppressWarnings("unchecked")
    default <U extends T> U get(Class<U> checkType) {
        for(T check : getAll()) {
            if(checkType.isInstance(check)) {
                return (U) check;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    default ClassToInstanceMap<T> getClassToInstance() {
        ClassToInstanceMap<T> classToInstance = MutableClassToInstanceMap.create();
        for(T check : getAll()) {
            classToInstance.put((Class<? extends T>) check.getClass(), check);
        }
        return classToInstance;
    }
}
