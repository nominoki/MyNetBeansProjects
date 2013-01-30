
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
 * @author Norihiro Kajita
 */
public class PostCodeFileEditor {
    
	/* フィールド */
    private String fileName;                    // ファイル名
    private File csvFile;                       // ファイル
    private int  numRow;						// 

    
    /**
     * コンストラクタ
     * @param ファイル名
     * @throws Exception
     */
    public PostCodeFileEditor(String fileName){
        this.fileName = fileName;
        csvFile = new File(fileName);
    }
    
    public String format(String[] item) {
		String line = item[0];
		for (int col = 1; col < item.length; col++)
			line += "," + item[col];
        return line;
    }

    public void addData(String[] item) {
        try { 
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true));
            PrintWriter pw = new PrintWriter(bw);
        	
        	if (checkBlank(item) == true){
            	bw.write(format(item));
                bw.newLine();
               
        	}
        	
            bw.close();
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "ファイル保存に失敗しました");
        }
    }
        
	public boolean checkBlank(String[] item) {
		
		boolean isNotAllBlank = false;
		
		for (int cntItem = 0 ; cntItem < item.length ; cntItem ++) {
			if (item[cntItem].length() > 1){
				isNotAllBlank = true;
			}
		}
		
		return isNotAllBlank;
	}
	
	public void deleteData(String[][] selectedData) {
		
            try { 
                String tempFileName = "temp.csv";
		File tempFile = new File(tempFileName);
		boolean isDeleted = false;
		String[] selectedRowData = new String[selectedData.length];
			
		for (int cntRow = 0; cntRow < selectedData.length; cntRow++){
                    selectedRowData[cntRow] = format(selectedData[cntRow]);
		}
		// CSV読み込み
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
			
		// 上書き保存
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, false));
        	
		String fileLine = null;
		while((fileLine = br.readLine()) != null){
                    isDeleted = false;
                    for(int rowNum = 0 ; rowNum < selectedRowData.length ; rowNum ++){
                        if(fileLine.equals(selectedRowData[rowNum])){
                            isDeleted = true;
			}
                    }
				
                    if(isDeleted == false){
                        bw.write(fileLine);
                        bw.newLine();
                    }
		}
			
		br.close();
                bw.close();
			
		if (csvFile.exists() == true && tempFile.exists() == true){
                    csvFile.delete();
                    tempFile.renameTo(csvFile);
		}
			
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "ファイル保存に失敗しました");
        }
    }	
}
