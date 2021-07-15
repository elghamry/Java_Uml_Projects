import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableSaw {
    public static void main(String[] args) {
        try {
            Table titanicData = Table.read ().csv ("src/main/resources/titanic.csv");
            List<Integer> newValues = new ArrayList<>();
            Column<?> values = titanicData.column("sex");
            for (Object obj : values) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.equals ("female"))
                        newValues.add (1);
                    else
                        newValues.add (0);
                }

            }
            Integer[] g = new Integer[newValues.size()];
            g = newValues.toArray(g);
            titanicData.replaceColumn("sex", IntColumn.create("gender",g));
            System.out.println(titanicData.retainColumns("pclass","survived","name","age","gender","fare","embarked").summary());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}