/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expenses;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author edasan0308
 */
public class Expenses {

    /**
     * @param args the command line arguments
     */                                                      
    public static void main(String[] args){ 
        
        String dir_path = "./data"; //検索開始したいフォルダのPath(`~Folder`まで書く)
        String extension = ".csv";   //検索したいファイルの拡張子
        File dir = new File(dir_path);
        File files[] = dir.listFiles();
        Arrays.sort(files);
        CreateList DataList = new CreateList(files,extension); //リストの作成
        
        MonthEachSum(DataList);
        SumStatistics(DataList);
    }
    static void MonthEachSum(CreateList DataList) {
        ArrayList<ArrayList<ShopData>> shop = new ArrayList<>();
        ArrayList<ShopData> data = null;
        boolean flag = true;
        
        for(int j=0; j<DataList.ListSize();j++) {
            data = new ArrayList<>();
            for(int i=0; i<DataList.getList(j).DataSize();i++) {
                
                for(int n=0;n<data.size();n++) {
                    if(DataList.getList(j).getData(i).getShop().equals(data.get(n).shopName)){
                        data.get(n).sum += Integer.parseInt(DataList.getList(j).getData(i).getAmount());
                        data.get(n).freq += 1;
                        flag = false;
                        break;
                    }
                }
                
                if(flag == true) {
                    data.add(new ShopData(DataList.getList(j).getData(i).getShop(),Integer.parseInt(DataList.getList(j).getData(i).getAmount())));
                }
                
                flag = true;
            }
            shop.add(data);
        }
        
        for(ArrayList<ShopData> shop1:shop){
            Collections.sort(
            shop1, 
            new Comparator<ShopData>() {
                @Override
                public int compare(ShopData obj1, ShopData obj2) {
                    return obj2.sum - obj1.sum;
                }
            }
        );
        }
        
        int sum = 0;
        for(int i=0; i<shop.size(); i++){
            System.out.println(DataList.getList(i).getDate());
            for (ShopData shop2 : shop.get(i)) {
                System.out.println(shop2.shopName + "   "+shop2.sum +"円    "+shop2.freq+"回");
                sum = sum + shop2.sum;
          }
            System.out.println("合計:"+sum+"円");
            System.out.println("");
            
            sum = 0;
        }

    }
    
    static void SumStatistics(CreateList DataList) {
        ArrayList<ShopData> data = new ArrayList();
        boolean flag = true;
        int freq = 0; //何ヶ月分の統計か記録しておく
        int sum = 0; //全ての金額の合計を数える
        
        for(int j=0; j<DataList.ListSize();j++) { //月ループ
            for(int i=0; i<DataList.getList(j).DataSize();i++) { //日ループ
                
                for(int n=0;n<data.size();n++) { //同じショップ名があるかどうかの走査
                    if(DataList.getList(j).getData(i).getShop().equals(data.get(n).shopName)){
                        data.get(n).sum += Integer.parseInt(DataList.getList(j).getData(i).getAmount());
                        data.get(n).freq += 1;
                        flag = false;
                        break;
                    }
                }
                
                if(flag == true) {
                    data.add(new ShopData(DataList.getList(j).getData(i).getShop(),Integer.parseInt(DataList.getList(j).getData(i).getAmount())));
                }
                
                flag = true;
            }
            freq += 1;
        }
        
        Collections.sort(
            data, 
            new Comparator<ShopData>() {
                @Override
                public int compare(ShopData obj1, ShopData obj2) {
                    return obj2.sum - obj1.sum;
                }
            }
        );
        
        for(int i=0; i<data.size(); i++){
            sum += data.get(i).sum;
        }

        System.out.println(freq+"ヶ月分の統計");
        for(int i=0; i<data.size(); i++){
            System.out.println(data.get(i).shopName + "   " +data.get(i).sum + "円    " +data.get(i).freq+"回   "+data.get(i).sum/data.get(i).freq+"円/回");
        }
        
        System.out.println("");
        System.out.println("合計:"+sum+"円");
        System.out.println("月平均:"+sum/freq+"円");
    }
}