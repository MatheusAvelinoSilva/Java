/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class DataFormart {

    public String dataMysql(String data) {

        //13-08-1997 01:00:00
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6,10);
        
        String hora = data.substring(11, 13);
        String minuto = data.substring(14, 16);
        String segundos = data.substring(17);

        return ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundos;

    }

    public String dataNormal(String data) {

        //1997-08-13
        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8);

        return dia + "-" + mes + "-" + ano;

    }

    public String pegarData() {

        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd-MM-yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

        return data + " " + hora;

    }
}
