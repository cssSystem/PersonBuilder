public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Не указано имя");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Не указана фамилия");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        } else this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person;
        if (name == null && surname == null) {
            throw new IllegalStateException("Не указано Имя и Фамилия");
        }
        if (name == null) {
            throw new IllegalStateException("Имя не указано");
        }
        if (surname == null) {
            throw new IllegalStateException("Фамилия не указана");
        }
        if (age < 0) {
            person = new Person(name, surname);
        } else person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}
