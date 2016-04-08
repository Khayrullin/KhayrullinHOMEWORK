package ru.kpfu.itis.group11506.set;

 class Client {
    private int rating;
    private String name;

    Client(int rating, String name) {
        this.rating = rating;
        this.name = name;
    }

     int getRating() {
        return rating;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (rating != client.rating) return false;
        return name != null ? name.equals(client.name) : client.name == null;

    }

    @Override
    public int hashCode() {
        int result = rating;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                '}';
    }
}
