package ru.job4j.ood.isp;

interface Developer {
    void writeCode();
    void makeCodeReview() throws NoCompetencies;
}

class JuniorDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("I can write some code");
    }

    @Override
    public void makeCodeReview() throws NoCompetencies {
        throw new NoCompetencies("I don't have enough competencies.");
    }
}

class MiddleDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("I can write some code");
    }

    @Override
    public void makeCodeReview() throws NoCompetencies {
        System.out.println("Lets make review!");
    }
}

class NoCompetencies extends Exception {
    public NoCompetencies(String message) {
        super(message);
    }
}
