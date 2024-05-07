package org.example.ShortestPathsCLI;

import java.io.IOException;

public interface IShortestPathsCLI {
    void intro();
    void prelude() throws IOException;
    void main_menu();
    void first_sub_menu(int choice1);
    void second_sub_menu(int choice1, int choice2);
    void run() throws IOException;
}
