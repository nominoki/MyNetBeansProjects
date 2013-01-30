import java.io.*; 
import java.util.*; 
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Norihiro Kajita
 */
public class PostCodeFileSearcher {
    
    /* フィールド */
    private String fileName;                    // ファイル名
    private File csvFile;                       // ファイル
    private List<String[]> fileData;            // ファイルデータ（格納先）
    private String searchWord;                  // 検索文字列
    private int rowNum;                         // ファイルの行数
    private int columnNum;                      // ファイルの列数（要素数）
    
    /**
     * コンストラクタ
     * 引数：ファイル名、検索文字列
     */
    public PostCodeFileSearcher(String fileName, String searchWord){
        this.fileName = fileName;
        this.searchWord = searchWord;
        csvFile = new File(fileName);
        rowNum = 0;
        columnNum = 0;
    }
        
    /**
     * csvファイルから検索文字列と一致するデータを
	 * 読み込む。
     */
    private void readFileData() throws Exception {
        
    	String[] tempForSearch;              // 検索用データの一時格納場所
    	
        try {
        	// バッファリーダーのインスタンス生成
            BufferedReader bReader = new BufferedReader(new FileReader(csvFile));
			
        	// ファイルデータを格納するリストのインスタンスを生成
            fileData = new ArrayList<String[]>(); 
            
            // 最終行までファイルを読み込む
            String fileLine = null;
            while ((fileLine = bReader.readLine()) != null) {
                
            	// 検索文字列に何も入っていない場合、csvファイル全件読み込む
                if (searchWord.length() < 1){
                    
                    // 読み込んだ文字列をカンマで分割して、リストに格納
                    fileData.add(fileLine.split(","));
                
                    // 読み込んだ行数をカウント
                    rowNum ++;
                
                // 検索文字列が空欄でない場合
                } else {
                	
                	// 読み込んだ文字列をカンマで分割し、検索用配列に格納
                    tempForSearch = fileLine.split(",");
                	
                	// 検索用配列の中を指定文字列で検索（検索用配列の長さ分繰り返す）
                    for (int cntCol = 0 ; cntCol < tempForSearch.length ; cntCol++){
                    	
                    	// 検索文字列が見つかった場合
                        if (tempForSearch[cntCol].indexOf(searchWord) != -1){   
                        
                            // 読み込んだ文字列をカンマで分割して、リストに格納
                            fileData.add(fileLine.split(","));
                
                            // 読み込んだ行数をカウント
                            rowNum ++;
                    		
                        	// 検索処理を抜ける
                            break;
                        }
                    }
                }
            }
            
        	// 読み込みファイルを閉じる
            bReader.close();
        
        // 例外処理
        // ファイルが見つからない場合
        } catch (FileNotFoundException e1) {
        	// メッセージを出力
            System.out.println("ファイルが見つかりません。"); 
        
        // 入出力エラーの場合
        } catch (IOException e1) {
            // メッセージを出力
        	System.out.println("入出力エラーです。"); 
        } catch (ArrayIndexOutOfBoundsException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
            
    }
    
    /**
     * ファイルデータを取得する
     */
    public List<String[]> getFileData() throws Exception{
        
    	// ファイルデータが存在しない場合
    	if(fileData == null){
    		
    		// ファイルデータ読込処理            
    		this.readFileData();
        }
    	
    	// ファイルデータのリストを返り値に設定
        return fileData;
        
    }
    
	/**
	* ファイルデータの行数を取得
	*/
    public int getRowNum() throws Exception{
        
    	// ファイルデータが存在しない場合
    	if(fileData == null){
    		
    		// ファイルデータ読込処理
            this.readFileData();
        }
    	
    	// 行数を返り値に設定
        return this.rowNum;
    }
    
}
