/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eletronica;

import Util.DataFormart;
import javax.swing.JOptionPane;



/**
 *
 * @author Matheus
 */
public class Eletronica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Util.DataFormart x = new DataFormart();
        
        String dataNormal = "18-10-2022 16:45:35";
        String dataInvertida = "1997-08-13";
        
        JOptionPane.showMessageDialog(null, x.dataMysql(dataNormal));
        //JOptionPane.showMessageDialog(null, x.dataNormal(dataInvertida));
        
    }
    
}
