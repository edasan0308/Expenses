/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expenses;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edasan0308
 */
public class CreateData {
    
    private List<CreateStruct> Data = new ArrayList(); //月データを格納
    private String Date;
    
    public CreateData(BufferedReader br,String Date) {
        this.Date = Date.substring(0,6);
        try {
            String ld;
            while((ld = br.readLine()) != null) {
                if(ld.contains("今枝　佑樹　様") != true && ld.contains(",,,") != true){
                    Data.add(new CreateStruct(ld));
                } //初めの行、途中行、最終行に含まれる余分な行を取り除く
            }
        } catch (IOException ex) {
            Logger.getLogger(CreateData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    CreateStruct getData(int num) {
        return Data.get(num);
    }
    
    int DataSize() {
        return Data.size();
    }
    
    String getDate() {
        return Date;
    }
}
