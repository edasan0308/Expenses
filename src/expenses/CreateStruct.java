/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expenses;

/**
 *
 * @author edasan0308
 */
public class CreateStruct {
    
    private final String data[];
    
    public CreateStruct(String line){     
        data = line.split(","); //データを分割して配列に格納
    }
    
    public String getDate() {
        return data[0];
    } //日付を返す
    
    public String getShop() {
        return data[1];
    } //店名を返す
    
    public String getAmount() {
        return data[2];
    } //金額を返す
    
}
