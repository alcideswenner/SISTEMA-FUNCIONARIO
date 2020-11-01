package funcionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        for (Funcionario ff : Conexao.lista()) {
            System.out.println(ff.getNome());
        }
    }
}
