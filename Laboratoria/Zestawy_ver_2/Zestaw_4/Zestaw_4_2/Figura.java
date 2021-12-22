package Zestaw_4_2;

// java interface vs abstract class

abstract class Figura // nie mozna tworzyc instancji tej klasy
{
    abstract double pole(); // metoda abstrakcyjna

    abstract double obwod();

    void info() {
        System.out.println(this);
    }
}