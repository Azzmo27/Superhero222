package org.example;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Controller controller = new Controller(database);
        UI userinterface = new UI();
        userinterface.StartProgram();
}}