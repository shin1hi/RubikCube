public class P {




  
  public static int p(int n){
    return Prime.prime(n%6);
  }




  public static int arcp(int p){
    return (Prime.arcPrime(p))%6;
  }





  public static int[] decompose4(int x){
    //initialize
    int[] n=new int[4];
    int c = 0;
    for (int i=0;i<4;i++){
      if (x>30030) n[i]=-1;// decompose exception
      else         n[i]=0;
    }

    //decompose
    for(int i=0;i<6;i++){
      if (x%(P.p(i))==0){
        x=x/(P.p(i));
        n[c]=P.p(i);
        c++;
      }
    }

    return n;
  }

}
