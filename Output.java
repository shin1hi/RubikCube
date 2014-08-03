public class Output{
  public static void output(int[][] c, int i){
    //0

    System.out.println("\n");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i)][p(i)*p(i+1)*p(i+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+2)][p(i+2)*p(i+4+2)*p(i+5+2)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+1)][p(i+1)*p(i+1+1)*p(i+5+1)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    System.out.println("");

    //1
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i)][p(i)*p(i+1)]));
    System.out.print("   ");
    System.out.print(q(c[p(i)][p(i)*p(i+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+2)][p(i+2)*p(i+4+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+1)][p(i+1)*p(i+5+1)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");

/*


  q(c[p(i)][p(i)*p(i+1)*p(i+5)])  q(c[p(i)][p(i)*p(i+1)])   q(c[p(i)][p(i)*p(i+1)*p(i+2)])

  q(c[p(i)][p(i)*p(i+5)])         q(p(i))                   q(c[p(i)][p(i)*p(i+2)])

  q(c[p(i)][p(i)*p(i+4)*p(i+5)])  q(c[p(i)][p(i)*p(i+4)])   q(c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //2
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i)][p(i)*p(i+1)*p(i+5)]));
    System.out.print("   ");
    System.out.print(q(p(i)));
    System.out.print("   ");
    System.out.print(q(c[p(i)][p(i)*p(i+2)*p(i+4)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print(q(c[p(i+2)][p(i+2)*p(i+2+2)*p(i+4+2)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+2)][p(i+2)*p(i+5+2)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+1)][p(i+1)*p(i+1+1)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+1)][p(i+1)*p(i+5+1)*p(i+4+1)]));
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");
/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



*/
    //3
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i)][p(i)*p(i+5)]));
    System.out.print("   ");
    System.out.print(q(c[p(i)][p(i)*p(i+4)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(p(i+2)));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(p(i+1)));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");
/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //4
    System.out.print("   ");
    System.out.print(q(c[p(i+5)][p(i+5)*p(i+1+5)*p(i+5+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i)][p(i)*p(i+4)*p(i+5)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+4)][p(i+4)*p(i+2+4)*p(i+4+4)]));
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print(q(c[p(i+2)][p(i+2)*p(i+2+2)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+2)][p(i+2)*p(i+1+2)*p(i+2+5)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+1)][p(i+1)*p(i+1+1)*p(i+1+2)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+1)][p(i+1)*p(i+4+1)]));
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");
/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //5

    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+5)][p(i+5)*p(i+5+1)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+4)][p(i+4)*p(i+4+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+2)][p(i+2)*p(i+2+1)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+1)][p(i+1)*p(i+1+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");
/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //6
    System.out.print("   ");
    System.out.print(q(c[p(i+5)][p(i+5)*p(i+5+2)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+5)][p(i+5)*p(i+1+5)*p(i+5+5)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+4)][p(i+4)*p(i+1+4)*p(i+4+2)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+4)][p(i+4)*p(i+4+4)]));
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print(q(c[p(i+2)][p(i+2)*p(i+2+1)*p(i+2+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+3)][p(i+3)*p(i+3+5)*p(i+3+4)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+1)][p(i+1)*p(i+1+4)*p(i+1+2)]));
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");
/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //7
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(p(i+5)));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(p(i+4)));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+3)][p(i+3)*p(i+3+5)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+3)][p(i+3)*p(i+3+4)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");
/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //8
    System.out.print("   ");
    System.out.print(q(c[p(i+5)][p(i+5)*p(i+5+4)*p(i+5+2)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+5)][p(i+5)*p(i+5+5)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+4)][p(i+4)*p(i+4+1)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+4)][p(i+4)*p(i+4+4)*p(i+4+5)]));
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+3)][p(i+3)*p(i+3+1)*p(i+3+5)]));
    System.out.print("   ");
    System.out.print(q(p(i+3)));
    System.out.print("   ");
    System.out.print(q(c[p(i+3)][p(i+3)*p(i+3+4)*p(i+3+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");
/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //9
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+5)][p(i+5)*p(i+5+4)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+4)][p(i+4)*p(i+4+5)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+3)][p(i+3)*p(i+3+1)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+3)][p(i+3)*p(i+3+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");

/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //10
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+5)][p(i+5)*p(i+5+5)*p(i+5+4)]));
    System.out.print("   ");
    System.out.print(q(c[p(i+4)][p(i+4)*p(i+4+1)*p(i+4+5)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print(q(c[p(i+3)][p(i+3)*p(i+3+1)*p(i+3+2)]));
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");

/*


  (c[p(i)][p(i)*p(i+1)*p(i+5)])  (c[p(i)][p(i)*p(i+1)])   (c[p(i)][p(i)*p(i+1)*p(i+2)])

  (c[p(i)][p(i)*p(i+5)])         (p(i))                   (c[p(i)][p(i)*p(i+2)])

  (c[p(i)][p(i)*p(i+4)*p(i+5)])  (c[p(i)][p(i)*p(i+4)])   (c[p(i)][p(i)*p(i+2)*p(i+4)])



}*/
    //11
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");
    //11
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");

    //12
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("正面");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("  ");
    System.out.print("後下");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");
    System.out.print("   ");

    System.out.println("");

  }


  public static String q(int p){
    String n = Color.primeToColor(p);
    return n;
  }
  public static int p(int n){
    return Prime.prime(n%6);
  }








  /*これは使い物にならなかったメソッド、理由は不明
  public static int v(int n,int m,int j,int[][] c){


    // 描写を効率化する為の道具

    int[] color;
    color =new int[n];
    color[0]=(c[p(j+m)][p(j+m)*p(j+1+m)*p(j+5+m)]);
    color[1]=(c[p(j)][p(j)*p(j+1)]);
    color[2]=(c[p(j)][p(j)*p(j+1)*p(j+2)]);
    color[3]=(c[p(j+m)][p(j+m)*p(j+m+5)]);
    color[4]=(p(j+m));
    color[5]=(c[p(j+m)][p(j+m)*p(j+m+2)]);
    color[6]=(c[p(j+m)][p(j+m)*p(j+m+4)*p(j+m+5)]);
    color[7]=(c[p(j+m)][p(j+m)*p(j+m+4)]);
    color[8]=(c[p(j+m)][p(j+m)*p(j+m+2)*p(j+m+4)]);

    return color[n-1];

  }
  */

}
