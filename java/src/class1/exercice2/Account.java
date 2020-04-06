package class1.exercice2;

public class Account {
    private final Integer id;
    private Integer balance;
    private Status status;

    Account(final Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBalance() {
        return balance;
    }

    public enum Status {
        NORMAL("Normal"), SPECIAL("Special");

        private final String status;

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}