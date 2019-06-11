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
public class ShopData {

    String shopName;
    int sum = 0;
    int freq = 1;
    
    ShopData(String shopName,int num) {
        this.shopName = shopName;
        this.sum = num;
    }
}
