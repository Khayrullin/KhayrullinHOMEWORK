package ru.kpfu.itis.group11506.queue;

class Cashier {

    private final static int maxClientsInOneCashier = 3;

    private MyQueue<Client> clients = new MyQueue<>(maxClientsInOneCashier);


    void order(Client client) {
        try {
            clients.push(client);
        } catch (QueuOutOfBoundException e) {
            e.printStackTrace();
        }
    }

    int getSize() {
        return clients.size();
    }

    MyQueue<Client> getClients() {
        return clients;
    }

    static int getMaxClientsInOneCashier() {
        return maxClientsInOneCashier;
    }
}
