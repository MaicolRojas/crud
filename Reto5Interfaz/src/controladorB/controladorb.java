/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelob.baile;
import modelob.baileDAO;
import vista.bailevista;

/**
 *
 * @author Maicol
 */
public final class controladorb implements ActionListener{
    baileDAO dao = new baileDAO();
    baile p = new baile();
    bailevista vista = new bailevista();
    DefaultTableModel modelo = new DefaultTableModel();
    
     public controladorb(bailevista v){
         this.vista = v;
         this.vista.mostrarb.addActionListener(this);
         this.vista.nuevob.addActionListener(this);
         this.vista.actualizarb.addActionListener(this);
         listar(vista.tabla);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == vista.mostrarb ){
            listar(vista.tabla);
        }
       if (e.getSource() == vista.nuevob) {
            nuevo();
        }
       if (e.getSource() == vista.actualizarb) {
            JOptionPane.showMessageDialog(null,"Usuario Agregado");
        }
    }
    
    public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        List<baile> lista = dao.listar();
        Object[] Object = new Object[4];
        
        for(int i = 0; i< lista.size(); i++){
            
            Object[0] = lista.get(i).getId();
            Object[1] = lista.get(i).getNombre();
            Object[2] = lista.get(i).getAntiguedad();
            Object[3] = lista.get(i).getDuracion();
            
            
            modelo.addRow(Object);
            
        }
        vista.tabla.setModel(modelo);
    }
    
    void nuevo() {
       
        vista.idb.setText("");
        vista.nombreb.setText("");
        vista.antiguedad.setText("");
        vista.duracion.setText("");
        JOptionPane.showMessageDialog(null,"Usuario Agregado");
    }
}
