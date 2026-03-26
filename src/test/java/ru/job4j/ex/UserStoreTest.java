package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserStoreTest {
    @Test
    public void whenUserValidateException() {
        User user = new User("Petr Arsentev", false);
        UserInvalidException exception = assertThrows(
                UserInvalidException.class,
                () -> {
                    UserStore.validate(user);
                });
        assertThat(exception.getMessage()).isEqualTo("User isn't valid");
    }

    @Test
    public void whenUserValidateSuccess() throws UserInvalidException {
        User user = new User("Petr Arsentev", true);
        assertThat(UserStore.validate(user)).isTrue();
    }

    @Test
    public void whenFindUserException() {
        User user = new User("Petr Arsentev", true);
        User[] users = {user};
        UserNotFoundException exception = assertThrows(
                UserNotFoundException.class,
                () -> {
                    UserStore.findUser(users, "Vladimir" );
                });
        assertThat(exception.getMessage()).isEqualTo("User not found");
    }

    @Test
    public void whenFindUserSuccess() throws UserNotFoundException {
        User user = new User("Petr Arsentev", true);
        User[] users = {user};
        assertThat(UserStore.findUser(users, "Petr Arsentev" )).isEqualTo(user);
    }
}