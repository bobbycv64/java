package cv64.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public abstract class SomeTable extends JTable {

  public SomeTable() {
    setDefaultRenderer(Color.class, new ColorTableCellRenderer());
    setRowHeight(HEIGHT);
    getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
    setFont(new Font("Arial", Font.BOLD, 18));
  }

  class ColorTableCellRenderer implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
        panel_.setBackground((Color)value);
        return panel_;
    }
    private JPanel panel_ = new JPanel();
  }

  public static final int MINIMUM = 0;
  public static final int MAXIMUM = 100;
  public static final int HEIGHT = 20;
}
