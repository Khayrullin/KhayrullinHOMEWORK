package ru.kpfu.itis.group11506.exceptions;

import java.util.Scanner;

class UserFactory {

    User createUser()
            throws UserInputException {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        boolean checker = false;
        String inputInfo = null;
        for (int tryIndex = 0; tryIndex < 10 && !checker;
             tryIndex++) {
            try {
                inputInfo = getAdress(scanner);
                checker = true;
            } catch (UserInputException exception) {
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            }
        }
        if (!checker) {
            throw new UserInputException("Превышено количество "
                    + "попыток набора номера карты");
        } else {
            user.setAdress(inputInfo);
        }


        checker = false;
        inputInfo = null;
        for (int tryIndex = 0; tryIndex < 10 && !checker;
             tryIndex++) {
            try {
                inputInfo = getName(scanner);
                checker = true;
            } catch (UserInputException exception) {
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            }
        }
        if (!checker) {
            throw new UserInputException("Превышено количество "
                    + "попыток набора имени");
        } else {
            user.setName(inputInfo);
        }


        checker = false;
        inputInfo = null;
        for (int tryIndex = 0; tryIndex < 10 && !checker;
             tryIndex++) {
            try {
                inputInfo = getLastName(scanner);
                checker = true;
            } catch (UserInputException exception) {
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            }
        }
        if (!checker) {
            throw new UserInputException("Превышено количество "
                    + "попыток набора Фамилии");
        } else {
            user.setLastName(inputInfo);
        }


        checker = false;
        inputInfo = null;
        for (int tryIndex = 0; tryIndex < 10 && !checker;
             tryIndex++) {
            try {
                inputInfo = getCardNumber(scanner);
                checker = true;
            } catch (UserInputException exception) {
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            }
        }
        if (!checker) {
            throw new UserInputException("Превышено количество "
                    + "попыток набора номера карты");
        } else {
            user.setCardNumber(inputInfo);
        }


        checker = false;
        inputInfo = null;
        for (int tryIndex = 0; tryIndex < 10 && !checker;
             tryIndex++) {
            try {
                inputInfo = getPhoneNumber(scanner);
                checker = true;
            } catch (UserInputException exception) {
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            }
        }
        if (!checker) {
            throw new UserInputException("Превышено количество "
                    + "попыток набора номера");
        } else {
            user.setPhoneNumber(inputInfo);
        }


        return user;
    }

    private static String getPhoneNumber(Scanner scanner)
            throws UserInputException {
        System.out.println("Введите телефонный номер:");
        String userInput = scanner.next();

        int inputSize = userInput.length();
        if (inputSize != 11 && inputSize != 7) {
            throw new UserInputException("Неправильная длина телефонного номера");
        } else {
            for (int i = 0; i < userInput.length(); i++) {
                char ch = userInput.charAt(i);
                if (ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6' && ch != '7' && ch != '8'
                        && ch != '9' && ch != '0') {
                    throw new UserInputException("Неправильный формат телефонного номера");
                }
            }
        }
        return userInput;
    }

    private static String getName(Scanner scanner)
            throws UserInputException {
        System.out.println("Введите Имя:");
        String userInput = scanner.nextLine();
        int inputSize = userInput.length();

        if (inputSize < 2) {
            throw new UserInputException("Неправильная длина имени");
        } else {
            for (int i = 0; i < userInput.length(); i++) {
                char ch = userInput.charAt(i);
                if (ch == '1' || ch == '2' || ch == '3' || ch == '4'
                        || ch == '5' || ch == '6' || ch == '7'
                        || ch == '8' || ch == '9' || ch == '0' || ch == '/'
                        || ch == '.' || ch == '?' || ch == ',' || ch == '!'
                        || ch == ';' || ch == ':' || ch == ')' || ch == '('
                        || ch == '+' || ch == '=' || ch == '*' || ch == '&'
                        || ch == '^' || ch == '%' || ch == '$' || ch == '#'
                        || ch == '№' || ch == '@' || ch == '"' || ch == '`'
                        || ch == '~' || ch == '-' || ch == '_') {
                    throw new UserInputException("Введены не Латинские и не Русские буквы!");
                }
            }
        }
        return userInput;
    }

    private static String getLastName(Scanner scanner)
            throws UserInputException {
        System.out.println("Введите Фамилию:");
        String userInput = scanner.nextLine();
        int inputSize = userInput.length();

        if (inputSize < 2) {
            throw new UserInputException("Неправильная длина Фамилии");
        } else {
            for (int i = 0; i < userInput.length(); i++) {
                char ch = userInput.charAt(i);
                if (ch == '1' || ch == '2' || ch == '3' || ch == '4'
                        || ch == '5' || ch == '6' || ch == '7'
                        || ch == '8' || ch == '9' || ch == '0' || ch == '/'
                        || ch == '.' || ch == '?' || ch == ',' || ch == '!'
                        || ch == ';' || ch == ':' || ch == ')' || ch == '('
                        || ch == '+' || ch == '=' || ch == '*' || ch == '&'
                        || ch == '^' || ch == '%' || ch == '$' || ch == '#'
                        || ch == '№' || ch == '@' || ch == '"' || ch == '`'
                        || ch == '~' || ch == '-' || ch == '_') {
                    throw new UserInputException("Введены не Латинские и не Русские буквы!");
                }
            }
        }
        return userInput;
    }

    private static String getCardNumber(Scanner scanner)
            throws UserInputException {
        System.out.println("Введите Номер карты(16 цифр):");
        String userInput = scanner.next();

        int inputSize = userInput.length();
        if (inputSize != 16) {
            throw new UserInputException("Неправильная длина Номера карты");
        } else {
            for (int i = 0; i < userInput.length(); i++) {
                char ch = userInput.charAt(i);
                if (ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6' && ch != '7' && ch != '8'
                        && ch != '9' && ch != '0') {
                    throw new UserInputException("Неправильный формат Номера карты");
                }
            }
        }
        return userInput;
    }

    private static String getAdress(Scanner scanner)
            throws UserInputException {
        System.out.println("Введите Адрес:");
        String userInput = scanner.nextLine();
        if ((userInput.contains("дом") || userInput.contains("д.")) && (userInput.contains("улица") ||
                userInput.contains("ул.")) && (userInput.contains("с.") ||
                userInput.contains("г.") || userInput.contains("п."))) {
            return userInput;
        } else {
            throw new UserInputException("Не содержит слов 'дом' или 'д.',  'улица' или 'ул.', " +
                    "'с.' или 'г.' или 'п.' ");
        }
    }


}
