/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ModelClienteEndereco;
import Model.ModelClientes;
import Model.ModelEnderecos;
import conexoes.ConexaoMySql;

/**
 *
 * @author Matheus
 */
public class DaoClienteEnderecos extends ConexaoMySql {

    public ModelClienteEndereco retornaClienteDao(String pcli_Nome) {

        ModelClienteEndereco modelclientesEndereco = new ModelClienteEndereco();

        try {

            this.conectar();
            this.executarSQL("select c.cli_codCliente,c.cli_nome,c.cli_documento,c.cli_telefone,e.end_cep,e.end_cidade,e.end_bairro,e.end_rua,c.cli_numeroEndereco,c.cli_complementoendereco\n"
                    + "from clientes as c inner join enderecos as e on (c.cli_codEndereco = e.end_codEndereco)\n"
                    + "where c.cli_Nome like '" + pcli_Nome + "'; "
            );

            while (this.getResultSet().next()) {

                modelclientesEndereco.setCli_CodCliente(this.getResultSet().getInt(1));
                modelclientesEndereco.setCli_Nome(this.getResultSet().getString(2));
                modelclientesEndereco.setCli_Documento(this.getResultSet().getString(3));
                modelclientesEndereco.setCli_Telefone(this.getResultSet().getString(4));
                modelclientesEndereco.setCli_ComplementoEndereco(this.getResultSet().getString(10));
                modelclientesEndereco.setCli_NumeroEndereco(this.getResultSet().getInt(9));

                modelclientesEndereco.setEnd_Cep(this.getResultSet().getString(5));
                modelclientesEndereco.setEnd_Cidade(this.getResultSet().getString(6));
                modelclientesEndereco.setEnd_Bairro(this.getResultSet().getString(7));
                modelclientesEndereco.setEnd_Rua(this.getResultSet().getString(8));

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            this.fecharConexao();

        }

        return modelclientesEndereco;

    }

}
