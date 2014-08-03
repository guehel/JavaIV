package tp2.reseau.vue;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel implements TableModelListener{
	
	private String[] columnNames  = null;
	private Object[][] data = null;
	

	   public TableModel(String[] columnNames, Object[][] data) {
		super();
		this.columnNames = columnNames;
		this.data = data;
	}

	public int getColumnCount() {
	        return columnNames .length;
	    }

	    public int getRowCount() {
	        return data.length;
	    }

	    public String getColumnName(int col) {
	        return columnNames [col];
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }

	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }
	    public void setValueAt(Object value, int row, int col) {
	        data[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }

		public void setData(Object[][] data) {
			this.data = data;
			for(int i = 0; i<data.length; i++){
				for(int j = 0; j<data[0].length; j++){
					setValueAt(data[i][j], i, j);
				}
			}
			 fireTableDataChanged();
		}

		@Override
		public void tableChanged(TableModelEvent e) {
			// TODO Auto-generated method stub
			
		}

	    

}
