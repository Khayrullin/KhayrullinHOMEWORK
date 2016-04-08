package ru.kpfu.itis.group11506.exceptions;

class User {
    private String phoneNumber, address, name, lastName, cardNumber;

    void setName(String name) {
        this.name = name;
    }

    void setAdress(String address) {
        this.address = address;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n" + "Фамилия: " + lastName + "\n" + "Адрес доставки: " + address + "\n" +
                "Номер телефона: " + phoneNumber + "\n" + "Номер карты: " + cardNumber;
    }
}
