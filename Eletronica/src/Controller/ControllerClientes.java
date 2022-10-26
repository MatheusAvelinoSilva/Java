/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DaoClientes;
import Model.ModelClientes;

/**
 *
 * @author Matheus
 */
public class ControllerClientes {
    
    private DaoClientes daoclientes = new DaoClientes();
    
    /**
     * salvar cliente
     * @param cModelClientes
     * @return int
     */
    
    public int salvarClienteController(ModelClientes cModelClientes){
        
        return this.daoclientes.salvarClienteDao(cModelClientes);
        
    }
    
    public boolean alterarClienteController(ModelClientes cModelClientes){
        
        return this.daoclientes.alterarClienteDao(cModelClientes);
        
    }
    
    public ModelClientes retornarClienteController (String pnomeCliente){
        
        return this.daoclientes.retornaClienteDao(pnomeCliente);
        
    } 
}
