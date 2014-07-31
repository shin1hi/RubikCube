import java.io.*;

//UBUNTU has developped this.

public class InputData{
  public static final char[] COLOR = {'青','橙','緑','白','赤','黄'};
  public static int[][] color;






  public static int[][] defaultState(){

    //デフォルトの状態を呼び出します

    int[][] c = new int[p(5)+1][1002];/*==p(3)*p(4)*p(5)+1*/
    int m;
    for (int i=0;i<6;i++){

       /*遊び
       if (i%2==0){*/
      //表示用　の初期化
      for (int j=0;j<6;j++){
            m = 0;
            if (j==2||j==5)m=1;
            else if (j==0||j==3)continue;
            c[p(i)][p(i)*p(i+j)*p(i+j+1+m)]=p(i);
            c[p(i)][p(i)*p(i+j)]=p(i);
      }

      //理論　角　の初期化
      for (int i=0;i<2;i++){
        for(int j=0;j<2;j++){
          for(int k=0;k<2;k++){
            c[0][p(3*i)*p(3*j+1)*p(3*k+2)] = p(3*i)*p(3*j+1)*p(3*k+2);

            }
          }
        }
      }
       /*遊び
       else {
         c[p(i)][p(i)*p(i+1)*p(i+2)]=p(i);
         c[p(i)][p(i)*p(i+4)*p(i+2)]=p(i);
         c[p(i)][p(i)*p(i+4)*p(i+5)]=p(i);
         c[p(i)][p(i)*p(i+5)*p(i+1)]=p(i);
         c[p(i)][p(i)*p(i+1)]=p(i);
         c[p(i)][p(i)*p(i+2)]=p(i);
         c[p(i)][p(i)*p(i+4)]=p(i);
         c[p(i)][p(i)*p(i+5)]=p(i);

       }*/

    }
    return c;

  }



  public static int[][] inputData(int[][] c){

    //以下　コマンドラインからデータ入力





    color = new int[COLOR.length][9];


    BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    String line;
    try{
      int i=0;
      while(i<COLOR.length){
        System.out.println(COLOR[i] +"が中心の面を上にし、"+ COLOR[(i+4)%6] +"の面を手前にして置いてください");
        System.out.println("中心が"+ COLOR[i] +"の面の色を左上から時計回りに続けて漢字八文字で入力してください。");
        System.out.println("色は、　青・橙・緑・白・赤・緑　から選んでください");
        line =reader.readLine();

        //color[][] に代入
        if (line.length()!=8){
          System.out.println("もう一度入力してください。");
          continue;
        }

        for (int j=0;j<8;j++){
          for (int k=0;k<COLOR.length;k++)  {
            if (COLOR[k]!=line.charAt(j)) continue;
            color[i][j+1] = k;

          }
        }
        color[i][0] = i;


        //色を素数として表し、配列に代入　　　
        c[p(i)][p(i)*p(i+5)*p(i+1)] = Color.p(color[i][1]);
        c[p(i)][p(i)*p(i+1)]        = Color.p(color[i][2]);
        c[p(i)][p(i)*p(i+2)*p(i+1)] = Color.p(color[i][3]);
        c[p(i)][p(i)*p(i+2)]        = Color.p(color[i][4]);
        c[p(i)][p(i)*p(i+2)*p(i+4)] = Color.p(color[i][5]);
        c[p(i)][p(i)*p(i+4)]        = Color.p(color[i][6]);
        c[p(i)][p(i)*p(i+5)*p(i+4)] = Color.p(color[i][7]);
        c[p(i)][p(i)*p(i+5)]        = Color.p(color[i][8]);

        i++;

        



        //理論　角 c[0][]　へ代入
        for (int h=0;h<2;h++){
          for(int j=0;j<2;j++){
            for(int k=0;k<2;k++){
              int cc=p(3*h)*p(3*j+1)*p(3*k+2);
              c[0][cc] = c[p(3*h)][cc] * c[p(3*j+1)][cc] * c[p(3*k)+2][cc] ;
              if     (arcp(c[p(3*h)][cc])%3==0) continue;
              else if(arcp(c[p(3*j)+1][cc])%3==0 && (j+k+h)%6 ==3) c[0][cc]+=1;
              else if(arcp(c[p(3*j)+1][cc])%3==0 && (j+k+h)%6 ==0) c[0][cc]+=2;
              else if(arcp(c[p(3*k)+2][cc])%3==0 && (j+k+h)%6 ==0) c[0][cc]+=1;
              else if(arcp(c[p(3*k)+2][cc])%3==0 && (j+k+h)%6 ==3) c[0][cc]+=2;//あやしい


              }
            }
          }
        }



        //理論　辺　c[][] へ代入
        // 0= UP ,  2 =FRONT ,1 = RIGHT,
        // 3= DOWN, 5 =BACK  ,4 = LEFT,

        for (int i = 0 ; i<6 ; i++){
          for (int j= i+1; j<6 ;j++){
            if (j-i==3)continue; //裏の関係にある面の消去
            int ee = p(i)*p(j);
            c[0][cc] = c[p(i)][cc]*c[j][cc];
            if (arcp(c[p(i)][cc])
          }
        }





      }





    }catch (Exception e){ System.out.println("正しく入力してください");}
    return c;

  }








  public static int p(int n){

  //素数を返す
  //対数を用いるとまだまだ時間短縮が可能
    return Prime.prime(n%6);
  }













  /*
  public static int[][] topAll90(int[][] c){


    //以下試作機一号（素数を使っていないので非常に出来が悪い）
    //上から見て時計回りに90度置き換えるメソッド


    int[][] x=new int[1][9];
    int a;

    //上面を回転
    a=c[0][8];
    for(int i=0;i<3;i++)
    c[0][8-2*i]=c[0][6-2*i];
    c[0][2]=a;

    a=c[0][7];
    for(int i=0;i<3;i++)
    c[0][7-2*i]=c[0][5-2*i];
    c[0][1]=a;


    //側面を回転
    for (int i=0;i<8;i++){
      x[0][i+1]=c[5][i+1];
    }
    for(int i=0;i<8;i++){
      c[5][i+1]=c[3][(i+5)%8+1];
    }
    for(int i=0;i<8;i++){
      c[3][(i+5)%8+1]=c[4][i+1];
    }
    for(int i=0;i<8;i++){
      c[4][i+1]=c[2][(i+1)%8+1];
    }
    for(int i=0;i<8;i++){
      c[2][(i+1)%8+1]=x[0][i+1];
    }


    //側面の中心を回転
    x[0][0]=c[5][0];
    c[5][0]=c[3][0];
    c[3][0]=c[4][0];
    c[4][0]=c[2][0];
    c[2][0]=x[0][0];

    //下面を回転
    a=c[1][1];
    for(int i=0;i<3;i++)
    c[1][2*i+1]=c[1][3+2*i];
    c[1][7]=a;

    a=c[1][2];
    for(int i=0;i<3;i++)
    c[1][2*i+2]=c[1][2*i+4];
    c[1][8]=a;


    return c;
  }





  //右手前の面だけを時計回りに90度回転するメソッド
  public static int[][] right90(int[][] c){
    int[][] x=new int[1][3];
    int b;

    b=c[2][1];
    for(int i=0;i<3;i++)
    c[2][2*i+1]=c[2][2*i+3];
    c[2][7]=b;

    b=c[2][2];
    for(int i=0;i<3;i++)
    c[2][2*i+2]=c[2][2*i+4];
    c[2][8]=b;



    for (int i=0;i<3;i++){
      x[0][i]=c[0][(i+4)%8+1];
    }
    for(int i=0;i<3;i++){
      c[0][(i+4)%8+1]=c[4][(i+6)%8+1];
    }
    for(int i=0;i<3;i++){
      c[4][(i+6)%8+1]=c[1][(i+6)%8+1];
    }
    for(int i=0;i<3;i++){
      c[1][(i+6)%8+1]=c[5][(i+4)%8+1];
    }
    for(int i=3;i<3;i++){
      c[5][(i+4)%8+1]=x[0][i];
    }
    return c;
  }*/
}
