import java.io.*; 
import java.util.*; 
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Norihiro Kajita
 */
public class PostCodeFileReader {
    
    /* 変数 */
    private String fileName;                // ファイル名
    private File csvFile;                   // ファイル
    private List<String[]> fileData;        // ファイルデータ（格納先）
    private String searchWord;              // 検索文字列
    private int rowNum;                     // ファイルの行数
    private int columnNum;                  // ファイルの列数（要素数）
    
    /**
     * コンストラクタ
     * @param ファイル名
     * @throws Exception
     */
    public PostCodeFileReader(String fileName, String searchWord){
        this.fileName = fileName;
        this.searchWord = searchWord;
        csvFile = new File(fileName);
        rowNum = 0;
        columnNum = 0;
    }
        
    /**
     * csvデータを読み込むメソッド
     * @throws Exception
     */
    private void readFileData() throws Exception {
        
        try {          
            BufferedReader bReader = new BufferedReader( new FileReader( csvFile ) );

            fileData = new ArrayList<String[]>(); 
            
            // 最終行までファイルを読み込む
            String fileLine = null;    
            while ((fileLine = bReader.readLine()) != null) {
                
                // 読み込んだ行に、対象文字列が含まれているか検索
                // 対象文字列が含まれている場合
                if ((fileLine.indexOf(searchWord) != -1) || searchWord.length() < 1){
                    
                    // 読み込んだ文字列をカンマで分割して、リストに格納
                    fileData.add(fileLine.split(","));
                    
                    // 行数のカウント
                    rowNum = rowNum + 1; 
                }
            }
            
            bReader.close();
          
        } catch (FileNotFoundException e1) {
            System.out.println("ファイルが見つかりません。"); 
            e1.printStackTrace();
        } catch (IOException e1) {
            System.out.println("入出力エラーです。"); 
            e1.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
            
    }
    
    /**
     * ファイルデータを取得する（引数なし）
     */
    public List<String[]> getFileData() throws Exception{
        if(fileData == null){
            this.readFileData();
        }
        return fileData;
        
    }
    
    public int getRowNum() throws Exception{
        if(fileData == null){
            this.readFileData();
        }
        return this.rowNum;
    }
    
}
