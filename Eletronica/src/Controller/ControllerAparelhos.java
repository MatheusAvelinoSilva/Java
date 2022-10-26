/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DaoAparelhos;
import Model.ModelAparelhos;

/**
 *
 * @author Matheus
 */
public class ControllerAparelhos {

    private DaoAparelhos daoaparelhos = new DaoAparelhos();

    public int salvarAparelhos(ModelAparelhos pmodelAparelhos) {

        return this.daoaparelhos.salvarAparelhosDao(pmodelAparelhos);

    }

    public boolean alterarAparalhos(ModelAparelhos pmodelAparelhos) {

        return this.daoaparelhos.alterarAparelhoDao(pmodelAparelhos);

    }

    public ModelAparelhos retornarAparelhosController(String pDocumento) {

        return this.daoaparelhos.retornarAparelhoDao(pDocumento);

    }
}
