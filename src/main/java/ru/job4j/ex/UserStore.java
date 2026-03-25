package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
          if (user.getUsername().equals(login)) {
              result = user;
              break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User not found");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = user.isValid();
        if (!result || user.getUsername().length() < 3) {
            throw new UserInvalidException("User isn't valid");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException en) {
            System.out.println("Пользователь не валидный");
        } catch (UserNotFoundException ea) {
            System.out.println("Пользователь не найден");
        }
    }
}
