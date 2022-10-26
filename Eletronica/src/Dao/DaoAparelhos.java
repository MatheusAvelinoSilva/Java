/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ModelAparelhos;
import conexoes.ConexaoMySql;
import static java.time.LocalDateTime.now;


/**
 *
 * @author Matheus
 */
public class DaoAparelhos extends ConexaoMySql {

    public int salvarAparelhosDao(ModelAparelhos cmodelAparelhos) {

        try {

            this.conectar();
            return this.insertSQL(
                    "insert into aparelhos ("
                    + "apa_codCliente,"
                    + "apa_documento,"
                    + "apa_modelo,"
                    + "apa_defeito,"
                    + "apa_DataHoraEntrada"
                    + ")values ("
                    + "'" + cmodelAparelhos.getApa_CodCliente() + "',"
                    + "'" + cmodelAparelhos.getApa_Documento() + "',"
                    + "'" + cmodelAparelhos.getApa_Modelo() + "',"
                    + "'" + cmodelAparelhos.getApa_Defeito() + "',"
                    + "'" + now() + "');"
            );

        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        } finally {

            this.fecharConexao();

        }
    }

    public ModelAparelhos retornarAparelhoDao(String pDocumento) {

        ModelAparelhos modelAparelhos = new ModelAparelhos();

        try {

            this.conectar();
            this.executarSQL("select * from aparelhos where apa_documento like '" + pDocumento + "';"
            
            );
            
            while (this.getResultSet().next()) {

                modelAparelhos.setApa_CodAparelho(this.getResultSet().getInt(1));
                modelAparelhos.setApa_CodCliente(this.getResultSet().getInt(2));
                modelAparelhos.setApa_Documento(this.getResultSet().getString(3));
                modelAparelhos.setApa_Modelo(this.getResultSet().getString(4));
                modelAparelhos.setApa_Defeito(this.getResultSet().getString(5));
                modelAparelhos.setApa_DataHoraEntrada(this.getResultSet().getString(6));

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            this.fecharConexao();

        }

        return modelAparelhos;

    }

    public boolean alterarAparelhoDao(ModelAparelhos pmodelAparelhos) {

        try {

            this.conectar();
            return this.executarUpdateDeleteSQL("update aparelhos set "
                    + "apa_modelo = '" + pmodelAparelhos.getApa_Modelo() + "',"
                    + "apa_defeito = '" + pmodelAparelhos.getApa_Defeito() + "'"
                    + "where apa_codAparelho = '" + pmodelAparelhos.getApa_CodAparelho() + "' "
            );

        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
            
        } finally {

            this.fecharConexao();

        }        
    }

}
