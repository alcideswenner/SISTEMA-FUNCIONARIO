
package funcionario;


public abstract class Pessoa {

    private int cpf;
    private String nome;
    private String dn;

    public Pessoa(String nome,String dn,int cpf) {
        this.cpf = cpf;
        this.nome = nome;//inicializei a variavel
        this.dn = dn;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

}
