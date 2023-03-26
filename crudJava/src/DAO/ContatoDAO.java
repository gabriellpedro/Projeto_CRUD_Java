package DAO;

import Model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Factory.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    
    //Criação do CRUD
    
    public void create(Contato contato) throws SQLException, ClassNotFoundException{
        
        String sql = "INSERT INTO  contatos(nome, idade, dataCadastro) values(?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.crateConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
            
            pstm.execute();
            System.out.println("Inserção realizada com sucesso");
            System.out.println("Nome: "+contato.getNome()+"\nIdade: "+contato.getIdade()+"\nData: "+contato.getDataCadastro());
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    conn.close();
                }if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public List<Contato> read() throws SQLException{
        
        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<Contato>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        //Onde realizaremos o Select no banco.
        ResultSet rst = null;
        
        try{
            conn = ConnectionFactory.crateConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Contato contato = new Contato();
                
                //recuperar o ID
                contato.setId(rst.getInt("id"));
                //recuperar o nome
                contato.setNome(rst.getString("nome")); 
                //recuperar a idade
                contato.setIdade(rst.getInt("idade"));
                //recuperar a data de cadastro
                contato.setDataCadastro(rst.getDate("dataCadastro"));
                
                contatos.add(contato);                
            }            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rst != null){
                    conn.close();
                }if(pstm != null){
                    conn.close();
                }if(conn!= null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return contatos;
        }
    }
    
    public void update(Contato contato) throws SQLException{
        
        //comando SQL a ser realizado
        String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? WHERE id = ?";
        
        //cria a conexão SQL
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.crateConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //direciona os valores a serem atualizados
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            //indica o ID que deve ser atualizado no banco, de acordo com a PK
            pstm.setInt(4, contato.getId());
            
            pstm.execute();
            
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if(conn !=null){
                    conn.close();
                }if(pstm !=null){
                    conn.close();
                }
            }
        }
    
    public void delete(Integer id) throws SQLException{
        
        String sql = "DELETE FROM contatos WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.crateConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn!= null){
                conn.close();
            }if(pstm!= null){
                conn.close();
            }
        }
        
    }
    
}
    