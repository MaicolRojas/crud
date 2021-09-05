/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelocon.concurso;
import modelocon.concursoDAO;
import vista.concursovista;

/**
 *
 * @author Maicol
 */
public class controladorcon  implements ActionListener{
    concursoDAO dao = new concursoDAO();
    concurso p = new concurso();
    concursovista vista = new concursovista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public controladorcon(concursovista v){
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
                 
                 vista.idco.setText(""+id);
                 vista.nombreco.setText(nombre);
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
                JOptionPane.showMessageDialog(vista,"Usuario Eliminado");
            }
    }
      
      public void actualizar(){
         
            int id = Integer.parseInt(vista.idco.getText());
            String nombre = vista.nombreco.getText();
      
            p.setId(id);
            p.setNombre(nombre);
            

            int r = dao.Actualizar(p);
            
        if(r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario Actulizado con Exito!!!");
        }else{
            JOptionPane.showMessageDialog(vista,"Usuario Actualizado");
        }
     }
      
      public void agregar(){
        int id = Integer.parseInt(vista.idco.getText());
        String nombre = vista.nombreco.getText();
        
        p.setId(id);
        p.setNombre(nombre);
        
        int r = dao.agregar(p);    
        if(r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario Agregado");
        }else{
            JOptionPane.showMessageDialog(vista,"ERROR!!!");
        }
    }
     
     public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        List<concurso> lista = dao.listar();
        Object[] Object = new Object[4];
        
        for(int i = 0; i< lista.size(); i++){
            
            Object[0] = lista.get(i).getId();
            Object[1] = lista.get(i).getNombre();
            
            
            
            modelo.addRow(Object);
            
        }
        vista.tabla.setModel(modelo);
    }
    
    void nuevo() {
       
        vista.idco.setText("");
        vista.nombreco.setText("");
        
        JOptionPane.showMessageDialog(null,"Limpiando campos....");
    }

    
    
}
