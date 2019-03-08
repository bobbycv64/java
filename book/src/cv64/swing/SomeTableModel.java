package cv64.swing;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class SomeTableModel extends AbstractTableModel {

  public SomeTableModel(Object[][] data, String[] columnNames) {
    data_ = data;
    columnNames_ = columnNames;
    fireTableStructureChanged();
  }

  public Class getColumnClass(int column) {
    Object object = getValueAt(0, column);
    if (object == null) return null;
    return object.getClass();
  }

  public int getColumnCount() {
    if (columnNames_ == null) return 0;
    return columnNames_.length;
  }

  public String getColumnName(int column) {
    return columnNames_[column];
  }

  public String getHeaderName(int column) {
    return table_.getColumnModel().getColumn(column).getHeaderValue().toString();
  }

  public int getRowCount() {
    return data_.length;
  }

  public JTable getTable() {
    return table_;
  }

  public Object getValueAt(int row, int column) {
    return data_[row][column];
  }

  public boolean isCellEditable(int row, int column) {
    return true;
  }

  void setChanged() {
    fireTableStructureChanged();
  }

  public void setValueAt(Object value, int row, int column) {
    data_[row][column] = value;
    fireTableCellUpdated(row, column);
  }

  public Object[][] getData() { return data_; }
  public String[] getColumnNames() { return columnNames_; }

  private String[] columnNames_;
  private Object[][] data_;
  private JTable table_;
  private String[] attributeNames_;
}
