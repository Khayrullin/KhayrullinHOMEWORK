package ru.kpfu.itis.group11506.queue;

class Client {

    private int rating;
    private Client nextClient;

    int getRating() {
        return rating;
    }

    public Client getNextClient() {
        return nextClient;
    }

     void setNextClient(Client nextClient) {
        this.nextClient = nextClient;
    }

    Client(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return  "Клиент с приоритетом: " + getRating();
    }
}
