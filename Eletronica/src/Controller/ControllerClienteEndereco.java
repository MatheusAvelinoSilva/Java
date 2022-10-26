/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ModelClienteEndereco;
import Dao.DaoClienteEnderecos;
/**
 *
 * @author Matheus
 */
public class ControllerClienteEndereco {
    
     private DaoClienteEnderecos daoCliEnd = new DaoClienteEnderecos();
    
    public ModelClienteEndereco retornaClienteDao (String pcli_Nome){
        
        return this.daoCliEnd.retornaClienteDao(pcli_Nome);
        
    }   
    
}
