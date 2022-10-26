/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DaoEnderecos;
import Model.ModelEnderecos;

/**
 *
 * @author Matheus
 */
public class ControllerEnderecos {
    
    private DaoEnderecos daoEnderecos = new DaoEnderecos();
    
    public int salvarEnderecoController(ModelEnderecos pmodelEnderecos){
        
        return this.daoEnderecos.salvarEnderecoDao(pmodelEnderecos);
        
    }  
    
     public ModelEnderecos retornaCodEnderecoController (String pEnd_CepRua){
        
        return this.daoEnderecos.retornaCodEnderecoDao(pEnd_CepRua);
        
    }     
     
    public boolean alterarEnderecoController (ModelEnderecos pmodelEnderecos){
        
        return this.daoEnderecos.alterarEndereco(pmodelEnderecos);
        
    }
}
