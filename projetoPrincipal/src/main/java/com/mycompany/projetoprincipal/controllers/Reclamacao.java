package ifpr.pgua.eic.tarefas.controllers;

import java.util.List;

public class Reclamacao {
    
    public static String salvar(Reclamacao reclamacao){
        
        String resposta = null;
        
        try{
            Reclamacao.salvar(reclamacao);
        }catch (Exception e){
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        
        return resposta;
    }
    
    public static List<Reclamacao> procurar(String nome){
        List<Reclamacao> listaResposta = null;
        
        try{
        
            if (nome == null || "".equals(nome)) {
                listaResposta = Reclamacao.listar();
            } else {
                listaResposta = Reclamacao.procurar(nome);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaResposta;
    }
    
    private static List<Reclamacao> listar() {
        return null;
    }

    public static String atualizar(Reclamacao reclamacao) 
    {
        String resposta = null;

        try
        {
            Reclamacao.atualizar(reclamacao);
        } 
        catch (Exception e) 
        {   
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        return resposta;        
    }
    
    public static String excluir(Integer id) 
    {
        String resposta = null;

        try 
        {   
            Reclamacao.excluir(id);
        } catch (Exception e) 
        {
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        return resposta;
    }
    
    public static Reclamacao obter(Integer id) {
        
        Reclamacao reclamacao =  new Reclamacao();
        
        try 
        {
            reclamacao = Reclamacao.obter(id);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return reclamacao;
        
    }
}