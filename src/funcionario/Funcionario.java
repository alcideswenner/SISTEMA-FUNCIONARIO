package funcionario;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa implements Func_Interface {

    private int matricula;
    private String cargo;
    ArrayList<Funcionario> listaFunc;
    Scanner entrada = new Scanner(System.in);

    public Funcionario(String nome, String dn, int cpf, int matricula, String cargo) {
        super(nome, dn, cpf);//chamando construtor do pai
        this.cargo = cargo;
        this.matricula = matricula;

        listaFunc = new ArrayList<>();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void Salvar_DB() {

        Funcionario f = new Funcionario("", "", 0, 0, "");
        System.out.println("Digite o nome: ");
        f.setNome(entrada.nextLine());
        System.out.println("Digite a data de Nascimento: ");
        f.setDn(entrada.nextLine());
        System.out.println("Digite o cargo: ");
        f.setCargo(entrada.nextLine());
        entrada = new Scanner(System.in);
        System.out.println("Digite o CPF: ");
        f.setCpf(entrada.nextInt());
        System.out.println("Digite a matrícula: ");
        f.setMatricula(entrada.nextInt());
        entrada = new Scanner(System.in);

        listaFunc.add(f);

    }
    ArrayList<Funcionario> tempArray = new ArrayList<>();

    @Override
    public void Alterar_DB() {
        int resp = 0;
        System.out.print("Qual o CPF: ");
        resp = entrada.nextInt();
        entrada.nextLine();
        lista(resp);
    }

    public void lista(int cpf) {
        if (cpf == 0) {
            System.out.println(toString(listaFunc));
        } else {
            for (int i = 0; i < listaFunc.size(); i++) {
                if (listaFunc.get(i).getCpf()==cpf) {
                    System.out.println(listaFunc.get(i).getCpf());//filtrar
                    tempArray.add(listaFunc.get(i));
                    System.out.println(toString(tempArray));
                }
            }
        }
        tempArray.clear();
    }

    public String toString(ArrayList<Funcionario> lista) {
        String dados = "";
        System.out.println("-----------------------------");
        for (int i = 0; i < lista.size(); i++) {
            dados += "Funcionários cadastrados: " + listaFunc.size() + "\n"
                    + listaFunc.get(i).getNome() + "\n"
                    + listaFunc.get(i).getMatricula() + "\n"
                    + listaFunc.get(i).getCpf() + "\n";
        }
        return dados;
    }

}
