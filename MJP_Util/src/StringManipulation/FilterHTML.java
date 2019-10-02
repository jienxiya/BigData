/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

/**
 *
 * @author pallerma_sd2082
 */
public class FilterHTML {

    public String removeHTMLTag(String str) {
      str = str.replaceAll("\\<.*?\\>", "");
      return str;
    }
}
