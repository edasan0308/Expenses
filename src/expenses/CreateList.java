/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expenses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edasan0308
 */
public class CreateList {
    
    List<CreateData> List = new ArrayList(); //月一覧を作成
    
    public CreateList(File data[],String extention) {
        BufferedReader br;
        
        for(int i=0;i<data.length; i++) {

            try {
                if(data[i].getName().endsWith(extention)){
                    br = new BufferedReader(new FileReader(data[i].getPath()));
                    List.add(new CreateData(br,data[i].getName()));
                    //月ごとのリスト[DataList] >> その月のリスト[CreateData] >> 1日の構造体[CreateStruct]
                } //拡張子CSVのもののみリストに追加
            } 
            
            catch (FileNotFoundException ex) {
                Logger.getLogger(CreateList.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
            
    }
    
    CreateData getList(int num) {
        return List.get(num);
    }
    
    int ListSize() {
        return List.size();
    }
    
 }