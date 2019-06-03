package lecture.three.builder;

public class Human {
    private String name;
    private String surname;
    private int age;
    private int id;
    private int passportNumber;
    private double weight;
    private double height;


    private static class HumanBuilder {
        private Human newHuman;

        public HumanBuilder() {
            newHuman = new Human();
        }

        public HumanBuilder addName(String name) {
            newHuman.name = name;
            return this;
        }

        public HumanBuilder addSurname(String surname) {
            newHuman.surname = surname;
            return this;
        }

        public HumanBuilder addAge(int age) {
            newHuman.age = age;
            return this;
        }

        public HumanBuilder addID(int id) {
            newHuman.id = id;
            return this;
        }

        public HumanBuilder addPassportNumber(int passportNumber) {
            newHuman.passportNumber = passportNumber;
            return this;
        }

        public HumanBuilder addWeight(double weight) {
            newHuman.weight = weight;
            return this;
        }

        public HumanBuilder addHeight(double height) {
            newHuman.height = height;
            return this;
        }
        public Human build() {
            return newHuman;
        }
    }

    public static void main(String[] args) {
        Human human = new Human.HumanBuilder()
                .addAge(15)
                .addName("Bob")
                .addSurname("Grygorenko")
                .addWeight(76.3).build();
    }
}