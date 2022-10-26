/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ModelClientes;
import Model.ModelEnderecos;
import conexoes.ConexaoMySql;

/**
 *
 * @author Matheus
 */
public class DaoClientes extends ConexaoMySql {

    /**
     * inserir cliete no banco
     *
     * @param cModelClientes
     * @return int
     */
    public int salvarClienteDao(ModelClientes cModelClientes) {

        try {

            this.conectar();
            return this.insertSQL("insert into clientes ("
                    + "cli_Nome,"
                    + "cli_Documento,"
                    + "cli_Telefone,"
                    + "cli_CodEndereco,"
                    + "cli_NumeroEndereco,"
                    + "cli_ComplementoEndereco"
                    + ") values ("
                    + "'" + cModelClientes.getCli_Nome() + "',"
                    + "'" + cModelClientes.getCli_Documento() + "',"
                    + "'" + cModelClientes.getCli_Telefone() + "',"
                    + "'" + cModelClientes.getCli_CodEndereco() + "',"
                    + "'" + cModelClientes.getCli_Numero()+ "',"
                    + "'" + cModelClientes.getCli_Complemento() + "');"
            );

        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        } finally {

            this.fecharConexao();

        }
    }

    /**
     * alterar dados cliente
     *
     * @param cModelClientes
     * @return boolena
     */
    public boolean alterarClienteDao(ModelClientes cModelClientes) {

        try {

            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "update clientes set "
                    + "cli_Nome = '" + cModelClientes.getCli_Nome() + "',"
                    + "cli_Documento = '" + cModelClientes.getCli_Documento() + "',"
                    + "cli_Telefone = '" + cModelClientes.getCli_Telefone() + "',"
                    + "cli_CodEndereco = '" + cModelClientes.getCli_CodEndereco() + "',"
                    + "cli_NumeroEndereco = '" + cModelClientes.getCli_Numero()+ "',"
                    + "cli_ComplementoEndereco = '" + cModelClientes.getCli_Complemento()+ "'"
                    + " where cli_CodCliente = '" + cModelClientes.getCli_CodCliente()+ "'"
            );

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            this.fecharConexao();

        }
    }

    /**
     * retorna cliente pelo código
     *
     * @param pClienteCodCliente
     * @return model produto
     */
    public ModelClientes retornaClienteDao(String pcli_Nome) {

        ModelClientes modelclientes = new ModelClientes();

        try {

            this.conectar();
            this.executarSQL("select c.cli_codCliente,c.cli_nome,c.cli_documento,c.cli_telefone,e.end_cep,e.end_cidade,e.end_bairro,e.end_rua,c.cli_numeroEndereco,c.cli_complementoendereco\n"
                    + "from clientes as c inner join enderecos as e on (c.cli_codEndereco = e.end_codEndereco)\n"
                    + "where c.cli_Nome like '" + pcli_Nome + "'; "
            );

            while (this.getResultSet().next()) {

                modelclientes.setCli_CodCliente(this.getResultSet().getInt(1));
                modelclientes.setCli_Nome(this.getResultSet().getString(2));
                modelclientes.setCli_Documento(this.getResultSet().getString(3));
                modelclientes.setCli_Telefone(this.getResultSet().getString(4));

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            this.fecharConexao();

        }

        return modelclientes;

    }
}
