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
         this.vista.guardarb.addActionListener(this);
         this.vista.editarb.addActionListener(this);
         this.vista.actualizarb.addActionListener(this);
         this.vista.eliminarb.addActionListener(this);
         this.vista.nuevob.addActionListener(this);
         listar(vista.tabla);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == vista.mostrarb ){
            limpiar();
            listar(vista.tabla);
        }
       if (e.getSource() == vista.nuevob) {
            nuevo();
        }
       if(e.getSource() == vista.guardarb ){
            agregar();
            limpiar();
            listar(vista.tabla);
        }
       
       if(e.getSource() == vista.editarb){
             int fila = vista.tabla.getSelectedRow();
             if(fila == -1){
                  JOptionPane.showMessageDialog(vista,"Debe Seleccionar una Fila");
             }else{
                 int id = Integer.parseInt((String)vista.tabla.getValueAt(fila, 0).toString());
                 String nombre = (String) vista.tabla.getValueAt(fila,1);
                 int antiguedad =Integer.parseInt((String)vista.tabla.getValueAt(fila,2).toString());
                 int duracion =Integer.parseInt((String)vista.tabla.getValueAt(fila,3).toString());
                 
                 vista.idb.setText(""+id);
                 vista.nombreb.setText(nombre);
                 vista.antiguedad.setText(""+antiguedad);
                 vista.duracion.setText(""+duracion);
                 
                         
             }
         }
       if(e.getSource() == vista.actualizarb){
            actualizar();
            limpiar();
            listar(vista.tabla);
         }
       if(e.getSource() == vista.eliminarb){
            delete();
            limpiar();
            listar(vista.tabla);
        }
    }
    void limpiar(){
        for(int i = 0; i < vista.tabla.getRowCount(); i++){
            
            modelo.removeRow(i);
            i = i - 1;
            
        }
    }
    
    public void delete(){
        int fila = vista.tabla.getSelectedRow();
           
            if(fila == -1){
                  JOptionPane.showMessageDialog(vista,"Debe Seleccionar una usuario");
             }else{
                 String nombre =  (String) vista.tabla.getValueAt(fila, 1).toString();
                dao.delete(nombre);
                JOptionPane.showMessageDialog(vista,"Usuario Eliminado");
            }
    }
    
     public void actualizar(){
         
            int id = Integer.parseInt(vista.idb.getText());
            String nombre = vista.nombreb.getText();
            int antiguedad = Integer.parseInt(vista.antiguedad.getText());
            int duracion = Integer.parseInt(vista.duracion.getText());
           
            
            p.setId(id);
            p.setNombre(nombre);
            p.setAntiguedad(antiguedad);
            p.setDuracion(duracion);

            int r = dao.Actualizar(p);
            
        if(r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario Actulizado con Exito!!!");
        }else{
            JOptionPane.showMessageDialog(vista,"Usuario Actualizado");
        }
     }
    
    public void agregar(){
        int id = Integer.parseInt(vista.idb.getText());
        String nombre = vista.nombreb.getText();
        int antiguedad = Integer.parseInt(vista.antiguedad.getText());
        int duracion = Integer.parseInt(vista.duracion.getText());
        p.setId(id);
        p.setNombre(nombre);
        p.setAntiguedad(antiguedad);
        p.setDuracion(duracion);
        
        int r = dao.agregar(p);    
        if(r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario Agregado");
        }else{
            JOptionPane.showMessageDialog(vista,"ERROR!!!");
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
        JOptionPane.showMessageDialog(null,"Limpiando campos....");
    }
}
