package pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
//@AllArgsConstructor
@NoArgsConstructor
public class Update implements Serializable{
    public String tablename;
    public String columnname;
    public String result;
    public String shackles;

    public Update(String table, String column, String result, String shackles){
        this.tablename=table;
        this.columnname=column;
        this.result=result;
        this.shackles=shackles;
    }
    public String getColumn() {
        return columnname;
    }

    public String getResult() {
        return result;
    }

    public String getTable() {
        return tablename;
    }

    public String getShackles() {
        return shackles;
    }

    public void setColumn(String column) {
        this.columnname = column;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTable(String table) {
        this.tablename = table;
    }

    public void setShackles(String shackles) {
        this.shackles = shackles;
    }

    @Override
    public String toString() {
        return "Update{" +
                "tablename='" + tablename + '\'' +
                ", columnname='" + columnname + '\'' +
                ", result='" + result + '\'' +
                ", shackles='" + shackles + '\'' +
                '}';
    }
}
