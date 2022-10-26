/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DaoNotaFiscal;
import Model.ModelNotaFiscal;

/**
 *
 * @author Matheus
 */
public class ControllerNotaFiscal {

    private DaoNotaFiscal daoNotaFiscal = new DaoNotaFiscal();

    public int salvarNotaFiscalController(ModelNotaFiscal pModelNotaFiscal) {

        return this.daoNotaFiscal.salvarNotafiscal(pModelNotaFiscal);

    }
}
