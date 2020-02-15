import DAO.FuncionarioJpaDAO;
import Entity.Funcionario;

public class Main {

    public static void main(String[] args){

        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("123456789");
        funcionario.setMatricula(258);
        funcionario.setNome("Taina");
        FuncionarioJpaDAO.getInstance().merge(funcionario);

    }
}
