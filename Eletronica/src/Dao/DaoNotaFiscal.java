/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ModelNotaFiscal;
import conexoes.ConexaoMySql;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class DaoNotaFiscal extends ConexaoMySql {

    public int salvarNotafiscal(ModelNotaFiscal pModelNotaFiscal) {

        try {

            this.conectar();
            return this.insertSQL("insert into notafiscal ("
                    + "ntf_CodCliente,"
                    + "ntf_CodAparelho,"
                    + "ntf_CodEndereco,"
                    + "ntf_DataSaida,"
                    + "ntf_Orcamento"
                    + ") values ("
                    + "'" + pModelNotaFiscal.getNtf_CodCliente() + "',"
                    + "'" + pModelNotaFiscal.getNtf_CodAparelho() + "',"
                    + "'" + pModelNotaFiscal.getNtf_CodEndereco() + "',"
                    + "'" + pModelNotaFiscal.getNtf_DataSaida() + "',"
                    + "'" + pModelNotaFiscal.getNtf_Orcamento() + "');"
            );

        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        } finally {

            this.fecharConexao();

        }
    }    
}
