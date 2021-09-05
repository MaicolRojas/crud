/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloc.cantante;
import modeloc.cantanteDAO;
import vista.cantantevista;

/**
 *
 * @author Maicol
 */
public class controladorc implements ActionListener{

    cantanteDAO dao = new cantanteDAO();
    cantante p = new cantante();
    cantantevista vista = new cantantevista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public controladorc(cantantevista v){
         this.vista = v;
         this.vista.mostrarb.addActionListener(this);
         this.vista.guardarb.addActionListener(this);
         this.vista.editarb.addActionListener(this);
         this.vista.actualizarb.addActionListener(this);
         this.vista.eliminarb.addActionListener(this);
         this.vista.nuevob.addActionListener(this);
         listar(vista.tabla);
     }
    
    
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
                 String apellido = (String) vista.tabla.getValueAt(fila, 2);
                 String nacionalidad = (String) vista.tabla.getValueAt(fila, 3);
                 
                 vista.idc.setText(""+id);
                 vista.nombrec.setText(nombre);
                 vista.apellidoc.setText(apellido);
                 vista.nacionalidadc.setText(nacionalidad);
      
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
                int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                dao.delete(id);
                
            }
    }
    
    public void actualizar(){
         
            int id = Integer.parseInt(vista.idc.getText());
            String nombre = vista.nombrec.getText();
            String apellido = vista.apellidoc.getText();
            String nacionalidad = vista.nacionalidadc.getText();
           
            
            p.setId(id);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setNacionalidad(nacionalidad);

            int r = dao.Actualizar(p);
            
        if(r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario Actulizado con Exito!!!");
        }else{
            JOptionPane.showMessageDialog(vista,"Usuario Actualizado");
        }
     }
    
    public void agregar(){
        int id = Integer.parseInt(vista.idc.getText());
        String nombre = vista.nombrec.getText();
        String apellido = vista.apellidoc.getText();
        String nacionalidad = vista.nacionalidadc.getText();
        p.setId(id);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setNacionalidad(nacionalidad);
        
        int r = dao.agregar(p);    
        if(r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario Agregado");
        }else{
            JOptionPane.showMessageDialog(vista,"ERROR!!!");
        }
    }
    
    public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        List<cantante> lista = dao.listar();
        Object[] Object = new Object[4];
        
        for(int i = 0; i< lista.size(); i++){
            
            Object[0] = lista.get(i).getId();
            Object[1] = lista.get(i).getNombre();
            Object[2] = lista.get(i).getApellido();
            Object[3] = lista.get(i).getNacionalidad();
            
            
            modelo.addRow(Object);
            
        }
        vista.tabla.setModel(modelo);
    }
    
    void nuevo() {
       
        vista.idc.setText("");
        vista.nombrec.setText("");
        vista.apellidoc.setText("");
        vista.nacionalidadc.setText("");
        JOptionPane.showMessageDialog(null,"Limpiando campos....");
    }
    
}
