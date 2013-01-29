
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author square-free
 */
public class PostCodeFileWriter {
        /* フィールド */
    private String fileName;                    // ファイル名
    private File csvFile;                       // ファイル
    private int  numRow;

    
    /**
     * コンストラクタ
     * @param ファイル名
     * @throws Exception
     */
    public PostCodeFileWriter(String fileName){
        this.fileName = fileName;
        csvFile = new File(fileName);
    }
    
    public String format(String[] item) {
         String line = item[0];
         for (int col = 1; col < item.length; col++)
            line += "," + item[col];
            return line + "\n";
    }

    public void saveData(String[] item) {
        try { 
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true));
            PrintWriter pw = new PrintWriter(bw);
            bw.write(format(item));
            bw.close();
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "ファイル保存に失敗しました");
        }
    }
        
    
    
}
