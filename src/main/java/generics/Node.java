package generics;

import java.util.Optional;

public interface Node {

    <T> T getValueAs(Class<T> clazz);

    <T> Optional<T> tryGetValueAs(Class<T> clazz);


}
