package Aplicacao;

import DAO.ContatoDAO;
import Model.Contato;
import java.sql.SQLException;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        ContatoDAO contatoDao = new ContatoDAO();
        
        Contato contato1 = new Contato();
        contato1.setNome("Gabriel");
        contato1.setIdade(20);
        contato1.setDataCadastro(new Date());
        //c1.setId(8);
        
        //contatoDao.create(contato1);
        
        //contatoDao.update(contato1);       

        /*for(Contato c : contatoDao.read()){
           System.out.println("Nome: "+c.getNome() + " Idade:"+c.getIdade());
        }*/
        
        //contatoDao.delete(8);
        
    }
}