# AbstractTableModel

*AstractTableModel* es un adaptador (ver patrón *Adapter*), donde el cliente es un objeto de tipo JTable, y el objeto adaptado es el objeto cuya información se muestra en la tabla.

```
Aclaración sobre los términos usados en este texto:

- modelo : datos correspondientes a la lógica de negocio, es decir, los objetos cuyos datos se muestran en la tabla.
- adaptador : implementación que hacemos de la clase AbstractTableModel.
- tabla : objeto de tipo JTable donde se muestran los datos del modelo.
```

## Métodos abstractos de *AbstractTableModel*

Según la documentación de **Oracle**, esta clase tiene tres métodos abstractos (y muchos otros implementados). Estos tres métodos son:

- *public int getRowCount();*: devuelve el número de filas que debe mostrar la tabla. Si se está mostrando una lista de elementos, entonces este método devolverá la longitud de la lista.
- *public int getColumnCount();*: devuelve el número de columnas que debe tener la tabla. Lo más recomendable es tener en nuestra clase *adaptador* un array estático con el nombre de las columnas, y devolver la longitud de dicho array.
- *public Object getValueAt(int row, int column);*: devuelve el valor correspondiente a la celda *(row,column)*. 

Además de estos métodos, es recomendable sobreescribir los siguientes:

- [String getColumnName(int column)](https://docs.oracle.com/javase/7/docs/api/javax/swing/table/AbstractTableModel.html#getColumnName(int)): devuelve el nombre de la columna número *column*
- [Class<?> getColumnClass(int columnIndex)](https://docs.oracle.com/javase/7/docs/api/javax/swing/table/AbstractTableModel.html#getColumnClass(int)): devuelve la clase de la columna número *column*
- [boolean isCellEditable(int rowIndex,int columnIndex)](https://docs.oracle.com/javase/7/docs/api/javax/swing/table/AbstractTableModel.html#isCellEditable(int,%20int)): devuelve true cuando queremos que una celda de la tabla (cuya fila y columna son *rowIndex* y *columnIndex*) se pueda editar. En caso contrario devuelve false.
- [void setValueAt(Object aValue,int rowIndex,int columnIndex)](https://docs.oracle.com/javase/7/docs/api/javax/swing/table/AbstractTableModel.html#setValueAt(java.lang.Object,%20int,%20int)): este método está vacío inicialmente, y sólo es necesario implementarlo cuando hay celdas editables en la tabla. Este método se puede utilizar para actualizar los datos del modelo desde la tabla. La idea es la siguiente:
    - Paso 1: se modifica el contenido de una celda en la tabla (JTable) de la ventana. Entonces JTable llama a *setValueAt*.
    - Paso 2: el código dentro de *setValueAt* modifica los datos del modelo.
    - Paso 3: al final de *setValueAt* se debe ejecutar el método *fireTableCellUpdated(rowIndex,columnIndex)*, para hacer saber a la tabla que debe refrescar el contenido de dicha fila/columna. 

Además de los métodos anteriores, puede ser útil añadir un método más al adaptador. Este método no está declarado en la clase *AbstractTableModel*:

- **public void removeRow(int row)**: este método sirve para modificar el modelo desde la tabla. Su funcionamiento es el siguiente:
    - Paso 1: Cuando se desea eliminar una fila de la tabla (y por tanto en el modelo), se ejecuta el método *removeRow* del adaptador.
    - Paso 2: el método *removeRow* elimina el elemento correspondiente del modelo.
    - Paso 3. finalmente ejecuta el método *fireTableRowsDeleted(row,row)*, para que la tabla refresque el contenido mostrado.

-------------
NOTA: El borrado de una fila de la tabla se puede hacer de varias formas:
1. Con un botón borrar: El listener asociado botón ejecuta el método *removeRow* del adaptador.
2. Con un listener para la tabla (ejemplo):
```
tabla.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE){
            int confirmaBorrar = JOptionPane.showConfirmDialog( pnlMain,
                                                        "¿Desea borrar la fila?",
                                                        "Borrado de un elemento",JOptionPane.WARNING_MESSAGE);
            if (confirmaBorrar==JOptionPane.OK_OPTION){
                tabla.getCellEditor().stopCellEditing(); // evita errores de borrado (celda bloquedad por edición)
                adaptador.removeRow(tblPersona.getSelectedRow());
            }
        }
    }
});
```

