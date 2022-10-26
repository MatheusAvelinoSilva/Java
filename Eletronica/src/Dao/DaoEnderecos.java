/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ModelEnderecos;
import conexoes.ConexaoMySql;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class DaoEnderecos extends ConexaoMySql {

    public int salvarEnderecoDao(ModelEnderecos pModelEnderecos) {

        try {

            this.conectar();
            return this.insertSQL("insert into enderecos ("
                    + "end_Cep,"
                    + "end_Rua,"
                    + "end_Bairro,"
                    + "end_Cidade"
                    + ") values ("
                    + "'" + pModelEnderecos.getEnd_Cep() + "',"
                    + "'" + pModelEnderecos.getEnd_Rua() + "',"
                    + "'" + pModelEnderecos.getEnd_Bairro() + "',"
                    + "'" + pModelEnderecos.getEnd_Cidade() + "'"
                    + ");"
            );

        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        } finally {

            this.fecharConexao();

        }
    }

    public ModelEnderecos retornaCodEnderecoDao(String pEnd_CepRua) {

        ModelEnderecos modelEnderecos = new ModelEnderecos();

        try {

            this.conectar();
            this.executarSQL("SELECT * from enderecos "
                    + "where end_Cep like'" + pEnd_CepRua + "' or end_Rua like '" + pEnd_CepRua + "' ; "
            );

            while (this.getResultSet().next()) {

                modelEnderecos.setEnd_CodEndereco(this.getResultSet().getInt(1));
                modelEnderecos.setEnd_Cep(this.getResultSet().getString(2));
                modelEnderecos.setEnd_Rua(this.getResultSet().getString(3));
                modelEnderecos.setEnd_Bairro(this.getResultSet().getString(4));
                modelEnderecos.setEnd_Cidade(this.getResultSet().getString(5));

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            this.fecharConexao();

        }

        return modelEnderecos;

    }

    public boolean alterarEndereco(ModelEnderecos pmodelEnderecos) {

        try {

            this.conectar();
            return this.executarUpdateDeleteSQL("update enderecos set "
                    + "End_Cep = '" + pmodelEnderecos.getEnd_Cep() + "',"
                    + "End_Rua = '" + pmodelEnderecos.getEnd_Rua() + "',"
                    + "End_Bairro = '" + pmodelEnderecos.getEnd_Bairro() + "',"
                    + "End_Cidade = '" + pmodelEnderecos.getEnd_Cidade() + "'"
                    + "where end_codEndereco = '" + pmodelEnderecos.getEnd_CodEndereco() + "';"
            );

        } catch (Exception e) {

            return false;

        } finally {

            this.fecharConexao();

        }
    }
}
