

import java.io.*;





public class RubikCube{
  public static void main(String[] Args){
    int[][] c = new int[p(5)+1][1002];/*==p(3)*p(4)*p(5)+1*/



    c=InputData.defaultState();



    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try{
      String line="";
      while(line!="escape"){
        int i = 0;



        Output.output(c,i);



        line = reader.readLine();
        if (line.charAt(0)=='r') Color.r90(c,Integer.parseInt(""+line.charAt(1)));
        if (line.charAt(0)=='i') i=(Integer.parseInt(""+line.charAt(1)));
      }
    } catch (Exception e){}
  }












  public static int p(int n){
    return Prime.prime(n%6);
  }
}









/* 初期思考の墓場
//まず上面の十字を揃えます
int i=0;
System.out.println(COLOR[i] +"が中心の面を上にし、\n中心が"+ COLOR[i+2] +"の面と" + COLOR[i+4] +"の面を手前にして置いてください");

//test
color = right90(color);
葬式終わり
*/
