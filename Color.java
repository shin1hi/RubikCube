public class Color{
  int[][] c;












  public Color() {
    this.c= new int[p(5)+1][p(3)*p(4)*p(5)+1];
    for (int i=0;i<p(5)+1;i++){
      for (int j=0;j<1002;j++){
        c[i][j]=0;
      }
    }
  }






















  public static int[][] rotate(int[][] c,int i){
    //表示用回転
    int box              = c[p(i)][p(i)*p(i+1)];
    c[p(i)][p(i)*p(i+1)] = c[p(i)][p(i)*p(i+5)];
    c[p(i)][p(i)*p(i+5)] = c[p(i)][p(i)*p(i+4)];
    c[p(i)][p(i)*p(i+4)] = c[p(i)][p(i)*p(i+2)];
    c[p(i)][p(i)*p(i+2)] = box;

    box                         = c[p(i)][p(i)*p(i+1)*p(i+2)];
    c[p(i)][p(i)*p(i+1)*p(i+2)] = c[p(i)][p(i)*p(i+5)*p(i+1)];
    c[p(i)][p(i)*p(i+5)*p(i+1)] = c[p(i)][p(i)*p(i+4)*p(i+5)];
    c[p(i)][p(i)*p(i+4)*p(i+5)] = c[p(i)][p(i)*p(i+2)*p(i+4)];
    c[p(i)][p(i)*p(i+2)*p(i+4)] = box;


    box                    = c[p(i+1)][p(i)*p(i+1)];
    c[p(i+1)][p(i)*p(i+1)] = c[p(i+5)][p(i)*p(i+5)];
    c[p(i+5)][p(i)*p(i+5)] = c[p(i+4)][p(i)*p(i+4)];
    c[p(i+4)][p(i)*p(i+4)] = c[p(i+2)][p(i)*p(i+2)];
    c[p(i+2)][p(i)*p(i+2)] = box;

    box                           = c[p(i+1)][p(i)*p(i+1)*p(i+2)];
    c[p(i+1)][p(i)*p(i+1)*p(i+2)] = c[p(i+5)][p(i)*p(i+5)*p(i+1)];
    c[p(i+5)][p(i)*p(i+5)*p(i+1)] = c[p(i+4)][p(i)*p(i+4)*p(i+5)];
    c[p(i+4)][p(i)*p(i+4)*p(i+5)] = c[p(i+2)][p(i)*p(i+2)*p(i+4)];
    c[p(i+2)][p(i)*p(i+2)*p(i+4)] = box;
    box                           = c[p(i+2)][p(i)*p(i+1)*p(i+2)];
    c[p(i+2)][p(i)*p(i+1)*p(i+2)] = c[p(i+1)][p(i)*p(i+5)*p(i+1)];
    c[p(i+1)][p(i)*p(i+5)*p(i+1)] = c[p(i+5)][p(i)*p(i+4)*p(i+5)];
    c[p(i+5)][p(i)*p(i+4)*p(i+5)] = c[p(i+4)][p(i)*p(i+2)*p(i+4)];
    c[p(i+4)][p(i)*p(i+2)*p(i+4)] = box;



    //ここから理論部（角の回転）
    box                         = c[p(10)][p(i)*p(i+1)*p(i+2)];
    c[p(10)][p(i)*p(i+1)*p(i+2)] = c[p(10)][p(i)*p(i+5)*p(i+1)];
    c[p(10)][p(i)*p(i+5)*p(i+1)] = c[p(10)][p(i)*p(i+4)*p(i+5)];
    c[p(10)][p(i)*p(i+4)*p(i+5)] = c[p(10)][p(i)*p(i+2)*p(i+4)];
    c[p(10)][p(i)*p(i+2)*p(i+4)] = box;

    int m=1;
    if (i%2==0) int m=-1;

    if (i%3==1){
      c[p(10)][p(i)*p(i+1)*p(i+2)] += (-1)*m;
      c[p(10)][p(i)*p(i+5)*p(i+1)] += m;
      c[p(10)][p(i)*p(i+4)*p(i+5)] += (-1)*m;
      c[p(10)][p(i)*p(i+2)*p(i+4)] += m;
    }else if(i%3==2){
      c[p(10)][p(i)*p(i+1)*p(i+2)] += m;
      c[p(10)][p(i)*p(i+5)*p(i+1)] += (-1)*m;
      c[p(10)][p(i)*p(i+4)*p(i+5)] += m;
      c[p(10)][p(i)*p(i+2)*p(i+4)] += (-1)*m;
    }

    if(c[p(10)][p(i)*p(i+1)*p(i+2)] =
    c[p(10)][p(i)*p(i+5)*p(i+1)] += (-1)*m;
    c[p(10)][p(i)*p(i+4)*p(i+5)] += m;
    c[p(10)][p(i)*p(i+2)*p(i+4)] += (-1)*m;

    

    return c;
  }


  public static int[] callCorner(int face){
    int[] n= new int[4];
    int c =0;//counter
    for (int i=0;i<2;i++){
      for(int j=0;j<2;j++){
        for(int k=0;k<2;k++){
          int box=p(3*i)*p(3*j+1)*p(3*k+2);
          if (box%face == 0) {
            n[c]=box;
            c++;
          }
        }
      }
    }
  }



  public static int[][] r90(int[][] n,int i){
    if (i%2==0) return rotate(n,i);
    else return rotate(rotate(rotate(n,i),i),i);
  }


  public static int[][] r180(int[][] n,int i){
    for (int j=0;j<2;j++) n = rotate(n,i);
    return n;
  }


  public static int[][] r270(int[][] n,int i){
    if (i%2==1) return rotate(n,i);
    else return rotate(rotate(rotate(n,i),i),i);
  }

  public static /*int[]*/void numclose(int[] n){
    int[] m = new int[n.length];
    for (int i=0;i<p(n.length);i++){
    }
  }

  public static int p(int n){
    return Prime.prime(n%6);
  }

  public static String primeToColor(int p) {
    String n=null;
    switch (P.arcp(p)){
      case 0:n="\u001b[34m ◆ \u001b[00m";
      break;
      case 1:n="\u001b[35m ◆ \u001b[00m";
      break;
      case 2:n="\u001b[32m ◆ \u001b[00m";
      break;
      case 3:n="\u001b[00m ◇ \u001b[00m";
      break;
      case 4:n="\u001b[31m ◆ \u001b[00m";
      break;
      case 5:n="\u001b[33m ◆ \u001b[00m";
      break;
    }
    return n;




  }
}
